/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logclass;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import static java.lang.System.exit;
import java.util.StringTokenizer;

/**
 * Questa classe serve per ricavare le informazioni presenti su un file di 
 * configurazione di log4j.
 * Dato un file di log presente su "path", questo viene divido in tanti frammenti
 * quanti sono i tag di appender e logger. Di ogni frammento verrà creato un 
 * file xml. 
 * 
 * @author Riccardo Di Pietro
 */
public class InfoLogFile {

   
    //variabili di classe
    
    private String path; //path in cui prende il file su cui esegue le operazioni previste
    
    private Appender[] appender; //vettore di appender
    private Logger[] logger;//vettore di logger
    
    private int n_app; //dim da assegnare al vettore di appender
    private int n_log;//dim da assegnare al vettore di logger

    
    
  /**
     * Costruttore
     * @param path path del file di configuraione di log
     * @param path_op path dove crea file di comodo 
     * @param appender vettore di oggetti appender
     * @param logger vettore di oggetti logger
     * @param n_app dim fisica del vettore di appender
     * @param n_log dim fisica del vettore di logger
     */
  public InfoLogFile(String path,Appender[] appender, Logger[] logger, int n_app, int n_log) {
        this.path = path;
        
        this.appender = appender;
        this.logger = logger;
        this.n_app = n_app;
        this.n_log = n_log;
    }
  
  /**
   * Costruttore di default
   */  
  public InfoLogFile() {
        this.path = "";
        this.appender = null;
        this.logger = null;
        this.n_app = 0;
        this.n_log = 0;
    }  
    
    
/**
 * Costruttore per inizializzare il path
 */
public InfoLogFile(String path) {
        this.path = path;
        
    }  

   
  
  
  
  //metodi getter e setter
 public String getPath() {
        return path;
    }

 public void setPath(String path) {
        this.path = path;
    }

 
 
 public Appender[] getAppender() {
        return appender;
    }

 public void setAppender(Appender[] appender) {
        this.appender = appender;
    }

 public Logger[] getLogger() {
        return logger;
    }

 public void setLogger(Logger[] logger) {
        this.logger = logger;
    }

 public int getN_app() {
        return n_app;
    }

 public void setN_app(int n_app) {
        this.n_app = n_app;
    }

 public int getN_log() {
        return n_log;
    }

 public void setN_log(int n_log) {
        this.n_log = n_log;
    }


 

/**
 * Dato un file indicato dal path globale della classe, un pattern iniziale ed
 * un pattern finale, restituisce il numero di file creati, ognuno contenente
 * il contenuto del pattern.
 * 
 * Usato opportunamente, questa funzione serve per isolare
 * gli appender e i logger presenti sul file di logger.
 * 
 * "<appender name=\"","</appender>"
 * "<logger name=\"", "</logger>"
 * 
 * @param startData pattern iniziale
 * @param endData pattern finale
 * @param path path dove posiziona i file risultanti
 *
 */
int splitXML(String startData, String endData, String path_risultato){
         //questo getPath si riferisce al file di conf che vado a splittare     
         String data = readFile(getPath());
         //    System.out.println("file da cui prendo le route: "+getPath());
         //   String startData = "<route id=";
         //    startData = "<route id=";

            StringTokenizer stk = new StringTokenizer(data, startData);
            int count = 0;
            while (stk.hasMoreTokens()) {
                  String token = stk.nextToken();
                  count++;
            }
            //
            //System.out.println("numero di file: "+count);
            //String endData = "</route>";
           // endData = "</route>";
            
            
            int start = data.indexOf(startData);
            int end = data.indexOf(endData);
            end = end+12;
            int i = 1;
          
              while (start!=-1 && end != -1) {  
                
                  String fileData = data.substring(start,end);
                  //System.out.println(BancsData);
                  data = data.substring(end);
                  start = data.indexOf(startData);
                  end = data.indexOf(endData);
                  end = end+12;
                  //questa crea il file al path fornito al metodo
                  createFile(fileData,i,path_risultato);
                  i++;
                
            }//while
return i-1;
}//splitXML   

/**
 * E' una funzione interna a splitXML()
 * Legge un file al path fornito
 * @param path percorso del file  da leggere
 * @return 
 */
private String readFile(String file_sorgente) {
            StringBuilder sb = new StringBuilder();
            try {
                  File file = new File(file_sorgente);
                  FileInputStream fis = new FileInputStream(file);
                  BufferedInputStream bis = new BufferedInputStream(fis);
                  int in = 0;
                  char inChar;
                  do {
                        in = bis.read();
                        inChar = (char) in;
                        if (in != -1) {
                              sb.append(inChar);
                        }
                  } while ((in != -1));
                  bis.close();
            } catch (FileNotFoundException e) {
                  e.printStackTrace();
            } catch (IOException ioe) {
                  ioe.printStackTrace();
            }
            return sb.toString();

      }

/**
 * E' una funzione interna a splitXML().
 * 
 * @param data contenuto del file, frammento dell'operazione di split
 * @param count numero di file, appare nel nome del file creato
 * @param path indica dove viene creato il file
 */
private void createFile(String data, int count, String path_risultato) {
            FileOutputStream fos;
            try {
                  fos = new FileOutputStream(path_risultato +"target" + count + ".xml");
                  
                  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));  
            bw.write(data);  
            bw.newLine();  
            bw.flush();  
            count++;
            } catch (Exception e) {
                  e.printStackTrace();
            }  
 }//createFile







