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
	private int listSize;
	
	GradeSystem() throws IOException{
		this.gradeList = new LinkedList<Grades>();
		this.weights = new double[] {0.1, 0.1, 0.1, 0.3, 0.4};  // lab_1, lab_2, lab_3, midterm_exam, final_exam
		Reader reader = new InputStreamReader(new FileInputStream("src/data/gradeinput.txt"), "utf-8");
		BufferedReader br = new BufferedReader(reader);
		
		String first_line;
		first_line = br.readLine().replace("\uFEFF", "");
		String [] first_input = first_line.split(" ");
		Grades first_grade = new Grades(first_input[0], first_input[1], Integer.parseInt(first_input[2]), Integer.parseInt(first_input[3]), Integer.parseInt(first_input[4]), Integer.parseInt(first_input[5]), Integer.parseInt(first_input[6]));
		first_grade.calculateTotalGrade(weights);
		this.gradeList.add(first_grade);
		
		while( br.ready() ){
			String [] input = null;
			input = br.readLine().split(" ");
			Grades grade = new Grades(input[0], input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4]), Integer.parseInt(input[5]), Integer.parseInt(input[6]));
			grade.calculateTotalGrade(weights);
			gradeList.add(grade);
		}
		this.listSize = this.gradeList.size();
	}
	
	public boolean containsID(String studentID)
	{
		for(int i=0;i<this.listSize;i++){
			System.out.println(this.gradeList.get(i).getStudentID());
			if(this.gradeList.get(i).getStudentID().equals(studentID)){
				return true;
			}
		}
		return false;
	}
	
	public void showGrade(String studentID)
	{
		for(int i=0;i<this.listSize;i++){
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
	public void showAverage(String studentID)
	{
		int size = this.gradeList.size();
		for(int i=0;i<size;i++){
			if(this.gradeList.get(i).getStudentID().equals(studentID)){
				this.gradeList.get(i).getTotalGrade();		// return a integer score array
			}
		}
	}
	
	public void updateWeights(double [] newWeight)
	{
		for(int i=0;i<5;i++){
			this.weights[i] = newWeight[i];
		}
	}
	
}
