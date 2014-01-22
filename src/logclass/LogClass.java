
package logclass;


import java.io.File;
import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;


public class LogClass {
   private static org.apache.log4j.Logger log0 = Logger.getLogger("com.foo");
   private static org.apache.log4j.Logger logger0 = Logger.getLogger("com.foo.bar");
   private static org.apache.log4j.Logger Logger0 = Logger.getLogger("logger");
   private static org.apache.log4j.Logger Log0 = Logger.getLogger("log");
    
    
    
   public static void main(String[] args) {
         
            
     String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "master_dinamic.xml";
     
     //apro il file master_dinamic.xml
     File  file =new File(log4jConfigFile);
     
     //se non esiste
     boolean existsFile = file.isFile();
     if (!existsFile) {
         
     System.out.println("Utilizzo il file di configurazione di default");
     
     
     log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "master_default.xml";
    
     System.out.println(log4jConfigFile);
     DOMConfigurator.configure(log4jConfigFile); 
     
     }//if
     
     //altrimenti
     else{

         System.out.println("ho trovato il file di configurazione creato dinamicamente");
         System.out.println(log4jConfigFile);
         DOMConfigurator.configure(log4jConfigFile);
         //da implementare
         //1° dichiarare il path che si vuole abbiano i 3 file del masterlogger (la struttua dei 3 file è standard )
         //per ogni frammento appender prodotto per ogni file di configurazione di log
         //bisogna modificare il valore value="path" del campo param di <appender>
         //Sommare in un unico file i frammenti appender (modificati)
         //Sommare in un unico file i frammenti logger
         //comporre il rootlogger (devono esserci n entri, ognuna col riferimento <appender-ref ref="FILE7"/> dove "FILE7" è memorizzato nel campo name di ogni appender)
         //aggiungere tesca e coda 
         //
         //
         
         
         
     }
      
     
     
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
      
      
      LogClass1 a = new LogClass1();
      a.metodo();
      
          
      LogClass2 b = new LogClass2();
      b.metodo();
      
      
   }//main

  

}//class