/**
 * Metodo si occupa si ricavare le informazioni degli appender di un file di log
 * @param startData pattern iniziale
 * @param endData pattern finale
 * @param path_risultato dove andare a collocare i file
 */
void ricavaInfo_app(String startData, String endData,String path_risultato){
    
    
    int n;
    
    n=splitXML(startData, endData,path_risultato);
    //debug
    System.out.println("Con ricavaInfo_app(), ho prodotto frammenti: "+n);
    //
    n=n+1;
    //di ogni frammento vengono salvate le informazioni
    for (int i=1;i<n;i++){
        //debug
        System.out.println(path_risultato+"target" + i + ".xml");
        //
        setAppender(path_risultato+"target" + i + ".xml", path_risultato+"target_info" + i + ".xml");
     }//for
    
       
    
}//ricavaInfo

/**
 * Metodo si occupa si ricavare le informazioni dei logger di un file di log
 * @param startData pattern iniziale
 * @param endData pattern finale
 * @param path_risultato dove andare a collocare i file
 * @return restituisce una stringa che contiene la parte logger tranne il rootlogger
 */
String ricavaInfo_log(String startData, String endData,String path_risultato){
    
       
    int n;
    n=splitXML2(startData,endData,path_risultato);
    //debug
    System.out.println("Con ricavaInfo_log(), ho prodotto frammenti: "+n);
    System.out.println("il "+n+" è il rootLogger e non interessa trattarlo");
    //
    n=n+1;
    String frammento , file_contenitore;
    for (int i=1;i<n-1;i++){
        //debug
        //System.out.println(path_risultato +"target" + i + ".xml");
        //
       frammento=path_risultato+"target" + i + ".xml";
        
       setLogger(frammento, path_risultato+"target_info" + i + ".xml");
       
       //
       file_contenitore=path_risultato+"contenitore.xml\"";
       componiFile(file_contenitore,frammento);
       
       }//for
    
    return path_risultato+"contenitore.xml";
    
}//ricavaInfo_log




/**
 * Pone in un oggetto Appender le informazioni ricavate da un frammento appender
 * risultante da un'operazione di splitXML()
 * @param path percorso del file frammento Appender
 */
void setAppender(String path_frammento,String path_operativo){
    //inizializzo l'oggetto appender col path del file frammento
    Appender a=new Appender(path_frammento);
    //questo metodo setta le informazioni ricavate dal parsing nell'oggetto Appender
    //creato precedentemente
    a.frammentoToFile(path_frammento, path_operativo);
     
}//setAppender


/**
 * Pone in un oggetto Logger le informazioni ricavate da un frammento logger
 * risultante da un'operazione di splitXML()
 * @param path_frammento percorso del file frammento Logger
 * @param path_operativo crea un file con le informazioni sul frammento(risultato di un parsing)
 */
void setLogger(String path_frammento,String path_operativo){
    //inizializzo l'oggetto Logger col path del file frammento
    Logger a=new Logger(path_frammento);
    //questo metodo setta le informazioni ricavate dal parsing nell'oggetto Logger
    //creato precedentemente
   a.frammentoToFile(path_frammento, path_operativo);
   
        
}//setLogger

/**
 * Scrive in append il contenuto_da_appenere (stringa), dentro il file_contenitore
 * (indicato dalla stringa del suo path)
 * @param file_contenitore path del file da riempire in append
 * @param contenuto_da_appendere contenuto da mettere nel file_contenitore
 */
void componiFile(String file_contenitore, String contenuto_da_appendere){
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
}//componi file


/**
 * Restituisce una stringa che contiene il contenuto del file indicato da path
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
 * versione per ricavaInfo_log()
 * @param startData
 * @param endData
 * @param path_risultato
 * @return 
 */
int splitXML2(String startData, String endData, String path_risultato){
         //questo getPath si riferisce al file di conf che vado a splittare     
         String data = readFile(getPath());
         //    System.out.println("file da cui prendo le route: "+getPath());
         //   String startData = "<route id=";
         //    startData = "<route id=";

            StringTokenizer stk = new StringTokenizer(data, startData);
            int count = 0;
            while (stk.hasMoreTokens()) {
                  String token = stk.nextToken();
                  count++;
            }
            //
            //System.out.println("numero di file: "+count);
            //String endData = "</route>";
           // endData = "</route>";
            
            
            int start = data.indexOf(startData);
            int end = data.indexOf(endData);
            end = end+10;
            int i = 1;
          
              while (start!=-1 && end != -1) {  
                
                  String fileData = data.substring(start,end);
                  //System.out.println(BancsData);
                  data = data.substring(end);
                  start = data.indexOf(startData);
                  end = data.indexOf(endData);
                  end = end+10;
                  //questa crea il file al path fornito al metodo
                  createFile(fileData,i,path_risultato);
                  i++;
                
            }//while
return i-1;
}//splitXML   

}//class
