
package PilotaLogClever;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import PilotaLogClever.slave.LogClass3;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class PilotaLogClever {
   private static org.apache.log4j.Logger log0 = Logger.getLogger("com.foo");
   private static org.apache.log4j.Logger logger0 = Logger.getLogger("com.foo.bar");
   private static org.apache.log4j.Logger Logger0 = Logger.getLogger("logger");
   private static org.apache.log4j.Logger Log0 = Logger.getLogger("log");
    
   
 
    
   public static void main(String[] args) {
   int flag=0;
//###############################################
//Componenti software che voglio includere nel  #
//processo di creazione dinamica del file di log#
//###############################################     
     
     //path del progetto  
     String radice = System.getProperty("user.dir")
                + File.separator;
     
     String path1 = radice+"master/";
     String path2 = radice+"slave1/";
     String path3 = radice+"slave2/";
     String path4 = radice+"slave3/";//lo aggiungo a run time
    
     //numero di componenti software da gestire nella
     //creazione dinamica del file di conf del log
     int n=3;
     
     System.out.println("I path dei componenti software che partecipano al processo di composizione dimanica sono:");
     System.out.println(path1);
     System.out.println(path2);
     System.out.println(path3);
     //System.out.println(path4); 
     
     //vettore input preliminare riempito con le componenti software
     String[] vett= new String[n];
     vett[0]=path1;
     vett[1]=path2;
     vett[2]=path3;
     //vett[3]=path4;       
       
//#################################       
       
//dichiaro il path del file di configurazione di log4j   
 String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "master_dinamic.xml";    
       
     //effettuo un controllo sulla sua esistanza  
     File  file =new File(log4jConfigFile);
     
    
     boolean existsFile = file.isFile();
     
     
     /*
     //se esiste
     if(existsFile){
         System.out.println("Il file di configurazione master_dinamic esiste, non lo creo, la simulazione prosegue normalmente.");  
         DOMConfigurator.configure(log4jConfigFile);
     }
     */
     
     //se non esiste lo creo
     if (!existsFile) {
         
     System.out.println("master_dinamic.xml non esiste, inizio il processo di creazione DINAMICO");
     
     
     //Routine di creazione
     //#######################################################
     flag=creaFileConfigurazioneLog(n,vett,log4jConfigFile,radice);
     //#######################################################
     
     if(flag==0){
         //System.out.println(log4jConfigFile);
         DOMConfigurator.configure(log4jConfigFile);
     
        
     
     }//if
     }//!existsFile
     
          
     
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
      
     
      LogClass1 a = new LogClass1();
      a.metodo();
      
          
      LogClass2 b = new LogClass2();
      b.metodo();
      
      
      
      //Aggiungo un componente slave a run time
      
      //dim del vettore con le componenti software in input al processo di creazione dinamica
      int m=4;
      
     //vettore input preliminare riempito con le componenti software
     String[] vett_new= new String[m];
     vett_new[0]=path1;
     vett_new[1]=path2;
     vett_new[2]=path3;
     vett_new[3]=path4;
     
     
     System.out.println("\n\n");
     System.out.println("Aggiungo la componente: "+path4);
     System.out.println("Cancello il file di conf di log precedente ne creo uno aggiornato");
     System.out.println("\n\n");
     
      //Routine di creazione
     //#######################################################
     flag=creaFileConfigurazioneLog(m,vett_new,log4jConfigFile,radice);
     //#######################################################  
     
     //faccio un reset della configurazione di log4j
     LogManager.resetConfiguration();
      
    //se non ci sono stati errori nel processo di creazione 
     if(flag==0){
         //System.out.println(log4jConfigFile);
         DOMConfigurator.configure(log4jConfigFile);
     }
     
     //########################################
     //continuo con l'esecuzione del programma#
     //########################################
     
      LogClass3 c = new LogClass3();
      c.metodo(); 
        
       
       //CANCELLO il file di conf di log per esigenze operative  
        deleteFile(log4jConfigFile);  
        
       
       //boolean ok;
       //File f = new File(radice +"/LOGS");
       //ok=deleteDirectory(f);
    
        
        
   }//main
   

/**
 * Funzione principale del progetto
 * @param n dim del vettore vett
 * @param vett vettore contenente i path delle componenti validate
 * @param log4jConfigFile path del futuro file di configurazione di log4j
 * @param radice path del progetto
 * @return 0 procedura corretta
 * @return 1 errore 
 */   
static int creaFileConfigurazioneLog(int n, String[] vett, String log4jConfigFile, String radice){

     //########################
     //Processo di validazione# 
     //########################
     //vettore che conterrà solo le componenti sw validate
     String[] vett_validato= new String[n];
     int flag=0;
     int j=0;//dim del vettore validato
     
     for(int i=0; i<n;i++){
         flag=validaComponenteSW(vett[i]);
         if(flag==0){vett_validato[j]=vett[i];j++;}
     flag=0;
     }//
     
     //debug
     for(int i=0;i<j;i++){System.out.println("Componente software validato: "+vett_validato[i]);}
     //

     //adesso vett_validato contiene l'input corretto da passare 
     //al processo di composizione del file di configurazione
     
     //#########################
     //Processo di composizione# 
     //#########################
     
     String log_finale = "";
     
     //stringa che contiene la configurazione finale
     log_finale=componiConfLog(vett_validato,j,radice);
     
     //System.out.println(log_finale);
     
     int alert=0;
     
     //salvo la stringa contenente la configurazione finale  
     //sul file deputato ad essere il file di configurazione
     
     alert=stringToFile(log4jConfigFile,log_finale);
     
     System.out.println(log4jConfigFile);
     
     if(alert==1){System.out.println("ERRORE nel processo di creazione");}
     
     return alert;
     }//creaFileConfigurazioneLog
   
   
 
/**
  * Questa funzione serve per validare un componente software 
  * rispetto al processo di creazione dinamica del file di 
  * configurazione di log4j. La "validazione" consiste nella 
  * verifica dell'esistenza dei 3 file "frammenti" richiesti come 
  * condizione necessaria.Non viene effettuato nessun controllo 
  * sul contenuto dei file.
  * 
  * appender.txt
  * logger.txt
  * rootLogger.txt
  * 
  * @param path path dove trovare i file per un dato componente software
  * @return 0 procedura corretta
  * @return 1 errore, almeno 1 file non è stato trovato
  */  
static int validaComponenteSW(String path){
     //flag restituito 
     int flag=0;
     //##################################
     //Verificare esistenza appender.xml#
     //##################################
     String appender=path+"/appender.xml";
     //apro il file 
     flag=validaFile(appender);
     //################################
     //Verificare esistenza logger.xml#
     //################################
     if(flag==0){
     String logger=path+"/logger.xml";
     flag=validaFile(logger);
     }
     //####################################
     //Verificare esistenza rootLogger.xml#
     //####################################
     if(flag==0){
     String rootLogger=path+"/rootLogger.xml";
     //apro il file 
      flag=validaFile(rootLogger);
     }
return flag;
}//validaPath   
   
/**
 * Questo metodo compone dinamicamente il file di configurazione di log4j a partire
 * dai frammenti presenti su percorsi specifici dei componenti software.
 * @param vett_ok vettore contenente i path dove prendere i file dei componenti software validati
 * @param n dim fisica del vettore vett_ok
 * @param radice path di ambiente del progetto  
 * @return stringa contenente il file di configurazione di log finale
 */
static String componiConfLog(String[] vett_ok,int n,String radice){
     String Log_Finale ="";
    
              
     String TESTA_configuration ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE log4j:configuration SYSTEM \"log4j.dtd\">\n<log4j:configuration>\n";
     String CODA_configuration ="</log4j:configuration>";
     
     String TESTA_rootLogger = "<logger name=\"log4j.rootLogger\" additivity=\"false\">\n<level value=\"DEBUG\"/>\n";
     String CODA_rootLogger ="</logger>\n</log4j:configuration>";
     
     
    TESTA_configuration = TESTA_configuration.trim().replaceFirst("^([\\W]+)<","<");
    CODA_configuration = CODA_configuration.trim().replaceFirst("^([\\W]+)<","<"); 
    TESTA_rootLogger.trim().replaceFirst("^([\\W]+)<","<");  
    CODA_rootLogger.trim().replaceFirst("^([\\W]+)<","<");  
     
     //stringhe di comodo 
     String Appenders ="";
     String Loggers ="";
     String RootLoggers ="";
     String comodo = "";
     
    //funzione per la fusione di tutti gli appender
    Appenders=componiAppConf(vett_ok,n);
    //System.out.println("Appenders"+Appenders);
    //funzione per la fusione di tutti logger
    Loggers=componiLogConf(vett_ok,n);
    //System.out.println("Loggers"+Loggers);
    //funzione per la fusione di tutti i rootLogger
    RootLoggers=componirootLogConf(vett_ok,n);
    //System.out.println("RootLoggers"+RootLoggers);
    
    Log_Finale=TESTA_configuration+Appenders+Loggers+TESTA_rootLogger+RootLoggers+CODA_rootLogger;
    
 return Log_Finale;
}//componiConfLog 

/**
 * Questo metodo preleva tutti i frammenti di tipo appender da tutti i componenti 
 * software e li fonde in un unica stringa.
 * @param path vettore contenente i path dove prendere i file dei componenti software
 * @param n dim fisica di path
 * @return stringa contenente tutti i frammenti appender delle componenti presnti nel vettore path 
 */
static String componiAppConf(String [] path,int n){
    String com1 ="",com2 ="";
    for(int i=0;i<n;i++){
        try {
            System.out.println(path[i]+"appender.xml  "+i);
            com1=fileToString(path[i]+"appender.xml");
            com2=com2+com1;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(PilotaLogClever.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
 
 
 return com2;   
}//componiAppConf

/**
 * Questo metodo preleva tutti i frammenti di tipo logger da tutti i componenti 
 * software e li fonde in un unica stringa.
 * @param path vettore contenente i path dove prendere i file dei componenti software
 * @param n dim fisica di path
 * @return stringa contenente tutti i frammenti logger delle componenti presenti nel vettore path
 */
static String componiLogConf(String[] path,int n){
    String com1 ="",com2 ="";
    for(int i=0;i<n;i++){
        try {
            System.out.println(path[i]+"logger.xml  "+i);
            com1=fileToString(path[i]+"logger.xml");
            com2=com2+com1;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(PilotaLogClever.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
 
 return com2;   
}//componiLogConf

/**
 * Questo metodo preleva tutti i frammenti di tipo rootLogger da tutti i componenti 
 * software e li fonde in un unica stringa.
 * @param path vettore contenente i path dove prendere i file dei componenti software
 * @param n dim fisica di path
 * @return stringa contenente tutti i frammenti rootLogger delle componenti presenti nel vettore path
 */
static String componirootLogConf(String[] path,int n){
    String com1 ="",com2 ="";
    for(int i=0;i<n;i++){
        try {
            System.out.println(path[i]+"rootLogger.xml  "+i);
            com1=fileToString(path[i]+"rootLogger.xml");
            com2=com2+com1;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(PilotaLogClever.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 
 return com2;   
}//componirootLogConf


/**
 * Questa funzione serve per verificare l'esistenza di un file
 * @param path percorso del file da verificare 
 * @return 0 il file esiste
 * @return 1 i1 filenon esiste
 */
static int validaFile(String path){
    int flag=0;
     //apro il file 
     File  file1 =new File(path);
     boolean existsFile1 = file1.isFile();
     if (!existsFile1){
         flag=1;
     System.out.println("Il file: "+path+" non esiste!!!");
     }
return flag;
}

/**
 * Scrive in append il contenuto_da_appenere (stringa), dentro il file_contenitore
 * (indicato dalla stringa del suo path)
 * @param link_file_contenitore path del file da riempire in append
 * @param contenuto_da_appendere contenuto da mettere nel link_file_contenitore
 */
static void componiFile(String link_file_contenitore, String contenuto_da_appendere){
   BufferedWriter bw = null;
   String file;
try {
    bw = new BufferedWriter(new FileWriter(link_file_contenitore, true));
    
    file=fileToString(contenuto_da_appendere);
    
    bw.write(file);
    bw.newLine();
    bw.flush();
} catch (IOException ioe) {
    ioe.printStackTrace();
} finally { // always close the file
    if (bw != null) {
        try {
            bw.close();
        } catch (IOException ioe2) {
            // just ignore it
        }
    }
}
}//componiFile


/**
 * Restituisce una stringa che contiene il contenuto del file indicato col suo path
 * Funzione usata all'interno di componiFile()
 * @param path percorso del file
 * @return 
 * @throws FileNotFoundException
 * @throws IOException 
 */
static String fileToString( String path ) throws FileNotFoundException, IOException{
    BufferedReader reader = new BufferedReader( new FileReader (path));
    String         line = null;
    StringBuilder  stringBuilder = new StringBuilder();
    String         ls = System.getProperty("line.separator");

    while( ( line = reader.readLine() ) != null ) {
        stringBuilder.append( line );
        stringBuilder.append( ls );
    }
   //System.out.println(stringBuilder.toString());
    return stringBuilder.toString();
}

/**
 * Crea un nuovo file e gli assegna text come contenuto
 * @param path dove crea il file
 * @param text testo che assegna al file
 * @return 0 funzionamento regolare
 * @return 1 errore
 */
static int stringToFile(String path, String text){
    int flag =0;
    PrintWriter out = null;
       try {
           out = new PrintWriter(path);
           out.println(text);
       } //try
       catch (FileNotFoundException ex) {
           java.util.logging.Logger.getLogger(PilotaLogClever.class.getName()).log(Level.SEVERE, null, ex);
           flag=1;
       } finally {
           out.close();
       }//finally
       
 return flag;
} //strinToFile

/**
 * Questo metodo crea una direcotory dato il percorso con nome
 * @param directoryName 
 */
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

/**
 * cancella un file
 * @param file 
 */
static void deleteFile(String file){
   // Creo un oggetto file
    File f = new File(file);
    f.delete();
    
}//CancellaFile

/**
 * Cancella una direcotry, anche piena. E' ricorsiva.
 * @param path
 * @return 
 */
public static boolean deleteDirectory(File path) {
             if(path.exists()) {
              File[] files = path.listFiles();
              for(int i=0; i<files.length; i++) {
                    if(files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                    }
                    else {
                        files[i].delete();
                    }
              }
      }
      return(path.delete());
}

}//class

