package gradeSystem;

public class NoSuchIDExceptions extends Exception{
	public NoSuchIDExceptions(){
		super("Error: " + SystemMsg.errorIdMsg);
	}
	
	/* method contactWith -------------------------------------------------------------------------------
	 * 
	 * This method prints the errorID message.
	 * 
	 * Pseudo code:
	 * 1. We simply print errorID massage
	 * 
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void contactWith()
	{
		System.out.print(SystemMsg.errorIdMsg);
	}
}
