

package org.clever.Common.Logging;

import java.util.logging.Level;
import org.clever.Common.Communicator.Agent;
import org.clever.Common.Exceptions.CleverException;
import org.clever.HostManager.Info.InfoAgent;

/**
 *
 * @author riccardo
 */
public class LoggingAgent extends Agent {

    
    private LoggingAgentPlugin loggingPlugin;
    
//costruttore    
public LoggingAgent() throws CleverException 
  {     
      super();
   }
    
    
  //INIZIO 4 metodi astratti autocreati
    
    @Override
    public void initialization() throws Exception {
        logger.info("\n\nLoggingAgent Started!\n\n");
        if(super.getAgentName().equals("NoName"))
            {
             super.setAgentName("LoggingAgent");
            }
        
        try 
      {
          super.start();
      }
      catch (CleverException ex) 
      {
          logger.error("Error in start procedure of  LoggingAgent. Message:"+ex.getMessage());
      }
        
      try 
        {
            logger.info( "LoggingPlugin start creation" );
            loggingPlugin = (LoggingAgentPlugin) super.startPlugin("./cfg/configuration_logging.xml","/org/clever/Common/Logging/configuration_logging.xml");        
            loggingPlugin.setOwner(this);
            logger.info("LoggingPlugin created ");
            
        } catch (Exception ex) {
            logger.error("LoggingPlugin creation failed: " + ex.getMessage());
        }
     
        
        
        
    }

    @Override
    public Class getPluginClass() {
        return this.cl;
    }

    @Override
    public Object getPlugin() {
        return this.pluginInstantiation;
    }

    @Override
    public void shutDown() {
        //vuoto    
    }
    
    //FINE 4 metodi astratti
    

    
    
}
