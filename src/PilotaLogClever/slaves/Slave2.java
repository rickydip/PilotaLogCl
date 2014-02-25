/*
 per far partire questo non deve esserci presente un file "filelog4j.xml" 
all'interno del path del file di configurazione
 */



package PilotaLogClever.slaves;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Slave2 {
    
    //attributi di classe
    org.apache.log4j.Logger log2 = Logger.getLogger("Juventus");
    org.apache.log4j.Logger logger2 = Logger.getLogger("Milan");
    org.apache.log4j.Logger Logger2 = Logger.getLogger("Barcellona");
    org.apache.log4j.Logger Log2 = Logger.getLogger("Inter");
    
    
    /**
     * costruttore
     */
    public Slave2() {
    }
    
    
   public void metodo(){
      
             
      log2.trace("Trace Message!  sono Slave2");
      log2.debug("Debug Message!  sono Slave2");
      log2.info("Info Message!   sono Slave2");
      log2.warn("Warn Message!  sono Slave2");
      log2.error("Error Message!  sono Slave2");
      log2.fatal("Fatal Message!  sono Slave2");
   
      logger2.trace("Trace Message!  sono Slave2");
      logger2.debug("Debug Message!  sono Slave2");
      logger2.info("Info Message!  sono Slave2");
      logger2.warn("Warn Message!  sono Slave2");
      logger2.error("Error Message!  sono Slave2");
      logger2.fatal("Fatal Message!  sono Slave2"); 
   
      Logger2.trace("Trace Message!  sono Slave2");
      Logger2.debug("Debug Message!  sono Slave2");
      Logger2.info("Info Message!  sono Slave2");
      Logger2.warn("Warn Message!  sono Slave2");
      Logger2.error("Error Message!  sono Slave2");
      Logger2.fatal("Fatal Message!  sono Slave2");
      
      Log2.trace("Trace Message!  sono Slave2");
      Log2.debug("Debug Message!  sono Slave2");
      Log2.info("Info Message!  sono Slave2");
      Log2.warn("Warn Message!  sono Slave2");
      Log2.error("Error Message!  sono Slave2");
      Log2.fatal("Fatal Message!  sono Slave2");
      
     }//metodo
}


