/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PilotaLogClever.slave;
import java.io.File;
import org.apache.log4j.Logger;



public class LogClass3 {
    
    //attributi di classe
    
    org.apache.log4j.Logger log1 = Logger.getLogger("italia");
    
    
    
    
    
    
    
    /**
     * costruttore
     */
    public LogClass3() {
    }
    
    
   public void metodo(){
           
   //################################################################## 
   //gestione del file di log locale  
   //################################################################## 
   // String log4jConfigFile = System.getProperty("user.dir")
   //             + File.separator + "slave1.xml"; 
   // System.out.println(log4jConfigFile);
   // DOMConfigurator.configure(log4jConfigFile);
   //################################################################## 
      
      
      
     
      log1.trace("Trace Message! LogClass3");
      log1.debug("Debug Message! LogClass3");
      log1.info("Info Message! LogClass3");
      log1.warn("Warn Message! LogClass3");
      log1.error("Error Message! LogClass3");
      log1.fatal("Fatal Message! LogClass3");
   
      
     
     }//metodo
   
   
   
}//class


