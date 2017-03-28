package gradeSystem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class GradeSystem {
	private double [] weights;
	private LinkedList<Grades> gradeList;
	
	GradeSystem() throws IOException{
		this.gradeList = new LinkedList<Grades>();
		this.weights = new double[] {0.1, 0.1, 0.1, 0.3, 0.4};  // lab_1, lab_2, lab_3, midterm_exam, final_exam
		Reader reader = new InputStreamReader(new FileInputStream("src/data/gradeinput.txt"), "utf-8");
		BufferedReader br = new BufferedReader(reader);
		
		while( br.ready() ){
			String [] input;
			input = br.readLine().split(" ");
			Grades grade = null;
			grade = new Grades(input[0], input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4]), Integer.parseInt(input[5]), Integer.parseInt(input[6]));
			grade.calculateTotalGrade(weights);
			gradeList.add(grade);
		}
	}
	
	public boolean containsID(String studentID)
	{
		if(this.gradeList.contains(studentID))
			return true;
		else
			return false;
	}
	
	public void showGrade(String studentID)
	{
		for(int i=0;;i++){
			if(this.gradeList.get(i).getStudentID().equals(studentID)){
				this.gradeList.get(i).getScores();		// return a integer score array
			}
		}
	}
	
	public void showRank(String studentID)
	{
		Collections.sort(this.gradeList, new Comparator<Grades>(){
			@Override
			public int compare(Grades g1, Grades g2) {
				if(g1.getTotalGrade() > g2.getTotalGrade())
					return 1;
				else
					return -1;
			}
		});
	}
	
	public void updateWeights(double [] newWeight)
	{
		for(int i=0;i<5;i++){
			this.weights[i] = newWeight[i];
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 * This main function is just for testing
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GradeSystem gradeSystem = new GradeSystem();
	}
}
