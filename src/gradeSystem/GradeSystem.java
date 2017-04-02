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
	/**
	 * @uml.property  name="weights" multiplicity="(0 -1)" dimension="1"
	 */
	private double [] weights;
	/**
	 * @uml.property  name="gradeList"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="gradeSystem.Grades"
	 */
	private LinkedList<Grades> gradeList;
	/**
	 * @uml.property  name="listSize"
	 */
	private int listSize;
	
	public GradeSystem() throws IOException{
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
		br.close();
		sortGrades();
		this.listSize = this.gradeList.size();
	}
	
	/* method containsID --------------------------------------------------------------------------------
	 * 
	 * This method returns the boolean value that whether the studentID is in the gradeList.
	 * 
	 * @ param		A string. A studentID to be check.
	 * @ return		A boolean value, true if we find the ID.
	 * 
	 * Pseudo code:
	 * 1. A for loop that go through the whole list and check the studentID.
	 * 2. If we find the target studentID, returns true. Returns false if we cannot find the same studentID.
	 *
	 * Time estimation O(n)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public boolean containsID(String studentID)
	{
		for(int i=0;i<this.listSize;i++){
			if(this.gradeList.get(i).getStudentID().equals(studentID)){
				return true;
			}
		}
		return false;
	}
	
	/* method showGrade ----------------------------------------------------------------------------------
	 * 
	 * This method simply calls the method grade.match() to check whether the studentID is matched, 
	 * and call grade.showGrade() to print all the grade of this studentID.
	 * 
	 * @ param		A string. A studentID to be check.
	 * 
	 * Pseudo code:
	 * 1. A for loop that go through the whole list and check the studentID.
	 * 2. Call grade.showGrade() to print the grade of the input studentID.
	 *
	 * Time estimation O(n)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void showGrade(String studentID)
	{
		for(Grades grade : gradeList){
			if(grade.match(studentID)){
				grade.showGrade();
			}
		}
	}
	
	
	/* method showRank ----------------------------------------------------------------------------------
	 * 
	 * This method shows the rank of the input studentID.
	 * 
	 * @ param		A string. A studentID to be check.
	 * 
	 * Pseudo code:
	 * 1. A for loop that go through the whole list and check the studentID.
	 * 2. We show the rank of input studentID.
	 * 3. Because the gradeList is already sorted according to the totalGrade, we simply use iterator i as rank.
	 *
	 * Time estimation O(n)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void showRank(String studentID)
	{
		for(int i=0; i<listSize; i++){
			if(gradeList.get(i).match(studentID)){
				gradeList.get(i).showRank(i);
			}
		}
	}
	
	/* method showAverage -------------------------------------------------------------------------------
	 * 
	 * This method shows the average score of each project.
	 * 
	 * Pseudo code:
	 * 1. We just simply print the result of average grades returned by calculateAverage().
	 * 
	 * Time estimation O(1)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void showAverage()
	{
		int []sum = new int[5];
		sum = calculateAverage();
		for(int i=0; i<5; i++){
			System.out.printf("%-11s: %d\r\n", SystemMsg.scoreType[i], sum[i]);
		}
	}
	
	/* method updateWeights ------------------------------------------------------------------------------
	 * 
	 * This method updates the weights of each project in this class.
	 * 
	 * @ param		an input double array, newWeight.
	 * 
	 * Pseudo code:
	 * 1. We first get the new value of weights and check the sum which is valid or not.
	 * 2. If the new weights are valid, we update the weights.
	 * 3. We re-calculate all the totalGrades in the list.
	 * 4. Call sortGrade() method to update the rank.
	 *
	 * Time estimation O(n)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public void updateWeights(double [] newWeight)
	{
		int check = 0;
		for(int i=0;i<5;i++)
			check += newWeight[i];
		if(check != 100){
			System.out.print(SystemMsg.weightError);
			System.out.println(check);
		}else{
			for(int i=0;i<5;i++){
				this.weights[i] = newWeight[i]/100;
			}		
			for(Grades grade: gradeList){
				grade.calculateTotalGrade(weights);
			}
			sortGrades();
		}
	}
	
	/* method sortGrades ---------------------------------------------------------------------------------
	 * 
	 * This method sorts the list according to the totalGrade in the list.
	 * 
	 * Pseudo code:
	 * 1. Use the build-in method to sort the gradeList.
	 * 2. Implement the compare function that our final list is sorted from higher score to lower score.
	 * 
	 * Time estimation O( n log(n) )   Note that built-in sorting method is modified merge-sort.
	 * 
	 ----------------------------------------------------------------------------------------------------*/
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
	
	/* method calculateAverage ---------------------------------------------------------------------------
	 * 
	 * This method calculates the average score of each project.
	 * 
	 * @ return		An integer array, the average scores of each project.
	 * 
	 * Pseudo code:
	 * 1. We first get the summation of each project.
	 * 2. Calculate the average score and round their value.
	 * 
	 * Time estimation O(n)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
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
	
	/* method updateWeights ------------------------------------------------------------------------------
	 * 
	 * This method updates the weights of each subject in this class.
	 * 
	 * @ param		A string. The input studentID that we want to show its name.
	 * 
	 * Pseudo code:
	 * 1. We first go through the whole list and find our terget studentID.
	 * 2. Call grade.getName() to print the user's name.
	 * 
	 * Time estimation O(n)
	 * 
	 ----------------------------------------------------------------------------------------------------*/
	public String searchName(String studentID){
		for(Grades grade : gradeList){
			if(grade.match(studentID))
				return grade.getName();
		}
		return null;
	}
}
