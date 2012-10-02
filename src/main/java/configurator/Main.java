package configurator;

public class Main{

	public static void main(String[] args)throws Exception{
		Setup.readSettings();
		String runtime = Setup.environment.getProperty("runtime");
		if("play".equals( runtime ) ){
			new RunPlay();
		}
	}

}