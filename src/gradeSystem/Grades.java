package gradeSystem;

public class Grades {
	private int [] scores;
	private String studentID;
	private String name;
	private int totalGrade;
	
	Grades(String ID, String name, int lab_1, int lab_2, int lab_3, int midterm_exam, int final_exam)
	{
		this.scores = new int[] {lab_1, lab_2, lab_3, midterm_exam, final_exam};
		this.studentID = ID;
		this.name = name;
		this.totalGrade = 0;
	}
	
	/* method calculateTotalGrade ------------------------------------------------------------------------
	 * 
	 * This method can calculate the total grade according to defined weights.
	 * 
	 * @param ID     The input defined weights.
	 * 
	 * Pseudo code:
	 * 1. multiply the scores and their weights
	 * 2. rounding the value and store it in private integer totalGrade
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void calculateTotalGrade(double [] weights)
	{
		double tempScore = 0.0;
		for(int i=0;i<5;i++)
			tempScore += this.scores[i]*weights[i];
		
		if(tempScore*10%10 < 5)
			this.totalGrade = (int)tempScore;
		else
			this.totalGrade = (int)(tempScore*10 + (10 - tempScore*10%10))/10;
	}
	
	/* method getTotalGrade -----------------------------------------------------------------------------
	 * 
	 * This method returns the private integer of this class totalGrade.
	 * 
	 * @ return		a private integer, totalGrade
	 * 
	 * Pseudo code:
	 * 1. simply return totalGrade
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public double getTotalGrade()
	{
		return this.totalGrade;
	}
	
	/* method getStudentID ------------------------------------------------------------------------------
	 * 
	 * This method returns the private string of this class studentID.
	 * 
	 * @ return		a private string, studentID
	 * 
	 * Pseudo code:
	 * 1. simply return studentID
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public String getStudentID()
	{
		return this.studentID;
	}
	
	/* method getScores ---------------------------------------------------------------------------------
	 * 
	 * This method returns the private integer array of this class scores.
	 * 
	 * @ return		a private integer array, scores
	 * 
	 * Pseudo code:
	 * 1. simply return scores
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public int[] getScores()
	{
		return this.scores;
	}
	
	/* method getName -----------------------------------------------------------------------------------
	 * 
	 * This method returns the private string of this class name.
	 * 
	 * @ return		a private string, name
	 * 
	 * Pseudo code:
	 * 1. simply return name
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public String getName()
	{
		return this.name;
	}
	
	/* method match -------------------------------------------------------------------------------------
	 * 
	 * This method returns the boolean value of whether input studentID is matching the studentID of this class.
	 * 
	 * @ param		the input studentID to be confirmed
	 * @ return		a boolean value
	 * 
	 * Pseudo code:
	 * 1. simply return boolean value.  Return true if the input studentID is matching the studentID of this class.
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public boolean match(String studentID){
		if(studentID.equals(this.studentID)){
			return true;
		}else{
			return false;
		}
	}
	
	/* method showGrade ---------------------------------------------------------------------------------
	 * 
	 * This method show the grades of the student.
	 * 
	 * Pseudo code:
	 * 1. simply print all the grades and use an if statement to decide whether it should print "*".
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void showGrade(){
		System.out.println( name + "的分數: ");
		for(int i=0;i<5;i++){
			if(scores[i] < 60)
				System.out.printf("%-11s: %d*\r\n", SystemMsg.scoreType[i], scores[i]);
			else
				System.out.printf("%-11s: %d\r\n", SystemMsg.scoreType[i], scores[i]);
		}
		if(totalGrade < 60)
			System.out.printf("%-11s: %d\r\n*" , "total-grade", totalGrade);
		else
			System.out.printf("%-11s: %d\r\n" , "total-grade", totalGrade);
	}
	
	/* method showRank -----------------------------------------------------------------------------------
	 * 
	 * This method returns the private integer of this class totalGrade.
	 * 
	 * @ return		a private integer, totalGrade
	 * 
	 * Pseudo code:
	 * 1. simply return totalGrade
	 *
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void showRank(int rank){
		System.out.println(name + "的排名: " + rank);
	}
}
