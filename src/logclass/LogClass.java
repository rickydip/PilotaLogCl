
package logclass;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
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
         
     System.out.println("Il file di configurazione master_dinamic non esiste, inizio il processo di creazione");
   
     //###################
     //inizio processo di creazione del file
     //###################
     
     //#################################
     //Componenti software che voglio includere nel processo di creazione dinamica del file di log
     
     String radice = System.getProperty("user.dir")
                + File.separator;
     
     String path1 = radice+"master/";
     String path2 = radice+"slave1/";
     String path3 = radice+"slave2/";
     String file_configurazione = "";
     
     System.out.println("I path dei componenti software che partecipano al processo di composizione dimanica sono:");
     System.out.println(path1);
     System.out.println(path2);
     System.out.println(path3); 
     
     //vettore input con le componenti non validate
     int n=3;
     String[] vett= new String[n];
     
     vett[0]=path1;
     vett[1]=path2;
     vett[2]=path3;
     
         
     
     //########################
     //Processo di validazione# 
     //########################
     String[] vett_validato= new String[n];
     int flag=0;
     int j=0;//dim del vettore validato
     for(int i=0; i<n;i++){
     flag=validaPath(vett[i]);
     if(flag==0){vett_validato[j]=vett[i];j++;}
     flag=0;
     }//
     
     //debug
     for(int i=0;i<j;i++) System.out.println("Componente software validato: "+vett_validato[i]);
     //

     //adesso vett_validato contiene l'input corretto da passare 
     //al processo di composizione del file di configurazione
     
     //#########################
     //Processo di composizione# 
     //#########################
     String log_finale="";
     log_finale=componiConfLog(vett_validato,j,radice);
     
     System.out.println("#######################################");
     //System.out.println(log_finale);
     
     int alert=0;
     
     alert=stringToFile(log4jConfigFile,log_finale);
     
     System.out.println(log4jConfigFile);
     
     if(alert==1){
     
     System.out.println("ERRORE nel processo di creazione");
     
     }else{
         
     //System.out.println(log4jConfigFile);
         DOMConfigurator.configure(log4jConfigFile);
     }
     
     
     }//!existsFile
     
     else{
         System.out.println("Il file di configurazione master_dinamic esiste, non lo creo, la simulazione prosegue normalmente.");  
         System.out.println();
         System.out.println(log4jConfigFile);
         DOMConfigurator.configure(log4jConfigFile);
     }
     
        
         
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
      
      
   }//main
   
   
   
 /**
  * Questa funzione serve per validare un componente software 
  * rispetto al processo di creazione dinamica del file di 
  * configurazione di log4j. La validazione consiste nella 
  * verifica dell'esistenza dei 3 file "frammenti" richiesti:
  * 
  * appender.txt
  * logger.txt
  * rootLogger.txt
  * 
  * @param path path dove trovare i file per un dato componente software
  * @return 0 tutto ok
  * @return 1 almeno 1 file non è stato trovato
  */  
 static int validaPath(String path){
     //flag restituito 
     int flag=0;
     //###################################
     //Verificare eisistenza appender.xml#
     //###################################
     String appender=path+"/appender.xml";
     //apro il file 
     flag=validaFile(appender);
     //#################################
     //Verificare eisistenza logger.xml#
     //#################################
     if(flag==0){
     String logger=path+"/logger.xml";
     flag=validaFile(logger);
     }
     //#####################################
     //Verificare eisistenza rootLogger.xml#
     //#####################################
     if(flag==0){
     String rootLogger=path+"/rootLogger.xml";
     //apro il file 
      flag=validaFile(rootLogger);
     }
return flag;
}   
   
/**
 * Questo metodo compone dinamicamente il file di configurazione di log4j a partire
 * da frammenti presenti su percorsi specifici di alcuni componenti software.
 * @param vett_ok vettore contenente i path dove prendere i file dei componenti software validati
 * @param n dim fisica di vett_ok
 * @param radice path di ambiente del progetto dove reperire i frammenti presenti sulla directory /sistema 
 * presente nel componente software master
 * @return 0 nessun errore
 * @return 1 presenza di un errore
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
 * @param Appenders contenitore di tutti i frammenti appenders
 * @return 0 nessun errore
 * @return 1 presenza di un errore
 */
static String componiAppConf(String [] path,int n){
    String com1 ="",com2 ="";
    for(int i=0;i<n;i++){
        
            System.out.println(path[i]+"appender.xml  "+i);
        try {
            com1=fileToString(path[i]+"appender.xml");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LogClass.class.getName()).log(Level.SEVERE, null, ex);
        }
            //System.out.println(com1);
            com2=com2+com1;
       
    }
 
 
 return com2;   
}//componiAppConf

/**
 * Questo metodo preleva tutti i frammenti di tipo logger da tutti i componenti 
 * software e li fonde in un unica stringa.
 * @param path vettore contenente i path dove prendere i file dei componenti software
 * @param n dim fisica di path
 * @param Loggers contenitore di tutti i frammenti logger 
 * @return 0 nessun errore
 * @return 1 presenza di un errore
 */
static String componiLogConf(String[] path,int n){
    String com1 ="",com2 ="";
    for(int i=0;i<n;i++){
        try {
            System.out.println(path[i]+"logger.xml  "+i);
            com1=fileToString(path[i]+"logger.xml");
            com2=com2+com1;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LogClass.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
 
 return com2;   
}//componiLogConf

/**
 * Questo metodo preleva tutti i frammenti di tipo rootLogger da tutti i componenti 
 * software e li fonde in un unica stringa.
 * @param path vettore contenente i path dove prendere i file dei componenti software
 * @param n dim fisica di path
 * @param RootLoggers contenitore di tutti i frammenti rootLoggers
 * @return 0 nessun errore
 * @return 1 presenza di un errore
 */
static String componirootLogConf(String[] path,int n){
    String com1 ="",com2 ="";
    for(int i=0;i<n;i++){
        try {
            System.out.println(path[i]+"rootLogger.xml  "+i);
            com1=fileToString(path[i]+"rootLogger.xml");
            com2=com2+com1;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LogClass.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 
 return com2;   
}//componirootLogConf


/**
 * Questa funzione serve per verificare l'esistenza di un file
 * @param path percorso del file da verificare il file
 * @return 0 il file esiste
 * @return 1 i1 non esiste
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
 * @param file_contenitore path del file da riempire in append
 * @param contenuto_da_appendere contenuto da mettere nel file_contenitore
 */
static void componiFile(String file_contenitore, String contenuto_da_appendere){
   BufferedWriter bw = null;
   String file;
try {
    bw = new BufferedWriter(new FileWriter(file_contenitore, true));
    
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
 * Restituisce una stringa che contiene il contenuto del file indicato da path
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
 * Crea un nuovo file
 * @param path dove crea il file
 * @param text testo che assegna al file
 * @return 
 */
static int stringToFile(String path, String text){
    int flag =0;
    PrintWriter out = null;
       try {
           out = new PrintWriter(path);
           out.println(text);
       } //try
       catch (FileNotFoundException ex) {
           java.util.logging.Logger.getLogger(LogClass.class.getName()).log(Level.SEVERE, null, ex);
           flag=1;
       } finally {
           out.close();
       }//finally
       
       
    return flag;
} //strinToFile











}//class

