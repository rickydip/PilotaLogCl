
package componentiLogger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @author riccardo
 */
public class LOG {
 
//#######   A  #########
 
//path del progetto  
 private String radice ;
 
 //#######   B  #########
 
 //dichiaro il path del file di configurazione di log4j   
 private String log4jConfigFile; 
         
   
//#######   C  #########   
//Componenti software che voglio includere nel  #
//processo di creazione dinamica del file di log#
//###############################################     
     
   String[] componenti_sw; 
   int n_comp_sw; //dim vettore

//costruttori
   
public LOG(String radice, String log4jConfigFile, String[] componenti_sw, int n_comp_sw) {
     this.radice = radice;
     this.log4jConfigFile = log4jConfigFile;
     this.componenti_sw = componenti_sw;
     this.n_comp_sw = n_comp_sw;
    }
   

public LOG() {
     this.radice = "";
     this.log4jConfigFile = "";
     this.componenti_sw = null;
     this.n_comp_sw = 0;
    }






//metodi setter e getter

   
   public String getRadice() {
        return radice;
    }

    public void setRadice(String radice) {
        this.radice = radice;
    }

    public String getLog4jConfigFile() {
        return log4jConfigFile;
    }

    public void setLog4jConfigFile(String log4jConfigFile) {
        this.log4jConfigFile = log4jConfigFile;
    }

    public String[] getComponenti_sw() {
        return componenti_sw;
    }

    public void setComponenti_sw(String[] componenti_sw) {
        this.componenti_sw = componenti_sw;
    }

    public int getN_comp_sw() {
        return n_comp_sw;
    }

