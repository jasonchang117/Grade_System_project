package gradeSystem;

public class NoSuchIDExceptions extends Exception{
	public NoSuchIDExceptions(){
		super("Error: " + SystemMsg.errorIdMsg);
	}
	public void contactWith()
	{
		System.out.print(SystemMsg.errorIdMsg);
	}
}
