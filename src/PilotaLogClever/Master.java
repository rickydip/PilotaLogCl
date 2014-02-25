/*
 per far partire questo non deve esserci presente un file "filelog4j.xml" 
all'interno del path del file di configurazione
 */



package PilotaLogClever;

import PilotaLogClever.slaves.Slave1;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Master {
    
    //attributi di classe
    
    
    //logger del componenete software master 
    org.apache.log4j.Logger log0 = Logger.getLogger("com_foo");
    org.apache.log4j.Logger logger0 = Logger.getLogger("com_foo_bar");
    org.apache.log4j.Logger Logger0 = Logger.getLogger("logger");
    org.apache.log4j.Logger Log0 = Logger.getLogger("log");
    
    
    
    
    
    /**
     * costruttore
     */
    public Master() {
    }
    
    
   public void metodo(){
   
    //dichiarato nei frammenti slave1
    Logger pippo =Logger.getLogger("comodo1");
    
     Slave1 q = new Slave1(pippo);
     q.metodo();
       
      log0.trace("Trace Message! sono  Master");
      log0.debug("Debug Message! sono  Master");
      log0.info("Info Message! sono Master");
      log0.warn("Warn Message! sono Master");
      log0.error("Error Message! sono  Master");
      log0.fatal("Fatal Message! sono  Master");
   
      logger0.trace("Trace Message! sono Master");
      logger0.debug("Debug Message! sono Master");
      logger0.info("Info Message! sono Master");
      logger0.warn("Warn Message! sono Master");
      logger0.error("Error Message! sono Master");
      logger0.fatal("Fatal Message! sono Master"); 
   
      Logger0.trace("Trace Message! sono Master");
      Logger0.debug("Debug Message! sono Master");
      Logger0.info("Info Message! sono Master");
      Logger0.warn("Warn Message! sono Master");
      Logger0.error("Error Message! sono Master");
      Logger0.fatal("Fatal Message! sono Master");
      
      Log0.trace("Trace Message! sono Master");
      Log0.debug("Debug Message! sono Master");
      Log0.info("Info Message! sono Master");
      Log0.warn("Warn Message! sono Master");
      Log0.error("Error Message! sono Master");
      Log0.fatal("Fatal Message! sono Master");
   
     
      
     
     }//metodo
   
   
   
   
  }//class


