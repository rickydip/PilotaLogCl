
package logclass;

//import org.apache.log4j.BasicConfigurator;
import java.io.File;
import static java.lang.System.exit;
import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;


public class LogClass {
   private static org.apache.log4j.Logger log = Logger.getLogger("com.foo");
   private static org.apache.log4j.Logger logger = Logger.getLogger("com.foo.bar");
   private static org.apache.log4j.Logger logger2 = Logger.getLogger("logger");
    private static org.apache.log4j.Logger log2 = Logger.getLogger("log");
    
    
    
   public static void main(String[] args) {
     /* 
       
       String filePath ="";
       
       
       //controllo sull'esistenza del file locale
       //se esiste continua altrimenti stop
       //eventualmente più singoli controlli se bisogna valutare la presenza di singoli file 
       
       if(controlloEsistenzaFile(filePath)==1){
         log.info("il file"+filePath+"esiste");
         }
         else{    
              log.info("il file"+filePath+"non esiste"); 
              exit(1);
                 }
       
       
       
       
       
       
       
      //operazioni successive alla creazione dinamica di un file di log unico 
       
     */  
       
       
      try{ 
       
      //DOMConfigurator.configure("C:\\Users\\Rick\\Documents\\NetBeansProjects\\LogClass\\src\\log4j.xml");
      //DOMConfigurator.configure("/home/riccardo/Desktop/LogClass/src/log4j.xml");
      
      String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "log4j.xml"; 
      System.out.println(log4jConfigFile);
      DOMConfigurator.configure(log4jConfigFile);
      //PropertyConfigurator.configure("/home/riccardo/Desktop/LogClass/src/log4j.properties");
      //BasicConfigurator.configure(); 
      }
      catch(Exception e){
         logger.error("Missing log4j.xml");
         logger2.error("Missing log4j.xml");
         log.error("Missing log4j.xml");
         log2.error("Missing log4j.xml");
         
      }
      
      String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "log4j.xml";
    //  prova p = null;
    //     p.output();
      
      log.trace("Trace Message!");
      log.debug("Debug Message!");
      log.info("Info Message!"+log4jConfigFile);
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
      
      
      LogClass1 a = new LogClass1();
      a.metodo();
      
   }

/**
 * 
 * @param filePath Definiamo il path del file
 * @return 
 */    
int controlloEsistenzaFile(String filePath){
    int flag=0;
   
// Inizializziamo il file
File file = new File(filePath);
 
// Verifichiamo che questo sia esistente e che sia una cartella
boolean existsFile = file.isFile();

if (existsFile) flag = 1;    
   return flag; 
}//metodo

/**
 * Il metodo, dando per scontato che i file esistano, compone un file 
 * di nuovo file xml di configurazione dei log, questo nasce attingendo informazioni 
 * dai file locali
 * 
 * @param path1 file locale 1
 * @param path2 file locale 2
 * @return 
 */
int creaFileLog(String path1, String path2){
 int flag=0; 

//Creo il nuovo file
File file = new File( "/home/riccardo/Desktop/LogClass/dinamico.xml"); 

 
 
 
 
return flag;
}//metodo


}

