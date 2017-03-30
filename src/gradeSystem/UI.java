package gradeSystem;

import java.util.Scanner;

public class UI {
	private GradeSystem aGradeSystem;
	private String userID; 
	private Scanner scanner;
	private String [] scoreType = new String[] {"lab_1", "lab_2", "lab_3", "mid-term", "final_exam"};
	
	UI() throws Exception
	{
		aGradeSystem = new GradeSystem();
		userID = new String();
		scanner = new Scanner(System.in);
	}
	
	/* method checkID -----------------------------------------------------------------------------------
	 * 
	 * This method check whether the input studentID is in the gradeList.
	 * 
	 * @ param		A string. The studentID that we need to check.
	 * 
	 * Pseudo code:
	 * 1. If the studentID is in the system, we show the welcome message and the valid commands.
	 * 2. If we cannot find the studentID in the system, we refuse the user to access the system.
	 * 
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void checkID(String studentID)
	{
		if(aGradeSystem.containsID(studentID))
		{
			showWelcomeMsg();
			aGradeSystem.showName(studentID);
			userID = studentID;
			promptCommand();
		}else{
			showErrorIDMsg();
		}
	}
	
	/* method promptCommand -----------------------------------------------------------------------------
	 * 
	 * This method shows the valid command and implements the commands according to the input by users.
	 * 
	 * Pseudo code:
	 * 1. Call showCommandOptionMsg() to show the valid commands.
	 * 2. Use switch case to implement each command cases.
	 * 3. Input "G" --> call aGradeSystem.showGrade() to show the user's grades.
	 * 4. Input "R" --> call aGradeSystem.showRank() to show the user's rank in the class.
	 * 5. Input "A" --> call aGradeSystem.showAverage() to show the average grades of each project.
	 * 6. Input "W" --> call aGradeSystem.updateWeights() to set the new weights.
	 * 7. Input "E" --> clear the current studentID and return to the beginning interface.
	 * 8. Invalid commands, show the error message.
	 * 
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void promptCommand()
	{
		showCommandOptionsMsg();
		String command = scanner.next();
		switch(command){
			case "G":
				aGradeSystem.showGrade(userID);
				break;
			case "R":
				aGradeSystem.showRank(userID);
				break;
			case "A":
				aGradeSystem.showAverage(userID);
				break;
			case "W":
				aGradeSystem.updateWeights(getWeight());
				break;
			case "E":
				this.userID = "";
				promptID();
				break;
			default:
				showErrorMsg();
				return;
		}
		promptCommand();
	}
	
	/* method promptID ----------------------------------------------------------------------------------
	 * 
	 * This method shows the beginning interface and check whether the input command is valid.
	 * 
	 * Pseudo code:
	 * 1. Show the beginning interface to the users.
	 * 2. Input "Q" --> exit the system and call showFinishMsg() to show the finish message.
	 * 3. Input the other commands, only the valid studentID can login the system.
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void promptID()
	{
		System.out.println("Please enter your student ID or enter Q to exit.");
		String option = scanner.next();
		if( option.equals("Q") )
		{
			showFinishMsg();
		}
		else
		{
			checkID(option);
		}
	}
	
	/* method showCommandOptionMsg ----------------------------------------------------------------------
	 * 
	 * This method simply show the valid command examples.
	 * 
	 * Pseudo code:
	 * 1. Print the valid command examples.
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void showCommandOptionsMsg(){
		System.out.println("Please choose the command:\n"
				+ "1) G -> show grade\n"
				+ "2) R -> show rank\n"
				+ "3) A -> show average\n"
				+ "4) W -> update weights\n"
				+ "5) E -> exit");
	}
	
	/* method getWeight ---------------------------------------------------------------------------------
	 * 
	 * This method get the new weights set by the users and return to gradeSystem.
	 * 
	 * @ return		A double array, newWeight.
	 * 
	 * Pseudo code:
	 * 1. First we get the new weights input by the user.
	 * 2. Ask the user again to confirm the input value.
	 * 3. Input "Y" --> return the new weights to the gradeSystem
	 * 4. Input "N" --> input the right value instead of the wrong value.
	 * 5. Input invalid command will show the error message.
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public double[] getWeight(){
		double [] weights = new double[5];
		for(int i=0; i<5; i++){
			System.out.print(scoreType[i] + ": ");
			double weight = scanner.nextDouble();
			weights[i] = (int) (weight + 0.5);
		}
		System.out.println("\n請確認新配分");
		for(int i=0;i<5;i++)
			System.out.println(scoreType[i] + " " + weights[i]);
		System.out.println("以上正確嗎? Y(yes) 或   N(No)");
		
		String option = scanner.next();
		switch(option){
		case "Y":
			return weights;
		case "N":
			getWeight();
			break;
		default:
			showErrorMsg();
			break;
		}
		return weights;
	}
	
	/* method showFinishMsg ------------------------------------------------------------------------------
	 * 
	 * This method show the finish interface.
	 * 
	 * Pseudo code:
	 * 1. Simply show the finishing message.
	 * 2. Close the program.
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void showFinishMsg()
	{
		System.out.println("結束了");
		System.exit(0);
	}
	

	/* method showWelcomeMsg-----------------------------------------------------------------------------
	 * 
	 * This method show the start interface.
	 * 
	 * Pseudo code:
	 * 1. Simply show the start message.
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void showWelcomeMsg()
	{
		System.out.print("Hello! ");
	}
	

	/* method showErrorMsg ------------------------------------------------------------------------------
	 * 
	 * This method show the error message.
	 * 
	 * Pseudo code:
	 * 1. Simply show the error message.
	 * 2. Call promptCommand(), let the user input again.
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void showErrorMsg()
	{
		System.out.println("指令錯了!");
		promptCommand();
	}
	

	/* method showErrorIDMsg ----------------------------------------------------------------------------
	 * 
	 * This method show the error message when the user input an invalid studentID.
	 * 
	 * Pseudo code:
	 * 1. Simply show the error message of input a invalid studentID.
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void showErrorIDMsg()
	{
		System.out.println("ID錯了!");
	}
}
