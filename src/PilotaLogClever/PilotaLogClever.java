
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
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import PilotaLogClever.slave.LogClass3; 
import componentiLogger.LOG;


public class PilotaLogClever {
    



  
 
   /**
    * MAIN che diventerà il contenuto dellAgent di Clever
    * @param args 
    */ 
   public static void main(String[] args) {
       
//############ INPUT: ###########################
       
//   A  
 
//path del progetto  
 String radice = System.getProperty("user.dir")
                + File.separator;
 
 //  B  
 
 //dichiaro il path del file di configurazione di log4j   
 String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "master_dinamic.xml";  
   
//   C  
//Componenti software che voglio includere nel  
//processo di creazione dinamica del file di log
   
     
   String path1 = radice+"master/";
   String path2 = radice+"slave1/";
   String path3 = radice+"slave2/";
   String path4 = radice+"slave3/";//lo aggiungo a run time
   
//vettore input preliminare riempito con le componenti software
   int n = 3;
   String[] vett= {path1,path2,path3};
        
//#######################################################    
     
      
    LOG log = new LOG(radice,log4jConfigFile,vett,n);

    
    //Pulisco la dir dei log di precedenti iterazioni
    log.deleteDir(radice+"/LOGS/");
    //Pulisco il file di conf di log4j di precedenti iterazioni  
    log.deleteFile(log4jConfigFile);
       
        
        
   int flag=0;
   
    
       
     
         
     //AVVIO ROUTINE DI CREAZIONE
     //#######################################
      flag=log.creaFileConfigurazioneLog();//#
     //#######################################
     //ASSEGNO IL FILE CREATO A LOG4J
     if(flag==0){log.assegnaConfToLog4j();}
    
     

     AvviaEsecuzionePilota();
           
          
     //AGGIUNGO UN  COMPONENTE A RUN TIME
      
     //dim del vettore con le componenti software in input al processo di creazione dinamica
     int m=4;
      
     //vettore input preliminare riempito con le componenti software
     String[] vett_new= new String[m];
     vett_new[0]=path1;
     vett_new[1]=path2;
     vett_new[2]=path3;
     vett_new[3]=path4;
     
     //debug
     System.out.println("\n\n");
     System.out.println("Aggiungo la componente: "+path4);
     System.out.println("Cancello il file di conf di log precedente e ne creo uno aggiornato");
     System.out.println("\n\n");
     
     
     
     //aggiorno l oggetto entro cui si svolgono tutte le operazioni
     log = new LOG(radice,log4jConfigFile,vett_new,m);
     
     //AVVIO ROUTINE DI CREAZIONE
     //####################################
     flag=log.creaFileConfigurazioneLog();
     //####################################  
     
     //ASSEGNO IL FILE CREATO A LOG4J
     if(flag==0){log.assegnaConfToLog4j();}
     
     
     //continuo con l'esecuzione del programma
     AvvioSlave3();   
       
        
   }//main
   

   /**
    * contiene comandi per simulare la presenza di 3 componenti software:
    * il master e 2 slave
    */
   static void AvviaEsecuzionePilota(){
    //logger del componenete software master 
    org.apache.log4j.Logger log0 = Logger.getLogger("com_foo");
    org.apache.log4j.Logger logger0 = Logger.getLogger("com_foo_bar");
    org.apache.log4j.Logger Logger0 = Logger.getLogger("logger");
    org.apache.log4j.Logger Log0 = Logger.getLogger("log");
    
    
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
   
      //avvio l esecuzione dei logger degli slave
      LogClass1 a = new LogClass1();
      a.metodo();
      
      LogClass2 b = new LogClass2();
      b.metodo();
      
    
}   
 
/**
 * simula l aggiunta si uno slave3 a run time
 */
static void AvvioSlave3(){
   //avvio l esecuzione dei logger degli slave
      LogClass3 c = new LogClass3();
      c.metodo();  
    
}





}//class

