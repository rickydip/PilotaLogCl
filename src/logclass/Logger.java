/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logclass;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



/**
 * Questo codice è in grado di gestire le informazioni di un singolo frammento 
 *  logger ricavato da un file di log di log4j.
 * @author Riccardo Di Pietro
 */

/*
Esempio di frammento XML di riferimento

<logger name="log" additivity="false">
  <level value="debug" />
  <appender-ref ref="FILE" />
  <appender-ref ref="FILE2" />
  <appender-ref ref="FILE3" />
 </logger>

*/


//########################################
//SEGUONO un elenco di classi di supporto#
//########################################


public class Logger {
    
//attributi della classe    
private String path; //path del frammento di file di log

private String name;
private String additivity;

private String level_value;

private String[] app_ref;



/**
 * Costruttore
 * @param path
 * @param name
 * @param additivity
 * @param level_value
 * @param app_ref 
 */
public Logger(String path, String name, String additivity, String level_value, String[] app_ref) {
     this.path = path;
     this.name = name;
     this.additivity = additivity;
     this.level_value = level_value;
     this.app_ref = app_ref;
    }

/**
 * Costruttore di default
 */
public Logger(){
     this.path = "";
     this.name = "";
     this.additivity = "";
     this.level_value = "";
     this.app_ref = null;
    }


public Logger(String path){
    this.path = path;
    }

// Metodi getter e setter
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdditivity() {
        return additivity;
    }

    public void setAdditivity(String additivity) {
        this.additivity = additivity;
    }

    public String getLevel_value() {
        return level_value;
    }

    public void setLevel_value(String level_value) {
        this.level_value = level_value;
    }

    public String[] getApp_ref() {
        return app_ref;
    }

    public void setApp_ref(String[] app_ref) {
        this.app_ref = app_ref;
    }


    
    
/**
 * 
 * @param path_frammento file frammento di tipo appender
 * @param path_operativo dove salva il file
 */
public void frammentoToFile(String path_frammento,String path_operativo) {
     
             Parser ddp = new Parser();
             DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
 
             try {
                    DocumentBuilder builder = null;
                 try {
                     builder = dbf.newDocumentBuilder();
                 } catch (ParserConfigurationException ex) {
                     java.util.logging.Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
                 }
                    File xmlFile = new File(path_frammento);
                    org.w3c.dom.Document document = builder.parse(xmlFile);
                    //#########################
                    ddp.setNodeInfo(document,path_operativo);
                    //#########################
             } catch (SAXException sxe) {
                    Exception  x = sxe;
                    if (sxe.getException() != null)
                           x = sxe.getException();
                    x.printStackTrace();
             } catch (IOException ioe) {
                    ioe.printStackTrace();
             }
          
       
 
}//frammentoToFile 




/**
 * dato un file restiuisce un oggetto
 * @param path_file 
 */
/*
public void caricaFiletoObject(String path_file){
           //creo un oggetto Logger di comodo
           Logger com =new Logger();

           
           

} 
  */  
    
    
    
    
    
    
    
    
    
    
    
    
    
  
}//Logger
