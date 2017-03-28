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
	
	public double getTotalGrade()
	{
		return this.totalGrade;
	}
	
	public String getStudentID()
	{
		return this.studentID;
	}
	
	public int[] getScores()
	{
		return this.scores;
	}
}
