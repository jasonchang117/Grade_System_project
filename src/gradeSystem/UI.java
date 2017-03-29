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
	
	public void showCommandOptionsMsg(){
		System.out.println("Please choose the command:\n"
				+ "1) G -> show grade\n"
				+ "2) R -> show rank\n"
				+ "3) A -> show average\n"
				+ "4) W -> update weights\n"
				+ "5) E -> exit");
	}
	
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
	
	public void showFinishMsg()
	{
		System.out.println("結束了");
		System.exit(0);
	}
	
	public void showWelcomeMsg()
	{
		System.out.print("Hello! ");
	}
	
	public void showErrorMsg()
	{
		System.out.println("指令錯了!");
		promptCommand();
	}
	
	public void showErrorIDMsg()
	{
		System.out.println("ID錯了!");
	}
}
