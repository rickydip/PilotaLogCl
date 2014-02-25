/*
 per far partire questo non deve esserci presente un file "filelog4j.xml" 
all'interno del path del file di configurazione
 */



package PilotaLogClever;

import PilotaLogClever.slaves.Slave1;
import PilotaLogClever.slaves.Slave3;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Slave {
    
    //attributi di classe
    
    
    //logger del componenete software master 
    org.apache.log4j.Logger log00 = Logger.getLogger("a");
    org.apache.log4j.Logger logger00 = Logger.getLogger("b");
    org.apache.log4j.Logger Logger00 = Logger.getLogger("c");
    org.apache.log4j.Logger Log00 = Logger.getLogger("d");
    
    
    
    
    
    
    /**
     * costruttore
     */
    public Slave() {
    }
    
    
   public void metodo(){
   
   //dichiarato nei frammenti slave3
    Logger peppe =Logger.getLogger("comodo2");  
    Slave3 a = new Slave3(peppe);
    a.metodo();
       
      
       
      log00.trace("Trace Message! sono  Slave");
      log00.debug("Debug Message! sono  Slave");
      log00.info("Info Message! sono Slave");
      log00.warn("Warn Message! sono Slave");
      log00.error("Error Message! sono  Slave");
      log00.fatal("Fatal Message! sono  Slave");
   
      logger00.trace("Trace Message! sono Slave");
      logger00.debug("Debug Message! sono Slave");
      logger00.info("Info Message! sono Slave");
      logger00.warn("Warn Message! sono Slave");
      logger00.error("Error Message! sono Slave");
      logger00.fatal("Fatal Message! sono Slave"); 
   
      Logger00.trace("Trace Message! sono Slave");
      Logger00.debug("Debug Message! sono Slave");
      Logger00.info("Info Message! sono Slave");
      Logger00.warn("Warn Message! sono Slave");
      Logger00.error("Error Message! sono Slave");
      Logger00.fatal("Fatal Message! sono Slave");
      
      Log00.trace("Trace Message! sono Slave");
      Log00.debug("Debug Message! sono Slave");
      Log00.info("Info Message! sono Slave");
      Log00.warn("Warn Message! sono Slave");
      Log00.error("Error Message! sono Slave");
      Log00.fatal("Fatal Message! sono Slave");
   
     
      
     
     }//metodo
   
   
   
   
  }//class


