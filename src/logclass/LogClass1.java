/*
 per far partire questo non deve esserci presente un file "filelog4j.xml" 
all'interno del path del file di configurazione
 */



package logclass;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class LogClass1 {
    
    //attributi di classe
    
    org.apache.log4j.Logger log1 = Logger.getLogger("pippo");
    org.apache.log4j.Logger logger1 = Logger.getLogger("pluto");
    org.apache.log4j.Logger Logger1 = Logger.getLogger("paperino");
    org.apache.log4j.Logger Log1 = Logger.getLogger("paperina");
    
    
    
    
    
    
    /**
     * costruttore
     */
    public LogClass1() {
    }
    
    
   public void metodo(){
           
   //################################################################## 
   //gestione del file di log locale  
   //################################################################## 
    String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "slave1.xml"; 
    System.out.println(log4jConfigFile);
    DOMConfigurator.configure(log4jConfigFile);
   //################################################################## 
      
      
      
     
      log1.trace("Trace Message! LogClass1");
      log1.debug("Debug Message! LogClass1");
      log1.info("Info Message! LogClass1");
      log1.warn("Warn Message! LogClass1");
      log1.error("Error Message! LogClass1");
      log1.fatal("Fatal Message! LogClass1");
   
      logger1.trace("Trace Message! LogClass1");
      logger1.debug("Debug Message! LogClass1");
      logger1.info("Info Message! LogClass1");
      logger1.warn("Warn Message! LogClass1");
      logger1.error("Error Message! LogClass1");
      logger1.fatal("Fatal Message! LogClass1"); 
 
      Logger1.trace("Trace Message! LogClass1");
      Logger1.debug("Debug Message! LogClass1");
      Logger1.info("Info Message! LogClass1");
      Logger1.warn("Warn Message! LogClass1");
      Logger1.error("Error Message! LogClass1");
      Logger1.fatal("Fatal Message! LogClass1");
      
      Log1.trace("Trace Message! LogClass1");
      Log1.debug("Debug Message! LogClass1");
      Log1.info("Info Message! LogClass1");
      Log1.warn("Warn Message! LogClass1");
      Log1.error("Error Message! LogClass1");
      Log1.fatal("Fatal Message! LogClass1");
     
     }//metodo
   
   
   
   
   
   static void creaDir(String directoryName){
        File theDir = new File(directoryName);

  // if the directory does not exist, create it
  if (!theDir.exists()) {
    System.out.println("creating directory: " + directoryName);
    boolean result = theDir.mkdir();  

     if(result) {    
       System.out.println("DIR created");  
     }
  }
    }
}//class


