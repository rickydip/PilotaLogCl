/*
 per far partire questo non deve esserci presente un file "filelog4j.xml" 
all'interno del path del file di configurazione
 */



package logclass;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class LogClass2 {
    
    //attributi di classe
    org.apache.log4j.Logger log2 = Logger.getLogger("com.foo");
    org.apache.log4j.Logger logger2 = Logger.getLogger("Milan");
    org.apache.log4j.Logger Logger2 = Logger.getLogger("Barcellona");
    org.apache.log4j.Logger Log2 = Logger.getLogger("Inter");
    
    
    /**
     * costruttore
     */
    public LogClass2() {
    }
    
    
   public void metodo(){
      
     //################################################################## 
     //gestione del file di log locale  
     //##################################################################  
     String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "slave2.xml"; 
      
     System.out.println(log4jConfigFile);
     DOMConfigurator.configure(log4jConfigFile);
     //##################################################################   
     //il file di log implementa politiche di rolling
     //################################################################## 
     
          
      log2.trace("Trace Message!  LogClass2");
      log2.debug("Debug Message!  LogClass2");
      log2.info("Info Message!   LogClass2");
      log2.warn("Warn Message!  LogClass2");
      log2.error("Error Message!  LogClass2");
      log2.fatal("Fatal Message!  LogClass2");
   
      logger2.trace("Trace Message!  LogClass2");
      logger2.debug("Debug Message!  LogClass2");
      logger2.info("Info Message!  LogClass2");
      logger2.warn("Warn Message!  LogClass2");
      logger2.error("Error Message!  LogClass2");
      logger2.fatal("Fatal Message!  LogClass2"); 
   
      Logger2.trace("Trace Message!  LogClass2");
      Logger2.debug("Debug Message!  LogClass2");
      Logger2.info("Info Message!  LogClass2");
      Logger2.warn("Warn Message!  LogClass2");
      Logger2.error("Error Message!  LogClass2");
      Logger2.fatal("Fatal Message!  LogClass2");
      
      Log2.trace("Trace Message!  LogClass2");
      Log2.debug("Debug Message!  LogClass2");
      Log2.info("Info Message!  LogClass2");
      Log2.warn("Warn Message!  LogClass2");
      Log2.error("Error Message!  LogClass2");
      Log2.fatal("Fatal Message!  LogClass2");
      
     }//metodo
}


