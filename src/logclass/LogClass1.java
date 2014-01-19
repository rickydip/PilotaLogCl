/*
 per far partire questo non deve esserci presente un file "filelog4j.xml" 
all'interno del path del file di configurazione
 */



package logclass;

import java.io.File;
import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;


public class LogClass1 {
    
    //attributi di classe
    
    
    
    /**
     * costruttore
     */
    public LogClass1() {
    }
    
    
   public void metodo(){
           
           
    org.apache.log4j.Logger log = Logger.getLogger("com.foo");
    org.apache.log4j.Logger logger = Logger.getLogger("com.foo.bar");
    org.apache.log4j.Logger logger2 = Logger.getLogger("logger");
    org.apache.log4j.Logger log2 = Logger.getLogger("log");
    
    
    
 //  public static void main(String[] args) {
      
      //DOMConfigurator.configure("C:\\Users\\Rick\\Documents\\NetBeansProjects\\LogClass\\src\\log4j.xml");
      DOMConfigurator.configure("/home/riccardo/Desktop/LogClass/src/log4j1.xml");
      //PropertyConfigurator.configure("/home/riccardo/Desktop/LogClass/src/log4j.properties");
      //BasicConfigurator.configure(); 
      
      log.trace("Trace Message!");
      log.debug("Debug Message!");
      log.info("Info Message!");
      log.warn("Warn Message!");
      log.error("Error Message!");
      log.fatal("Fatal Message!");
   
      logger.trace("Trace Message!");
      logger.debug("Debug Message!");
      logger.info("Info Message!");
      logger.warn("Warn Message!");
      logger.error("Error Message!");
      logger.fatal("Fatal Message!"); 
   
      logger2.trace("Trace Message!");
      logger2.debug("Debug Message!");
      logger2.info("Info Message!");
      logger2.warn("Warn Message!");
      logger2.error("Error Message!");
      logger2.fatal("Fatal Message!");
      
      log2.trace("Trace Message!");
      log2.debug("Debug Message!");
      log2.info("Info Message!");
      log2.warn("Warn Message!");
      log2.error("Error Message!");
      log2.fatal("Fatal Message!");
      
     }//metodo
}


