package tilda.dataimport.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.loader.GenericLoader;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.utils.DurationUtil;

public class PopulatorTest
  {
    String numbers[] = {"1801GD","10S1XX","111111TT" };
    protected static final Logger LOG              = LogManager.getLogger(PopulatorTest.class.getName());
    
    private void testPopulatorBinarySearch(Connection C) throws Exception 
    {
      Class<?> clazz = Class.forName("tilda.cms.loader.ProviderClassLoader");
      GenericLoader GL = (GenericLoader)clazz.newInstance();
      GL.init(C);
      int iterations = 1;
      long T0 = System.nanoTime();
      
      for(int i=0; i< iterations;++i)
        {
           for(int x=0; x< numbers.length;++x)
             {
               String value = GL.process(numbers[x]);
               LOG.debug("Value = "+value);
             }
        }
      LOG.debug("Duration : "+DurationUtil.printDuration(System.nanoTime() - T0)+"toObjectArrayNative(List): " + DurationUtil.printPerformancePerSecond(System.nanoTime() - T0, iterations) + " iterations/s"); 
    }

    private void testPopulatorBinarySearch()
    {
      
    }    
    private void testPopulatorGuavaSearch()
    {
      
    }    
    public static void main(String[] args) throws Exception
      {
        LOG.info("\n*************************************************************************************************************************************");
        ConnectionPool.autoInit();
        LOG.info("\n*************************************************************************************************************************************\n");

        Connection Conn = ConnectionPool.get("MAIN");
        PopulatorTest test = new PopulatorTest();
        test.testPopulatorBinarySearch(Conn);
      }

  }
