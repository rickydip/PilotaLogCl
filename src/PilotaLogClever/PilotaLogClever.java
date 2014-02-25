
package PilotaLogClever;



import java.io.File;
import PilotaLogClever.slaves.*;
import componentiLogger.LOG;
import org.apache.log4j.Logger;

/**
 * contiene il main del Pilota
 * @author riccardo
 */
public class PilotaLogClever {
    
    static Logger log2 = Logger.getLogger("Juventus");
    
//############ INPUT: ###########################
       
//   A  
 
//path del progetto  
static String radice = System.getProperty("user.dir")
                + File.separator;
 
 //  B  
 
 //dichiaro il path del file di configurazione di log4j   
static String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "src/componentiLogger/master_dinamic.xml";  
   
//   C  
//Componenti software che voglio includere nel  
//processo di creazione dinamica del file di log
   
static String comodo= radice +"/src/PilotaLogClever/";

static   String path1 = comodo+"Master/log_conf/";
static   String path2 = comodo+"Slave/log_conf/";
static   String path3 = comodo+"Slave1/log_conf/";
static   String path4 = comodo+"Slave3/log_conf/";

static   String path5 = comodo+"Slave2/log_conf/";
   
//vettore input preliminare riempito con le componenti software
static   int n = 4;
static   String[] vett= {path1,path2,path3,path4,path5};

static int m = 5;
//#######################################################    

    
  
     
   /**
    * Simulazione ambiente Clever per creazione dinamica dile log4j
    * @param args 
    */ 
   public static void main(String[] args) {
        int flag=0; 

     
    //creo l'oggetto entro cui si svolgono tutte le operazioni  
   LOG log = new LOG(radice,log4jConfigFile,vett,n);

   
      
    //Pulisco la dir dei log di precedenti iterazioni
    log.deleteDir(radice+"/LOGS/");
    //Pulisco il file di conf di log4j di precedenti iterazioni  
    log.deleteFile(log4jConfigFile);
       
        
     //AVVIO ROUTINE DI CREAZIONE
     //#######################################
      flag=log.creaFileConfigurazioneLog();//#
     //ASSEGNO IL FILE CREATO A LOG4J      //#
     if(flag==0){log.assegnaConfToLog4j();}//#
     //#######################################
     

     avviaEsecuzionePilota();
         
     //debug
     System.out.println("\n\n");
     System.out.println("Aggiungo la componente: "+path5);
     System.out.println("Cancello il file di conf di log precedente e ne creo uno aggiornato");
     System.out.println("\n\n");
     //
     
     
     //aggiorno l'oggetto entro cui si svolgono tutte le operazioni
     //con m=5 assegno anche il path5
     log = new LOG(radice,log4jConfigFile,vett,m);
     
     
     //AVVIO ROUTINE DI CREAZIONE
     //#######################################
     flag=log.creaFileConfigurazioneLog(); //#
     //ASSEGNO IL FILE CREATO A LOG4J      //#
     if(flag==0){log.assegnaConfToLog4j();}//#
     //#######################################
     
     //continuo con l'esecuzione del programma
     avviaEsecuzioneSlave2();   
      
  
     
   }//main
   

   /**
    * contiene comandi per simulare la presenza di 3 componenti software:
    * il master e 2 slave
    */
   static void avviaEsecuzionePilota(){
    
      //avvio l esecuzione dei logger degli slave
      Master a = new Master();
      a.metodo();
      
      Slave b = new Slave();
      b.metodo();
      
    
}   
 
/**
 * simula l'aggiunta si uno slave3 a run time
 */
static void avviaEsecuzioneSlave2(){
   //avvio l esecuzione dei logger degli slave
      Slave2 q = new Slave2();
      q.metodo();  
    
}





}//class

