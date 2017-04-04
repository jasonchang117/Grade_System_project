package gradeSystem;

public class NoSuchCommandExceptions extends Exception{
	
	public NoSuchCommandExceptions(){
		super("Error: " + SystemMsg.commandError);
	}
	public void contactWith()
	{
		System.out.print(SystemMsg.commandError);
	}
}
