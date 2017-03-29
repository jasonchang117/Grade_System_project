package gradeSystem;

public class Grades {
	private int [] scores;
	private String[] scoreType = new String[] {"lab_1   ", "lab_2   ", "lab_3   ", "midTerm ", "final   "};
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
	public String getName()
	{
		return this.name;
	}
	public boolean match(String studentID){
		if(studentID.equals(this.studentID)){
			return true;
		}else{
			return false;
		}
	}
	public void showGrade(){
		System.out.println("Scores of " + name + ": ");
		for(int i=0;i<5;i++){
			if(scores[i] < 60)
				System.out.println(scoreType[i] + ": " + scores[i] + "*");
			else
				System.out.println(scoreType[i] + ": " + scores[i]);
		}
		if(totalGrade < 60)
			System.out.println("total grade: " + totalGrade + "*");
		else
			System.out.println("total grade: " + totalGrade);
	}
	public void showRank(int rank){
		System.out.println("Rank of " + name + ": " + rank);
	}
}
