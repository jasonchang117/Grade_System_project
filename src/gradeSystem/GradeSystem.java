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
		sortGrades();
		this.listSize = this.gradeList.size();
	}
	
	public boolean containsID(String studentID)
	{
		for(int i=0;i<this.listSize;i++){
			if(this.gradeList.get(i).getStudentID().equals(studentID)){
				return true;
			}
		}
		return false;
	}
	
	public void showGrade(String studentID)
	{
		for(Grades grade : gradeList){
			if(grade.match(studentID)){
				grade.showGrade();
			}
		}
	}
	
	public void showRank(String studentID)
	{
		for(int i=0; i<listSize; i++){
			if(gradeList.get(i).match(studentID)){
				gradeList.get(i).showRank(i);
			}
		}
	}
	public void showAverage(String studentID)
	{
		int []sum = new int[5];
		sum = calculateAverage();
		System.out.println("lab1:        " + sum[0]);
		System.out.println("lab2:        " + sum[1]);
		System.out.println("lab3:        " + sum[2]);
		System.out.println("midTerm:     " + sum[3]);
		System.out.println("final:       " + sum[4]);
	}
	
	public void updateWeights(double [] newWeight)
	{
		for(int i=0;i<5;i++){
			this.weights[i] = newWeight[i];
		}
		for(Grades grade: gradeList){
			grade.calculateTotalGrade(newWeight);
		}
		sortGrades();
	}
	private void sortGrades(){
		Collections.sort(this.gradeList, new Comparator<Grades>(){
			@Override
			public int compare(Grades g1, Grades g2) {
				if(g1.getTotalGrade() < g2.getTotalGrade())
					return 1;
				else
					return -1;
			}
		});
	}
	private int[] calculateAverage(){
		int [] sum = new int[5];
		int [] scores = new int[5];
		for(Grades grade : gradeList){
			 scores = grade.getScores();
			 for(int i=0; i<5; i++){
				 sum[i] += scores[i];
			 }
		}
		for(int i=0; i<5; i++){
			sum[i] = (int)(Math.round((double)sum[i] / listSize));
		}
		return sum;
	}
}
