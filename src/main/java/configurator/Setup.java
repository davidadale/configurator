package configurator;

import java.io.*;
import java.util.*;
import java.net.URL;
import static configurator.Helper.*;

public class Setup{
    
    public static Properties environment;
    public static Properties settings;
    
    protected static void readTomcatSettings() throws Exception{
        File settingsFile = new File( new File("."), "app.config");
        
        if( !settingsFile.exists() ){
            StringBuilder msg = new StringBuilder();
            msg.append("`````````````````````````````````````````````````````````````````````````\n");
            msg.append("' configurator.properties                                               `\n");
            msg.append("`                                                                       `\n");
            msg.append("`                                                                       `\n");            
            msg.append("` WARNING! Missing configuration settings! Create a file in this        `\n");
            msg.append("' location with the name 'configurator.settings'.                       `\n");
            msg.append("`````````````````````````````````````````````````````````````````````````\n");
            println( msg.toString() );
            
            System.exit( 0 );
        }
        
        settings = new Properties();
        settings.load( new FileInputStream( settingsFile ) );
        
        String server = settings.getProperty("server");
        String version = settings.getProperty("version");
            //String tomcatExe = settings.getProperty("pathToTomcat");    
        
        if( server==null || version == null ){
            throw new Exception("Missing properties in the configurator.properties file.");
        }
        
        readEnvironment(server,version);        
    }

    public static void readSettings()throws Exception{
        File settingsFile = new File( new File("."), "app.config");
        environment = new Properties();
        environment.load( new FileInputStream(settingsFile) );        
    }
    
    
    protected static void readPlaySettings() throws Exception{

        File settingsFile = new File( new File("."), "app.config");
        
        if( !settingsFile.exists() ){
            StringBuilder msg = new StringBuilder();
            msg.append("`````````````````````````````````````````````````````````````````````````\n");
            msg.append("' configurator.properties                                               `\n");
            msg.append("`                                                                       `\n");
            msg.append("`                                                                       `\n");            
            msg.append("` WARNING! Missing configuration settings! Create a file in this        `\n");
            msg.append("' location with the name 'configurator.properties'.                      `\n");
            msg.append("`````````````````````````````````````````````````````````````````````````\n");
            println( msg.toString() );
            
            System.exit( 0 );
        }
        
        environment = new Properties();
        environment.load( new FileInputStream(settingsFile) );
        
        //settings = new Properties();
        //settings.load( new FileInputStream( settingsFile ) );
        
        //String server = settings.getProperty("server");
        //String version = settings.getProperty("version");
        //String playExe = settings.getProperty("pathToPlay");    
        
        //if( server==null || version == null ){
          ///  throw new Exception("Missing properties in the configurator.properties file.");
        //}
        
        //readEnvironment(server, version);
            
    }
    
    protected static void readEnvironment( String server, String version ) throws Exception{
        environment = new Properties();        
        InputStream response = new URL( url( server, version ) ).openStream();
        environment.load( response );            
    }
    
    
}