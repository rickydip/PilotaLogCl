/*
 per far partire questo non deve esserci presente un file "filelog4j.xml" 
all'interno del path del file di configurazione
 */



package PilotaLogClever.slaves;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Slave1 {
    
    //attributi di classe
    
    org.apache.log4j.Logger log1 = Logger.getLogger("pippo");
    org.apache.log4j.Logger logger1 = Logger.getLogger("pluto");
    org.apache.log4j.Logger Logger1 = Logger.getLogger("paperino");
    org.apache.log4j.Logger Log1 = Logger.getLogger("paperina");
    
    
    public Logger comodo = null; 
    
   
    public Slave1(Logger pippo) {
        this.comodo=pippo;
    }

    public Slave1() {
       
    }
     
    
   public void metodo(){
           
   // comodo=Logger.getLogger("comodo1");
       
   if (comodo!=null)   {
      comodo.debug("Info Message! comodo, su Slave1");
      comodo.info("Info Message! comodo, su Slave1");
      comodo.warn("Warn Message! comodo, su Slave1");
      comodo.error("Error Message! comodo, su Slave1");
      comodo.fatal("Fatal Message! comodo, su Slave1");
   }
      
      
      log1.trace("Trace Message! sono Slave1");
      log1.debug("Debug Message! sono Slave1");
      log1.info("Info Message! sono Slave1");
      log1.warn("Warn Message! sono Slave1");
      log1.error("Error Message! sono Slave1");
      log1.fatal("Fatal Message! sono Slave1");
   
      logger1.trace("Trace Message! sono Slave1");
      logger1.debug("Debug Message! sono Slave1");
      logger1.info("Info Message! sono Slave1");
      logger1.warn("Warn Message! sono Slave1");
      logger1.error("Error Message! sono Slave1");
      logger1.fatal("Fatal Message! sono Slave1"); 
 
      Logger1.trace("Trace Message! sono Slave1");
      Logger1.debug("Debug Message! sono Slave1");
      Logger1.info("Info Message! sono Slave1");
      Logger1.warn("Warn Message! sono Slave1");
      Logger1.error("Error Message! sono Slave1");
      Logger1.fatal("Fatal Message! sono Slave1");
      
      Log1.trace("Trace Message! sono Slave1");
      Log1.debug("Debug Message! sono Slave1");
      Log1.info("Info Message! sono Slave1");
      Log1.warn("Warn Message!sono Slave1");
      Log1.error("Error Message! sono Slave1");
      Log1.fatal("Fatal Message! sono Slave1");
     
     }//metodo
   
   
   
   
  }//class