    public void setN_comp_sw(int n_comp_sw) {
        this.n_comp_sw = n_comp_sw;
    }
   
   
     
    
    
/**
 * Funzione principale del progetto
 * @param n dim del vettore vett
 * @param vett vettore contenente i path delle componenti validate
 * @param log4jConfigFile path del futuro file di configurazione di log4j
 * @param radice path del progetto
 * @return 0 procedura corretta
 * @return 1 errore 
 */   
public int creaFileConfigurazioneLog(){
//int n, String[] vett, String log4jConfigFile
     //########################
     //Processo di validazione# 
     //########################
     //vettore che conterrà solo le componenti sw validate
     String[] vett_validato= new String[getN_comp_sw()];
     int flag=0;
     int j=0;//dim del vettore validato
     
     for(int i=0;i<getN_comp_sw();i++){
         flag=validaComponenteSW(getComponenti_sw()[i]);
         if(flag==0){vett_validato[j]=getComponenti_sw()[i];j++;}
         if(flag==1){vett_validato[j]=assegnaFrammento(getComponenti_sw()[i],i);j++;}
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
     log_finale=componiConfLog(vett_validato,j,getRadice());
     
     //System.out.println(log_finale);
     
     int alert=0;
     
     //salvo la stringa contenente la configurazione finale  
     //sul file deputato ad essere il file di configurazione
     
     alert=stringToFile(getLog4jConfigFile(),log_finale);
     
     System.out.println(getLog4jConfigFile());
     
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
public int validaComponenteSW(String path){
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
 * 
 * @param componente_sw non validato
 * @param n_fram
 * @return 
 */
public String assegnaFrammento(String componente_sw, int n_fram){
    String output="";  int flag=0; String nome_app="nome";
    //creo il nuovo path
    output=componente_sw+"frammento_default/";
    //se già esiste la cancello
    deleteDir(output);
    //creo la directory
    creaDir(output);
    //##########################################
    //creo il contenuto di appender.xml
    String text_appender ="<appender name=\""+nome_app+n_fram+"\" class=\"org.apache.log4j.FileAppender\">\n" +
"   <param name=\"file\" value=\""+getRadice()+"/LOGS/logclass"+n_fram+"_output/LOG.txt"+"\"/>\n" +
"   <layout class=\"org.apache.log4j.PatternLayout\" >\n" +
"     <param name=\"ConversionPattern\" value=\"%d{yyyy-MM-dd HH:mm:ss} %p [%C:%L] - %m%n\"/>     \n" +
"   </layout>\n" +
"   <filter class=\"org.apache.log4j.varia.LevelMatchFilter\">\n" +
"      <param name=\"LevelToMatch\" value=\"INFO\" />\n" +
"      <param name=\"AcceptOnMatch\" value=\"true\" />\n" +
"    </filter>\n" +
"    <filter class=\"org.apache.log4j.varia.DenyAllFilter\" /> \n" +
"</appender>";
    //creo il file
    flag=stringToFile(output+"appender.xml",text_appender);
    if(flag==1){exit(1);System.out.println("ERRORE nella creazione del file appender.xml!!!");}
    //##########################################
    //bisogna valutare il numero di logger presenti sul file
       
        
           // apro il file che contiene i nomi dei logger
           ArrayList lista = new ArrayList();
           String file = null;
       try {
           file = fileToString(componente_sw+"/logger_attivi.txt");
       } catch (IOException ex) {
           java.util.logging.Logger.getLogger(LOG.class.getName()).log(Level.SEVERE, null, ex);
       }
           lista = stringToArrayList(file);
           
           //debug
           //System.out.println("il file contiene logger n°: "+lista.size()+"\n\n");
           //System.out.println(lista);
               
    
    
    
    
    //creo il contenuto di appender.xml
    String text_logger =""; 
    String comodo="";
    
    for(int i=0;i<lista.size();i++){
        
        comodo = "<logger name=\""+lista.get(i)+"\" additivity=\"false\">\n<level value=\"debug\"/>\n";
        text_logger= text_logger+ comodo+"<appender-ref ref=\""+nome_app+n_fram+"\" />\n</logger>\n\n";
        
    }//for
    
    //debug
    //System.out.println(text_logger);
        
    //creo il file
    flag=stringToFile(output+"logger.xml",text_logger);
    if(flag==1){exit(1);System.out.println("ERRORE nella creazione del file logger.xml!!!");}
    
    //##########################################
    //creo il contenuto di appender.xml
    String text_rlogger = " <appender-ref ref=\""+nome_app+n_fram+"\"/>";
    //creo il file
    flag=stringToFile(output+"rootLogger.xml",text_rlogger);
    if(flag==1){exit(1);System.out.println("ERRORE nella creazione del file rootLogger.xml!!!");}
    //##########################################
    
 return output;    
}

/**
 * Questo metodo compone dinamicamente il file di configurazione di log4j a partire
 * dai frammenti presenti su percorsi specifici dei componenti software.
 * @param vett_ok vettore contenente i path dove prendere i file dei componenti software validati
 * @param n dim fisica del vettore vett_ok
 * @param radice path di ambiente del progetto  
 * @return stringa contenente il file di configurazione di log finale
 */
public String componiConfLog(String[] vett_ok,int n,String radice){
     String Log_Finale ="";
    
              
     String TESTA_configuration ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE log4j:configuration SYSTEM \"log4j.dtd\">\n<log4j:configuration>\n";
     String CODA_configuration ="</log4j:configuration>";
     
     String TESTA_rootLogger = "<logger name=\"log4j.rootLogger\" additivity=\"false\">\n<level value=\"DEBUG\"/>\n";
     String CODA_rootLogger ="</logger>\n</log4j:configuration>";
     
     
    TESTA_configuration = TESTA_configuration.trim().replaceFirst("^([\\W]+)<","<");
    CODA_configuration = CODA_configuration.trim().replaceFirst("^([\\W]+)<","<"); 
    
     
     //stringhe di comodo 
     String Appenders ="";
     String Loggers ="";
     String RootLoggers ="";
     
     
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
public String componiAppConf(String [] path,int n){
    String com1 ="",com2 ="";
    for(int i=0;i<n;i++){
        try {
            System.out.println(path[i]+"appender.xml  "+i);
            com1=fileToString(path[i]+"appender.xml");
            com2=com2+com1;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LOG.class.getName()).log(Level.SEVERE, null, ex);
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
public String componiLogConf(String[] path,int n){
    String com1 ="",com2 ="";
    for(int i=0;i<n;i++){
        try {
            System.out.println(path[i]+"logger.xml  "+i);
            com1=fileToString(path[i]+"logger.xml");
            com2=com2+com1;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LOG.class.getName()).log(Level.SEVERE, null, ex);
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
public String componirootLogConf(String[] path,int n){
    String com1 ="",com2 ="";
    for(int i=0;i<n;i++){
        try {
            System.out.println(path[i]+"rootLogger.xml  "+i);
            com1=fileToString(path[i]+"rootLogger.xml");
            com2=com2+com1;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LOG.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 
 return com2;   
}//componirootLogConf

/**
 * Questa funzione "Attualmente" serve per verificare l'esistenza di un file
 * @param path percorso del file da verificare 
 * @return 0 il file esiste
 * @return 1 i1 filenon esiste
 */
 public int validaFile(String path){
    int flag=0;
     //apro il file 
     File  file1 =new File(path);
     boolean existsFile1 = file1.isFile();
     if (!existsFile1){
         flag=1;
     System.out.println("Il file: "+path+" non esiste!!!");
     }
return flag;
}//validaFile

/**
 * Scrive in append il contenuto_da_appenere (stringa), dentro il file_contenitore
 * (indicato col suo path)
 * @param link_file_contenitore path del file da riempire in append
 * @param contenuto_da_appendere contenuto da mettere nel link_file_contenitore
 */
public void componiFile(String link_file_contenitore, String contenuto_da_appendere){
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
public String fileToString( String path ) throws FileNotFoundException, IOException{
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
 * Crea un nuovo file al path definito e gli assegna text come contenuto
 * @param path dove crea il file
 * @param text testo che assegna al file
 * @return 0 funzionamento regolare
 * @return 1 errore
 */
public int stringToFile(String path, String text){
    int flag =0;
    PrintWriter out = null;
       try {
           out = new PrintWriter(path);
           out.println(text);
       } //try
       catch (FileNotFoundException ex) {
           java.util.logging.Logger.getLogger(LOG.class.getName()).log(Level.SEVERE, null, ex);
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
public void creaDir(String directoryName){
        File theDir = new File(directoryName);

  // if the directory does not exist, create it
  if (!theDir.exists()) {
    System.out.println("creating directory: " + directoryName);
    boolean result = theDir.mkdir();  

     if(result) {    
       System.out.println("DIR created");  
     }
   }
}//creaDir

/**
 * cancella un file
 * @param file 
 */
public void deleteFile(String file){
   // Creo un oggetto file
    File f = new File(file);
    f.delete();
    
}//deleteFile

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
}//deleteDirectory

/**
 * Cancella una directory, anche piena. E' ricorsiva.
 * @param path percorso della directory
 * @return 
 */
public static void deleteDir(String path) {
    
    File file = new File(path);
      
             if(file .exists()) {
              File[] files = file.listFiles();
              for(int i=0; i<files.length; i++) {
                    if(files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                    }
                    else {
                        files[i].delete();
                    }
              }
      }
      
}//deleteDir

/**
 * Questo metodo trasforma una stringa di testo in un array list, dove ciscun 
 * campo è una parola della stringa
 * @param stringa
 * @return 
 */
public ArrayList stringToArrayList (String stringa){
     //imposto il separatore
     String[] strValues = stringa.split(" "); 
     
     //ad ogni elemento del vettore levo lo spazio prima e dopo del contenuto
     for(int i=0; i<strValues.length; i++) {
      strValues[i]=strValues[i].trim();
      }
     
     ArrayList<String> lista = new ArrayList<String>(Arrays.asList(strValues));
     return lista;
}// stringToArrayList

/**
 * Metodo che aggiorna la configurazione di log4j
 */
public void assegnaConfToLog4j(){
     //faccio un reset di eventuali precedenti configurazione log4j
     LogManager.resetConfiguration();
     //setto il file di configurazione in log4j
     DOMConfigurator.configure(getLog4jConfigFile());    
    
    
}//assegnaConfToLog4j

    
    
    
}
