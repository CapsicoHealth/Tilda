/* ===========================================================================
 * Copyright (C) 2025 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.utils.gcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.channels.Channels;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import tilda.utils.DurationUtil;
import tilda.utils.NumberFormatUtil;

/**
 * A Reader wrapper that streams data from multiple GCS CSV files and provides progress tracking.
 * This is designed to work seamlessly with PostgreSQL's CopyManager.copyIn() method.
 * 
 * Features:
 * - Transparently handles multiple GCS files (from BQ export)
 * - Tracks lines/records processed
 * - Tracks bytes/characters processed
 * - Provides progress reporting via logging
 * - Zero-copy streaming (no local temp files)
 * 
 * Example usage:
 * <pre>
 * GCSStreamingReader reader = new GCSStreamingReader(
 *   result._gcsUris, 
 *   result._totalBytes,
 *   10_000  // Log every 10K lines
 * );
 * 
 * CopyManager copyManager = new CopyManager(connection);
 * copyManager.copyIn("COPY table FROM STDIN CSV", reader);
 * 
 * LOG.info("Imported " + reader.getLinesProcessed() + " lines, " + 
 *          reader.getBytesProcessed() + " bytes");
 * </pre>
 */
public class GCSStreamingReader extends Reader
  {
    protected static final Logger LOG = LogManager.getLogger(GCSStreamingReader.class.getName());

    private final List<String> _gcsUris;
    private final long         _totalBytes;
    private final int          _logFrequency;
    
    private int                _currentFileIndex = 0;
    private BufferedReader     _currentReader    = null;
    private Storage            _storage          = null;
    
    // Progress tracking
    private long               _linesProcessed   = 0;
    private long               _bytesProcessed   = 0;
    private long               _startTime        = 0;
    private long               _lastLogTime      = 0;
    
    // For line counting - we need to track partial lines across read() calls
    private StringBuilder      _lineBuffer       = new StringBuilder();

    /**
     * Creates a streaming reader for GCS CSV export files.
     * 
     * @param gcsUris List of GCS URIs from BQ export
     * @param totalBytes Total size of all files (for progress %)
     * @param logFrequency Log progress every N lines (e.g., 10000)
     */
    public GCSStreamingReader(List<String> gcsUris, long totalBytes, int logFrequency)
      {
        _gcsUris = gcsUris;
        _totalBytes = totalBytes;
        _logFrequency = logFrequency;
        _storage = StorageOptions.getDefaultInstance().getService();
        _startTime = System.nanoTime();
        _lastLogTime = _startTime;
        
        LOG.info("GCS Streaming Reader initialized for " + gcsUris.size() + " file(s), total size: " + formatBytes(totalBytes));
      }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException
      {
        // Open first file if needed
        if (_currentReader == null && _currentFileIndex < _gcsUris.size())
          {
            openNextFile();
          }
        
        // If no more files, we're done
        if (_currentReader == null)
          {
            logFinalProgress();
            return -1;
          }
        
        // Read from current file
        int charsRead = _currentReader.read(cbuf, off, len);
        
        // If current file is exhausted, try next file
        if (charsRead == -1)
          {
            closeCurrentFile();
            _currentFileIndex++;
            
            if (_currentFileIndex < _gcsUris.size())
              {
                openNextFile();
                return read(cbuf, off, len); // Recursively read from next file
              }
            else
              {
                logFinalProgress();
                return -1; // All files exhausted
              }
          }
        
        // Track bytes and count lines
        _bytesProcessed += charsRead;
        countLines(cbuf, off, charsRead);
        
        // Log progress periodically
        if (_linesProcessed > 0 && _linesProcessed % _logFrequency == 0)
          {
            logProgress();
          }
        
        return charsRead;
      }

    /**
     * Opens the next GCS file for streaming.
     */
    private void openNextFile() throws IOException
      {
        String uri = _gcsUris.get(_currentFileIndex);
        LOG.info("Opening GCS file " + (_currentFileIndex + 1) + "/" + _gcsUris.size() + ": " + uri);
        
        // Parse GCS URI
        String withoutPrefix = uri.substring("gs://".length());
        int slashIdx = withoutPrefix.indexOf('/');
        String bucketName = withoutPrefix.substring(0, slashIdx);
        String blobName = withoutPrefix.substring(slashIdx + 1);
        
        // Open streaming read channel
        BlobId blobId = BlobId.of(bucketName, blobName);
        ReadChannel readChannel = _storage.reader(blobId);
        
        // Wrap in buffered reader for efficient line-by-line reading
        InputStream inputStream = Channels.newInputStream(readChannel);
        _currentReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 64 * 1024); // 64KB buffer
      }

    /**
     * Closes the current file reader.
     */
    private void closeCurrentFile()
      {
        if (_currentReader != null)
          {
            try
              {
                _currentReader.close();
                LOG.debug("Closed GCS file " + _currentFileIndex + "/" + _gcsUris.size());
              }
            catch (IOException e)
              {
                LOG.warn("Error closing GCS reader: " + e.getMessage());
              }
            _currentReader = null;
          }
      }

    /**
     * Counts newlines in the buffer to track lines processed.
     * Handles partial lines that span across read() calls.
     */
    private void countLines(char[] cbuf, int off, int len)
      {
        for (int i = off; i < off + len; i++)
          {
            char c = cbuf[i];
            _lineBuffer.append(c);
            
            if (c == '\n')
              {
                _linesProcessed++;
                _lineBuffer.setLength(0); // Reset for next line
              }
          }
      }

    /**
     * Logs progress information.
     */
    private void logProgress()
      {
        long now = System.nanoTime();
        long elapsedTotal = now - _startTime;
        long elapsedSinceLastLog = now - _lastLogTime;
        
        double progressPct = _totalBytes > 0 ? (100.0 * _bytesProcessed / _totalBytes) : 0;
        long linesPerMin = elapsedTotal > 0 ? (_linesProcessed * 60_000_000_000L / elapsedTotal) : 0;
        long bytesPerSec = elapsedTotal > 0 ? (_bytesProcessed * 1_000_000_000L / elapsedTotal) : 0;
        
        // Estimate remaining time
        long remainingBytes = _totalBytes - _bytesProcessed;
        long estimatedRemainingMs = bytesPerSec > 0 ? (remainingBytes * 1000 / bytesPerSec) : 0;
        
        LOG.info(String.format("Progress: %s lines, %s / %s (%.1f%%), %s lines/min, %s/sec, ~%s remaining",
            NumberFormatUtil.printWith000Sep(_linesProcessed),
            formatBytes(_bytesProcessed),
            formatBytes(_totalBytes),
            progressPct,
            NumberFormatUtil.printWith000Sep(linesPerMin),
            formatBytes(bytesPerSec),
            formatDuration(estimatedRemainingMs)));
        
        _lastLogTime = now;
      }

    /**
     * Logs final progress summary.
     */
    private void logFinalProgress()
      {
        long elapsed = System.nanoTime() - _startTime;
        long linesPerMin = elapsed > 0 ? (_linesProcessed * 60_000_000_000L / elapsed) : 0;
        
        LOG.info(String.format("Stream complete: %s lines, %s bytes in %s (%s lines/min, %s/sec)",
            NumberFormatUtil.printWith000Sep(_linesProcessed),
            formatBytes(_bytesProcessed),
            DurationUtil.printDuration(elapsed),
            NumberFormatUtil.printWith000Sep(linesPerMin),
            formatBytes(_bytesProcessed * 1_000_000_000L / elapsed)));
      }

    @Override
    public void close() throws IOException
      {
        closeCurrentFile();
        LOG.debug("GCS Streaming Reader closed");
      }

    /**
     * Gets the number of lines/records processed so far.
     */
    public long getLinesProcessed()
      {
        return _linesProcessed;
      }

    /**
     * Gets the number of bytes/characters processed so far.
     */
    public long getBytesProcessed()
      {
        return _bytesProcessed;
      }

    /**
     * Gets the total bytes to be processed (from all files).
     */
    public long getTotalBytes()
      {
        return _totalBytes;
      }

    /**
     * Gets the progress percentage (0-100).
     */
    public double getProgressPercent()
      {
        return _totalBytes > 0 ? (100.0 * _bytesProcessed / _totalBytes) : 0;
      }

    /**
     * Formats bytes into human-readable format.
     */
    private static String formatBytes(long bytes)
      {
        if (bytes < 1024)
          return bytes + "B";
        else if (bytes < 1024 * 1024)
          return String.format("%.1fKB", bytes / 1024.0);
        else if (bytes < 1024 * 1024 * 1024)
          return String.format("%.1fMB", bytes / (1024.0 * 1024));
        else
          return String.format("%.2fGB", bytes / (1024.0 * 1024 * 1024));
      }

    /**
     * Formats duration in milliseconds.
     */
    private static String formatDuration(long ms)
      {
        if (ms < 1000)
          return ms + "ms";
        else if (ms < 60000)
          return String.format("%.1fs", ms / 1000.0);
        else if (ms < 3600000)
          return String.format("%.1fmin", ms / 60000.0);
        else
          return String.format("%.1fh", ms / 3600000.0);
      }
  }
