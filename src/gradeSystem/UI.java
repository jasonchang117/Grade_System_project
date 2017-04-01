package gradeSystem;

import java.util.Scanner;

public class UI {
	private GradeSystem aGradeSystem;
	private String userID; 
	private Scanner scanner;
	private String [] scoreType = new String[] {"lab_1", "lab_2", "lab_3", "mid-term", "final_exam"};
	
	public UI() throws Exception
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
			System.out.println(SystemMsg.welcomeMsg + aGradeSystem.searchName(studentID));
			userID = studentID;
			promptCommand();
		}else{
			System.out.print(SystemMsg.errorIdMsg);
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
		System.out.print(SystemMsg.promptCommandMsg);
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
				return;
			default:
				System.out.print(SystemMsg.commandError);
				promptCommand();
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
		System.out.print(SystemMsg.promptIdMsg);
		String option = scanner.next();
		
		if( option.equals("Q") )
		{
			System.out.print(SystemMsg.finishMsg);
		}
		else
		{
			checkID(option);
		}
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
		System.out.print(SystemMsg.enterNewWeightMsg);
		for(int i=0; i<5; i++){
			System.out.println(scoreType[i] + "(%): ");
			double weight = scanner.nextDouble();
			weights[i] = (int) (weight + 0.5);
		}
		System.out.print(SystemMsg.confirmNewWeightHintMsg);
		for(int i=0;i<5;i++)
			System.out.println(scoreType[i] + "(%): " + weights[i]);
		return confirmWeights(weights);
	}
	
	private double[] confirmWeights(double[] weights){
		System.out.print(SystemMsg.confirmNewWeightMsg);
		String option = scanner.next();
		switch(option){
		case "Y":
			return weights;
		case "N":
			getWeight();
			break;
		default:
			System.out.print(SystemMsg.commandError);
			break;
		}
		return weights;
	}
}
