package configurator;

import java.io.*;
import java.util.*;
import java.net.URL;
import static configurator.Helper.*;

public class GenericRunner{
	
	ProcessBuilder pb;
	
	public GenericRunner(String cmd) throws Exception{
		
		String[] parts = cmd.split(" ");
        pb = new ProcessBuilder( Arrays.asList( parts ) );
		pb.redirectErrorStream( true );

        Set<String>     props = Setup.environment.stringPropertyNames();
        for( String prop: props ){
            pb.environment().put(prop, Setup.environment.getProperty( prop ));
        }
    }
	public void start() throws Exception{
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