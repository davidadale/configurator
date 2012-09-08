package configurator;

import java.io.*;
import java.util.*;
import java.net.URL;

import static configurator.Helper.*;

public class RunTomcat{
    
    public static void main(String[] args) throws Exception{
        
        Setup.readTomcatSettings();

        ProcessBuilder pb = new ProcessBuilder( "./startup.sh");
        pb.redirectErrorStream( true );
        //pb.environment().put("CATALINA_OPTS", opts.toString() );

        /*
        StringBuilder opts = new StringBuilder();
        
        Set<String> props = Setup.environment.stringPropertyNames();
        for( String prop: props ){
            opts.append( " -D"+prop+"="+  Setup.environment.getProperty( prop ) );
        }
        
        
        */

        Set<String> props = Setup.environment.stringPropertyNames();
        for( String prop: props ){
            pb.environment().put(prop, Setup.environment.getProperty( prop ));            
        }

        Process p = pb.start();
        
        String line = null;
        BufferedReader bri = new BufferedReader
                (new InputStreamReader(p.getInputStream()));        
        
        while( (line = bri.readLine()) != null ){
            println( line );
        }
        bri.close();        
                
        
    }
    
}