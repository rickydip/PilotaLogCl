
package logclass;


import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class LogClass {
   private static org.apache.log4j.Logger log0 = Logger.getLogger("com.foo");
   private static org.apache.log4j.Logger logger0 = Logger.getLogger("com.foo.bar");
   private static org.apache.log4j.Logger Logger0 = Logger.getLogger("logger");
   private static org.apache.log4j.Logger Log0 = Logger.getLogger("log");
    
   
   
   //var di comodo
   static boolean flag =false; //con false usa il master_default; true avvia il processo di creazione del master_dinamic
   
    
   public static void main(String[] args) {
      
       
     if(flag){
         
     System.out.println("Utilizzo il file di configurazione di default");
          
     String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "master_default.xml";
    
     System.out.println(log4jConfigFile);
     DOMConfigurator.configure(log4jConfigFile); 
     
         
     }//  
     else{ 
         
         
     String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "master_dinamic.xml";
     
     //apro il file master_dinamic.xml
     File  file =new File(log4jConfigFile);
     
     //se non esiste
     boolean existsFile = file.isFile();
     if (!existsFile) {
         
     System.out.println("Il file di configurazione master_dinamic non esiste, inizio il processo di creazione");
     
     //###################
     //processo di creazione del file
     //###################
     //i file contenenti le configurazioni da fondere sono:
     String path_default="/home/riccardo/Desktop/LogClass2/master_default.xml";
     String path_slave1="/home/riccardo/Desktop/LogClass2/slave1.xml";
     String path_slave2="/home/riccardo/Desktop/LogClass2/slave2.xml";
     //###################
     
     //nome usato nella creazione delle direcotory
     String nome="master_default";
     
   
     //tratto il file di log di default (del core)
     InfoLogFile a =new InfoLogFile(path_default);
       

     //pattern di ricerca
     String pattern1[]={"<appender name=\"","</appender>"};
     String pattern2[]={"<logger name=\"", "</logger>"};
     
     //il percorso dove salvare i file che si creano nell'esecuzione
       String radice=System.getProperty("user.dir")+ File.separator;
       System.out.println("radice: "+radice);creaDir(radice+"file_elab");
       creaDir(radice+"file_elab/"+nome);creaDir(radice+"file_elab/"+nome+"/appender");creaDir(radice+"file_elab/"+nome+"/logger");
    
     String file5= radice+"file_elab/"+nome+"/appender/";
     String file6= radice+"file_elab/"+nome+"/logger/";  
       
     //creo i file di comodo che uso per comporre la parte logger del file di log finale
    // File logger_completo =new File(radice+"file_elab/loggercompleto.xml");
     //creo i file di comodo che uso per comporre la parte appender del file di log finale
   //  File appender_completo =new File(radice+"file_elab/loggercompleto.xml");
       
     a.ricavaInfo_app(pattern1[0], pattern1[1],file5); //esegue operazioni su appender
     a.ricavaInfo_log(pattern2[0], pattern2[1],file6); //esegue operazioni su logger 
     
    // String logger_completo=radice+"file_elab/loggercompleto.xml";
    // a.componiFile(logger_completo, "/home/riccardo/Desktop/LogClass2/file_elab/master_default/logger/target1.xml");
    // a.componiFile(logger_completo, "/home/riccardo/Desktop/LogClass2/file_elab/master_default/logger/target2.xml");
     
     
     
     
     
     
     }//if
     
     //se esiste lo apro
     else{
     
         System.out.println("Il file di configurazione master_dinamic ESISTE, lo utilizzo.");    
     
         log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "master_default.xml";
         
         System.out.println(log4jConfigFile);
         DOMConfigurator.configure(log4jConfigFile);
     }//else
     }//if(flag)
   
     
     
     
     
     
     
    

         
         //da implementare
         //dichiarare il path che si vuole abbiano i 3 file del masterlogger (la struttua dei 3 file è standard )
         //per ogni frammento appender prodotto per ogni file di configurazione di log
         //bisogna modificare il valore value="path" del campo param di <appender>
         //Sommare in un unico file i frammenti appender (modificati)
         //Sommare in un unico file i frammenti logger
         //comporre il rootlogger (devono esserci n entri, ognuna col riferimento <appender-ref ref="FILE7"/> dove "FILE7" è memorizzato nel campo name di ogni appender)
         //aggiungere tesca e coda 
         //
         //
         
         
         
    
      
     
     
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

