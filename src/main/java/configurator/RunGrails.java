package configurator;

import static configurator.Helper.*;
import java.util.*;
import java.io.*;
import static configurator.Helper.*;

public class RunGrails{
    
    public static void main(String[] args ) throws Exception{
        
        Setup.readTomcatSettings();
        
        StringBuilder params = new StringBuilder();
        for( String param: args ){
            params.append( param );
        }
        println( params.toString() );
        
        List<String> commands = new LinkedList<String>();
        commands.add( "grails" );
        commands.addAll( Arrays.asList( args ) );
        commands.add( "run-app" );

        
        ProcessBuilder pb = new ProcessBuilder( commands );
        pb.redirectErrorStream( true );

        Set<String>     props = Setup.environment.stringPropertyNames();
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