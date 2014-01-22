/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logclass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Riccardo Di Pietro
 */
public class Parser {
    
   
    
    /**
        * Stampa le info sui nodi, in modo ricorsivo
        * @param currentNode il nodo corrente
        * @param path_operativo file dove stampo le informazioni sui nodi
        */
       public void setNodeInfo(Node currentNode,String path_operativo) {
     
           //reindirizzo l'output stream 
           PrintStream original = System.out;
             //setto l'output stream su un file 
             try {
                    System.setOut(new PrintStream(new FileOutputStream(path_operativo,true)));
                } catch (FileNotFoundException ex) { }
           
           
           
            short sNodeType = currentNode.getNodeType();
             //Se è di tipo Element ricavo le informazioni e le stampo
             if (sNodeType == Node.ELEMENT_NODE) {
                    String sNodeName = currentNode.getNodeName();
                    String sNodeValue = searchTextInElement(currentNode);
                    NamedNodeMap nnmAttributes = currentNode.getAttributes();
                    
                    System.out.println("Elemento: " + sNodeName);
                    System.out.println("Attributi: " +
                                 printAttributes(nnmAttributes));
                    if (!sNodeValue.trim().equalsIgnoreCase("")) {
                           System.out.println("Contenuto: " + sNodeValue);
                    }
                    //System.out.print("\n");
             }
             int iChildNumber = currentNode.getChildNodes().getLength();
             //Se non si tratta di una foglia continua l'esplorazione 
             if (currentNode.hasChildNodes()) {
                    NodeList nlChilds = currentNode.getChildNodes();
                    for (int iChild = 0; iChild < iChildNumber; iChild++) {
                           setNodeInfo(nlChilds.item(iChild),path_operativo);
                    }
             }
       //ripristino l'output stream
       System.setOut(original);
       }
 
       /**
        * Search the content for a given Node
        * @param elementNode
        * @return 
        */
       private static String searchTextInElement(Node elementNode) {
             String sText = "";
             if (elementNode.hasChildNodes()) {
                    //Il child node di tipo testo è il primo
                    Node nTextChild = elementNode.getChildNodes().item(0);
                    sText = nTextChild.getNodeValue();
             }
             return sText;
       }
 
       
       /**
        * 
        * @param nnm
        * @return 
        */
       private static String printAttributes(NamedNodeMap nnm) {
             String sAttrList = new String();
             if (nnm != null && nnm.getLength() > 0) {
                    for (int iAttr=0; iAttr < nnm.getLength(); iAttr++) {
                           sAttrList += nnm.item(iAttr).getNodeName();
                           sAttrList += "=";
                           sAttrList += nnm.item(iAttr).getNodeValue();
                           sAttrList += "; ";
                    }
                    return sAttrList;
             }
             else {
                    return "assenti";
             }
       }
       
 }//class
