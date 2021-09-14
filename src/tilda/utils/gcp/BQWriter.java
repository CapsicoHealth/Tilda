package tilda.utils.gcp;

import java.io.IOException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import com.google.cloud.bigquery.TableDataWriteChannel;

public class BQWriter extends Writer
  {
    public BQWriter(TableDataWriteChannel Out)
      {
        _Out = Out;
      }

    protected TableDataWriteChannel _Out;
    protected ByteBuffer            _BB = ByteBuffer.allocate(4096);

    @Override
    public void write(char[] cbuf, int off, int len)
    throws IOException
      {
        // LOG.debug("off: "+off+"; len: "+len+"; "+new String(cbuf, off, len));
        if (len == 0)
          return;
        // ByteBuffer BB = ByteBuffer.wrap(new String(cbuf, off, len).getBytes(StandardCharsets.UTF_8));
        _Out.write(ByteBuffer.wrap(new String(cbuf, off, len).getBytes(StandardCharsets.UTF_8)));
      }

    @Override
    public void flush()
    throws IOException
      {
      }

    @Override
    public void close()
    throws IOException
      {
        _Out.close();
      }

  }
