package configurator;

public class Main{

	public static void main(String[] args)throws Exception{
		Setup.readSettings();
		String command = Setup.environment.getProperty("command");
		GenericRunner runner = new GenericRunner( command );
		runner.start();
	}

}