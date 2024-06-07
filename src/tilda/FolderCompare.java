/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tilda;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tilda.utils.DateTimeUtil;
import tilda.utils.FileUtil;
import tilda.utils.FileUtil.FileProcessor;

public class FolderCompare
  {

    public static class FolderStats
      {
        public File              _D;
        public long              _OldestFile  = System.currentTimeMillis();
        public long              _NewestFile  = 0;
        public int               _FileCount;
        public long              _FileSize;

        public List<FolderStats> _Descendents = new ArrayList<FolderStats>();
        public int               _FileCountDescendents;
        public long              _FileSizeDescendents;
      }

    public static class FolderStatsProcessor implements FileProcessor
      {
        protected Stack<FolderStats> _S    = new Stack<FolderStats>();
        public FolderStats           _Root = null;


        @Override
        public void startFolder(File D)
        throws Exception
          {
            FolderStats FS = new FolderStats();
            FS._D = D;
            if (_Root == null)
              _Root = FS;
            _S.push(FS);
          }

        @Override
        public void processFile(File F)
        throws Exception
          {
            FolderStats Current = _S.peek();
            if (Current._OldestFile > F.lastModified())
              Current._OldestFile = F.lastModified();
            if (Current._NewestFile < F.lastModified())
              Current._NewestFile = F.lastModified();
            ++Current._FileCount;
            Current._FileSize += F.length();
            System.out.println("Current -  " + Current._D.getName() + ": " + Current._FileCount + ", " + Current._FileSize);
          }

        @Override
        public void endFolder(File D)
        throws Exception
          {
            if (_S.size() > 1)
              {
                FolderStats Current = _S.peek();
                Current._FileCountDescendents += Current._FileCount;
                Current._FileSizeDescendents += Current._FileSize;
                System.out.println("Rollup Current -  " + Current._D.getName() + ": " + Current._FileCount + ", " + Current._FileSize);
                FolderStats Parent = _S.get(_S.size() - 2);
                Parent._FileCountDescendents += Current._FileCountDescendents;
                Parent._FileSizeDescendents += Current._FileSizeDescendents;
                Parent._Descendents.add(Current);
                System.out.println("   Parent -  " + Parent._D.getName() + ": " + Parent._FileCountDescendents + ", " + Parent._FileSizeDescendents);
              }
            _S.pop();
          }

      }

    public static void main(String[] args)
      {
        try
          {
            File D1 = new File(args[0]);
            File[] Subfolders = D1.listFiles();
            for (File f : Subfolders)
              {
                if (f.isDirectory() == false)
                  continue;
                FolderStatsProcessor FSP1 = new FolderStatsProcessor();
                FileUtil.iterate(f, FSP1, new String[] { ".*", "bin"
                });
                BufferedWriter Out = new BufferedWriter(new FileWriter(D1.getAbsolutePath() + "\\" + f.getName() + ".filecounts.csv"));
                Out.write("Path, FileCount, FileSize, Oldest, Newest, TotalCount, TotalSize\r\n");
                print(Out, FSP1._Root, 0);
                Out.close();
              }
          }
        catch (Throwable T)
          {
            T.printStackTrace();
          }


      }

    private static void print(Writer Out, FolderStats FS, int Level)
    throws IOException
      {
        for (int i = 0; i < Level; ++i)
          Out.write("  ");
        Out.write(FS._D.getCanonicalPath());

        Out.write(", " + FS._FileCount);
        Out.write(", " + FS._FileSize);

        Out.write(", ");
        ZonedDateTime ZDT = ZonedDateTime.ofInstant(Instant.ofEpochMilli(FS._OldestFile), ZoneId.systemDefault());
        Out.write(DateTimeUtil.printDateTime(ZDT));

        Out.write(", ");
        ZDT = ZonedDateTime.ofInstant(Instant.ofEpochMilli(FS._NewestFile), ZoneId.systemDefault());
        Out.write(DateTimeUtil.printDateTime(ZDT));

        Out.write(", " + FS._FileCountDescendents);
        Out.write(", " + FS._FileSizeDescendents);
        Out.write("\r\n");

        for (FolderStats fs : FS._Descendents)
          print(Out, fs, Level + 1);
      }
  }
