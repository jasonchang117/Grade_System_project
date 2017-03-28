package gradeSystem;

import java.io.IOException;
import java.util.Scanner;

public class UI {
	private GradeSystem aGradeSystem;
	private String userID; 
	private Scanner scanner;
	UI() throws IOException
	{
		aGradeSystem = new GradeSystem();
		userID = new String();
		scanner = new Scanner(System.in);
	}
	
	public void checkID(String studentID)
	{
		//debug code
		//System.out.println(studentID);
		if(aGradeSystem.containsID(studentID))
		{
			showWelcomeMsg();
			userID = studentID;
			promptCommand();
		}else{
			showErrorMsg();
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
				promptID();
				break;
			default:
				showErrorMsg();
		}
	}
	
	public void promptID()
	{
		System.out.println("Please enter your student ID or enter E to exit.");
		String option = scanner.next();
		if(option == "E"){
			showFinishMsg();
		}else{
			checkID(option);
		}
	}
	public void showCommandOptionsMsg(){
		System.out.println("Please choose the command:"
				+ "1) G -> show grade"
				+ "2) R -> show rank"
				+ "3) A -> show average"
				+ "4) W -> update wights"
				+ "5) E -> exit");
	}
	public double[] getWeight(){
		double [] weights = new double[5];
		for(int i=0; i<5; i++){
			int weight = scanner.nextInt();
			weights[i] = Math.floor((double)weight / 100);
		}
		return weights;
	}
	public void showFinishMsg()
	{
		System.out.println("End");
	}
	public void showWelcomeMsg()
	{
		System.out.println("Hello!");
	}
	public void showErrorMsg()
	{
		System.out.println("Something wrong!");
	}
}
