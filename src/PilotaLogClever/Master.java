/*
 per far partire questo non deve esserci presente un file "filelog4j.xml" 
all'interno del path del file di configurazione
 */



package PilotaLogClever;

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
   
    
    //#################################
      //esecuzione del programma master##
      //#################################
     
      log0.trace("Trace Message! LogClass");
      log0.debug("Debug Message! LogClass");
      log0.info("Info Message! LogClass");
      log0.warn("Warn Message! LogClass");
      log0.error("Error Message! LogClass");
      log0.fatal("Fatal Message! LogClass");
   
      logger0.trace("Trace Message! LogClass");
      logger0.debug("Debug Message! LogClass");
      logger0.info("Info Message! LogClass");
      logger0.warn("Warn Message! LogClass");
      logger0.error("Error Message! LogClass");
      logger0.fatal("Fatal Message! LogClass"); 
   
      Logger0.trace("Trace Message! LogClass");
      Logger0.debug("Debug Message! LogClass");
      Logger0.info("Info Message! LogClass");
      Logger0.warn("Warn Message! LogClass");
      Logger0.error("Error Message! LogClass");
      Logger0.fatal("Fatal Message! LogClass");
      
      Log0.trace("Trace Message! LogClass");
      Log0.debug("Debug Message! LogClass");
      Log0.info("Info Message! LogClass");
      Log0.warn("Warn Message! LogClass");
      Log0.error("Error Message! LogClass");
      Log0.fatal("Fatal Message! LogClass");
   
     
      
     
     }//metodo
   
   
   
   
  }//class


