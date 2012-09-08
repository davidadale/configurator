package configurator;

public class Helper{
    public static void println(String msg){
        System.out.println(msg);
    }
    
    public static String url( String server, String version ){
        if( !server.endsWith("/") ){
            server = server + "/";
        }
        return server + version;
    }    
}