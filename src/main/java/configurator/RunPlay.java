package configurator;

import java.io.*;
import java.util.*;
import java.net.URL;

import static configurator.Helper.*;

public class RunPlay{
    

    public RunPlay() throws Exception{
        //Setup.readPlaySettings();
        
        ProcessBuilder pb = new ProcessBuilder( "play" , "run" );
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

    public static void main(String[] args) throws Exception{
        new RunPlay();
    }
    
}