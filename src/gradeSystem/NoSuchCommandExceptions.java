package gradeSystem;

public class NoSuchCommandExceptions extends Exception{
	
	
	public NoSuchCommandExceptions(){
		super("Error: " + SystemMsg.commandError);
	}
	
	/* method contactWith -------------------------------------------------------------------------------
	 * 
	 * This method prints the command error message.
	 * 
	 * Pseudo code:
	 * 1. We simply print command error massage
	 * 
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void contactWith()
	{
		System.out.print(SystemMsg.commandError);
	}
}
