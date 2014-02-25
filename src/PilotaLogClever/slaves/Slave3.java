/*
 per far partire questo non deve esserci presente un file "filelog4j.xml" 
all'interno del path del file di configurazione
 */



package PilotaLogClever.slaves;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Slave3 extends Slave1{
    
    //attributi di classe
    public Logger comodo = null; 
    
    org.apache.log4j.Logger aaa = Logger.getLogger("italia");
    
    
    
    
    public Slave3(Logger comodo) {
        this.comodo=comodo;
    }
    
    public Slave3()  {
        
    }
    
   public void metodo(){
          
    // comodo=Logger.getLogger("comodo2");
       
        if (comodo!=null)   {
       
      comodo.trace("Trace Message! comodo2  su slave3");
      comodo.debug("Debug Message! comodo2  su slave3");
      comodo.info("Info Message! comodo2 su slave3");
      comodo.warn("Warn Message! comodo2 su slave3");
      comodo.error("Error Message! comodo2 su slave3");
      comodo.fatal("Fatal Message! comodo2 su slave3");
        }
      
      aaa.trace("Trace Message! italia dichiarato  su slave3");
      aaa.debug("Debug Message! italia dichiarato su slave3");
      aaa.info("Info Message! italia dichiarato su slave3");
      aaa.warn("Warn Message! italia dichiarato su slave3");
      aaa.error("Error Message! italia dichiarato su slave3");
      aaa.fatal("Fatal Message! italia dichiarato su slave3");
      
      /*
   
    //  se scrivo su questi logger dichiarati su slave1, poi devo prevedere un meccanismo
    //  che fonde gli appender di slave 1 e quelli di slave3 sullo stesso logger
      
      logger1.trace("Trace Message! logger1 esteso da slave1, slave3");
      logger1.debug("Debug Message! logger1 esteso da slave1, slave3");
      logger1.info("Info Message! logger1 esteso da slave1, slave3");
      logger1.warn("Warn Message! logger1 esteso da slave1, slave3");
      logger1.error("Error Message! logger1 esteso da slave1, slave3");
      logger1.fatal("Fatal Message! logger1 esteso da slave1, slave3"); 
 
      Logger1.trace("Trace Message! Logger1 esteso da slave1, slave3");
      Logger1.debug("Debug Message! Logger1 esteso da slave1, slave3");
      Logger1.info("Info Message! Logger1 esteso da slave1, lave3");
      Logger1.warn("Warn Message! Logger1 esteso da slave1, slave3");
      Logger1.error("Error Message! Logger1 esteso da slave1, slave3");
      Logger1.fatal("Fatal Message! Logger1 esteso da slave1, slave3");
      
      Log1.trace("Trace Message! Log1 esteso da slave1, slave3");
      Log1.debug("Debug Message! Log1 esteso da slave1, slave3");
      Log1.info("Info Message! Log1 esteso da slave1, slave3");
      Log1.warn("Warn Message! Log1 esteso da slave1, slave3");
      Log1.error("Error Message! Log1 esteso da slave1, slave3");
      Log1.fatal("Fatal Message! Log1 esteso da slave1, slave3");
     
  */            
              
     }//metodo
   
   
   
   
  }//class


