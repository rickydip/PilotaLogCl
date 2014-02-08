
package PilotaLogClever;



import java.io.File;
import PilotaLogClever.slaves.*;
import componentiLogger.LOG;

/**
 * contiene il main del Pilota
 * @author riccardo
 */
public class PilotaLogClever {
    
//############ INPUT: ###########################
       
//   A  
 
//path del progetto  
static String radice = System.getProperty("user.dir")
                + File.separator;
 
 //  B  
 
 //dichiaro il path del file di configurazione di log4j   
static String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "master_dinamic.xml";  
   
//   C  
//Componenti software che voglio includere nel  
//processo di creazione dinamica del file di log
   
     
static   String path1 = radice+"master/";
static   String path2 = radice+"slave1/";
static   String path3 = radice+"slave2/";
static   String path4 = radice+"slave3/";//lo aggiungo a run time
   
//vettore input preliminare riempito con le componenti software
static   int n = 3;
static   String[] vett= {path1,path2,path3,path4};

static int m = 4;
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
     System.out.println("Aggiungo la componente: "+path4);
     System.out.println("Cancello il file di conf di log precedente e ne creo uno aggiornato");
     System.out.println("\n\n");
     //
     
     
     //aggiorno l'oggetto entro cui si svolgono tutte le operazioni
     //con m=4 assegno anche il path4
     log = new LOG(radice,log4jConfigFile,vett,m);
     
     
     //AVVIO ROUTINE DI CREAZIONE
     //#######################################
     flag=log.creaFileConfigurazioneLog(); //#
     //ASSEGNO IL FILE CREATO A LOG4J      //#
     if(flag==0){log.assegnaConfToLog4j();}//#
     //#######################################
     
     //continuo con l'esecuzione del programma
     avviaEsecuzioneSlave3();   
       
        
   }//main
   

   /**
    * contiene comandi per simulare la presenza di 3 componenti software:
    * il master e 2 slave
    */
   static void avviaEsecuzionePilota(){
    
      //avvio l esecuzione dei logger degli slave
      Master a = new Master();
      a.metodo();
      
      //slave1 non verrà validato e verranno creati dei framment idi default
      Slave1 b = new Slave1();
      b.metodo();
      
      Slave2 c = new Slave2();
      c.metodo();
      
    
}   
 
/**
 * simula l'aggiunta si uno slave3 a run time
 */
static void avviaEsecuzioneSlave3(){
   //avvio l esecuzione dei logger degli slave
      Slave3 c = new Slave3();
      c.metodo();  
    
}





}//class

