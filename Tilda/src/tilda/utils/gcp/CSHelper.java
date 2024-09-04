/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
 * ===========================================================================
 */

package tilda.utils.gcp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.api.gax.paging.Page;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class CSHelper
  {

    protected static final Logger LOG = LogManager.getLogger(CSHelper.class.getName());

    /**
     * Given the environment variable name passed in (default is {@link tilda.utils.FileUtil#_DEFAULT_ENV_VAR_NAME}),
     * looks up the value which points to a path, and then based on the project name, lookup the file
     * "[SERVICE_ACCOUNTS_CREDENTIALS_PATH]/<dataProjectName>.xxx.key.cs.json".
     * 'xxx' can be anything (and is optional) but is generally the first few characters of the original key file. This is done
     * so different keys to the same project could be used in a team while keeping file names specific to the actual key file
     * generated by GCP.
     * 
     * @param dataProjectName
     * @return An authenticated capsico-store Storage instance
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static Storage getStorage(String dataProjectName)
    throws FileNotFoundException, IOException
      {
        return StorageOptions.newBuilder().setCredentials(AuthHelper.getCredentials(dataProjectName, "cs")).setProjectId(dataProjectName).build().getService();
      }

    public static Storage getStorage(String envVariable, String dataProjectName)
    throws FileNotFoundException, IOException
      {
        return StorageOptions.newBuilder().setCredentials(AuthHelper.getCredentials(envVariable, dataProjectName, "cs")).setProjectId(dataProjectName).build().getService();
      }

    public static List<String> getSubDirectories(Storage cs, String bucketName, String dir)
      {
        List<String> directories = new ArrayList<String>();
        Page<Blob> blobs = cs.list(bucketName, Storage.BlobListOption.prefix(dir), Storage.BlobListOption.currentDirectory());

        // LOG.debug("Printing remote folder names in " + dir);
        for (Blob blob : blobs.iterateAll())
          {
            if (blob.getName().endsWith("/"))
              {
                String[] parts = blob.getName().split("/");
                String folderName = parts[parts.length - 1];

                // LOG.debug(folderName);
                directories.add(folderName);
              }
          }
        return directories;
      }

    public static List<String> getObjectsinRemoteFolder(Storage cs, String bucketName, String dir)
      {
        List<String> blobObjects = new ArrayList<String>();
        Page<Blob> blobs = cs.list(bucketName, Storage.BlobListOption.prefix(dir), Storage.BlobListOption.currentDirectory());

        // LOG.debug("Printing remote objects in directory: " + dir);
        for (Blob blob : blobs.iterateAll())
          {
            if (!blob.getName().endsWith("/"))
              {
                // LOG.debug(blob.getName());
                blobObjects.add(blob.getName());
              }
          }
        return blobObjects;
      }

    public static long getRemoteFolderSize(Storage cs, String bucketName, List<String> allObjects)
    throws IOException
      {
        long length = 0;
        for (String objectName : allObjects)
          {
            Blob blob = cs.get(BlobId.of(bucketName, objectName));
            length += blob.getSize();
          }
        return length;
      }

    public static void downloadBlobsToLocalStorage(Storage cs, String bucketName, List<String> allBlobs, String localDestPath, boolean override)
    throws IOException
      {
        for (String objectName : allBlobs)
          {
            String[] parts = objectName.split("/");
            String fileName = parts[parts.length - 1];
            Path path = Paths.get(localDestPath + fileName);

            if (Files.exists(path) == false || override == true)
              {
                LOG.debug("Downloading " + objectName + " to local file system...");
                byte[] content = cs.readAllBytes(bucketName, objectName);
                Files.write(path, content);
                LOG.debug("Sucessfully downloaded " + objectName);
              }
            else
              LOG.debug("File " + objectName + " already on the local file system.");
          }
      }

    public static int upload(Storage cs, InputStream inputStream, String bucketName, String fullFileName, String mimeType)
    throws IOException
      {
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fullFileName).setContentType(mimeType).build();
        try (WriteChannel writer = cs.writer(blobInfo))
          {
            ReadableByteChannel channel = Channels.newChannel(inputStream);
            ByteBuffer buf = ByteBuffer.allocate(1024 * 1024 * 5);
            int totalSize = 0;
            while (channel.read(buf) != -1)
              {
                totalSize+=buf.position();
                buf.flip(); // Prepare the buffer for writing
                writer.write(buf);
                buf.clear(); // Prepare the buffer for the next read
              }
           return totalSize;
          }
      }

    public static URL genSignedUrl(Storage cs, String bucketName, String fullFileName, String mimeType)
    throws IOException
      {
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fullFileName).setContentType(mimeType).build();
        return cs.signUrl(blobInfo, 60, TimeUnit.MINUTES, Storage.SignUrlOption.withV4Signature());
      }
    
  }
