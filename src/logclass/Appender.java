/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logclass;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/**
 * Questo codice è in grado di gestire le informazioni di un singolo frammento 
 *  appender ricavato da un file di log di log4j.
 * @author Riccardo Di Pietro
 */

/*
Esempio di frammento XML di riferimento

<appender name="FILE" class="org.apache.log4j.FileAppender">
   
   <param name="file" value="/home/riccardo/Desktop/SOLO_INFO.txt"/>
   
   <layout class="org.apache.log4j.PatternLayout" >
           <param name="ConversionPattern" value="%5p [%t] (%F:%L) - %m%n"/>     
   </layout>
   
   <filter class="org.apache.log4j.varia.LevelMatchFilter">
      <param name="LevelToMatch" value="INFO" />
      <param name="AcceptOnMatch" value="true" />
   </filter>

    <filter class="org.apache.log4j.varia.DenyAllFilter" /> 

</appender>

*/


//########################################
//SEGUONO un elenco di classi di supporto#
//########################################



/**
 *
 * @author Riccardo Di Pietro
 */
public class Appender {

//attributi della classe    
private String path; //path del frammento di file di log


//<appender name="FILE" class="org.apache.log4j.FileAppender">
String name;//name="FILE"
String Class;//class="org.apache.log4j.FileAppender"

//<param name="file" value="/home/riccardo/Desktop/SOLO_INFO.txt"/>
Param param;// name e value


//<layout class="org.apache.log4j.PatternLayout" >
//  <param name="ConversionPattern" value="%5p [%t] (%F:%L) - %m%n"/>     
//</layout>
Layout layout;

//<filter class="org.apache.log4j.varia.LevelMatchFilter">
//  <param name="LevelToMatch" value="INFO" />
//  <param name="AcceptOnMatch" value="true" />
//</filter>
//<filter class="org.apache.log4j.varia.DenyAllFilter" /> 
Filter[] filter;



/**
 * Costruttore
 * @param path
 * @param name
 * @param Class
 * @param param
 * @param layout
 * @param filter 
 */
public Appender(String path, String name, String Class, Param param, Layout layout, Filter[] filter) {
        this.path = path;
        this.name = name;
        this.Class = Class;
        this.param = param;
        this.layout = layout;
        this.filter = filter;
    }

/**
 * Costruttore di default
 *
 */
public Appender() {
        this.path = "";
        this.name = "";
        this.Class = "";
        this.param = null;
        this.layout = null;
        this.filter = null;
    }

/**
 * Costruttore che inizializza il file da cui ricavare le informazioni sull'appender
 */
public Appender(String path) {
     this.path = path;
     }


//metodi getter e setter
public String getPath() {
        return path;
    }

public void setPath(String path) {
        this.path = path;
    }

public Param getParam() {
        return param;
    }

public void setParam(Param param) {
        this.param = param;
    }

public Layout getLayout() {
        return layout;
    }

public void setLayout(Layout layout) {
        this.layout = layout;
    }

public Filter[] getFilter() {
        return filter;
    }

public void setFilter(Filter[] filter) {
        this.filter = filter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCLass() {
        return Class;
    }

    public void setCLass(String Class) {
        this.Class = Class;
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
                     Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
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

  





}//appender

class Param{

    //attributi interni della classe
    
    private String name;
    private String value;

    
    /**
     * Costruttore
     * @param name
     * @param value 
     */
    public Param(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Costruttore di default
     */
    public Param() {
        this.name = "";
        this.value = "";
    }

    //metodi getter e setter
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}//Param    
    
class Layout{

    //attributi interni della classe
    
    //<layout class="org.apache.log4j.PatternLayout" >
    private String layout;//class
    
    //<param name="ConversionPattern" value="%5p [%t] (%F:%L) - %m%n"/> 
    private Param param;//name e value al suo interno

    
    /**
     * Costruttore
     * @param layout
     * @param param 
     */
    public Layout(String layout, Param param) {
        this.layout = layout;
        this.param = param;
    }

    /**
     * Costruttore di default
     */
    public Layout() {
        this.layout = "";
        this.param = null;
    }


    //metodi setter e getter
    
    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Param getParam() {
        return param;
    }

    public void setParam(Param param) {
        this.param = param;
    }
        
}//Layout    
    


class Filter{

    //attributi interni della classe

    //<filter class="org.apache.log4j.varia.LevelMatchFilter"> 
    private String filter;//class
    
    //<param name="LevelToMatch" value="INFO" />
    //<param name="AcceptOnMatch" value="true" />
    private Param[] param;

    
    /**
     * Costruttore
     * @param filter
     * @param param 
     */
    public Filter(String filter, Param[] param) {
        this.filter = filter;
        this.param = param;
    }

    /**
     * Costruttore di default
     */
    public Filter() {
        this.filter = "";
        this.param = null;
    }

    //metodi setter e getter
    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Param[] getParam() {
        return param;
    }

    public void setParam(Param[] param) {
        this.param = param;
    }
    
 
}//Filter    
    
 