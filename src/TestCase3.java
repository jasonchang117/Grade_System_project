import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.Grades;
import gradeSystem.SystemMsg;
import gradeSystem.UI;
/*
 * 用來測Grades
 */
public class TestCase3 {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void before() {
    	System.setOut(new PrintStream(outContent));
    }
    @Test
    public void grades_showRank_1() throws Exception{
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	grade.showRank(14);
    	assertEquals("許文馨的排名: 14\r\n", outContent.toString());
    }
    @Test
    public void grades_showRank_2() throws Exception{
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	grade.showRank(15);
    	assertEquals("許文馨的排名: 15\r\n", outContent.toString());
    }
    @Test
    public void grades_showGrade_1() throws Exception{
    	double[] weights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2};
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	grade.calculateTotalGrade(weights);
    	grade.showGrade();
    	assertEquals("許文馨的分數: \r\n"+ 
        		"lab_1      : 88\r\n"+
        		"lab_2      : 92\r\n"+
        		"lab_3      : 88\r\n"+
        		"mid-term   : 98\r\n"+
        		"final-exam : 91\r\n"+
        		"total-grade: 91\r\n", outContent.toString());
    }
    @Test
    public void grades_showGrade_2() throws Exception{
    	double[] weights = new double[]{0.1, 0.1, 0.1, 0.3, 0.4};
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	grade.calculateTotalGrade(weights);
    	grade.showGrade();
    	assertEquals("許文馨的分數: \r\n"+ 
        		"lab_1      : 88\r\n"+
        		"lab_2      : 92\r\n"+
        		"lab_3      : 88\r\n"+
        		"mid-term   : 98\r\n"+
        		"final-exam : 91\r\n"+
        		"total-grade: 93\r\n", outContent.toString());
    }
    @Test
    public void grades_match_1() throws Exception{
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	assertTrue(grade.match("955002056"));
    }
    @Test
    public void grades_match_2() throws Exception{
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	assertFalse(grade.match("985002009"));
    }
    @Test
    public void grades_getName_1() throws Exception{
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	assertEquals("許文馨", grade.getName());
    }
    @Test
    public void grades_getName_2() throws Exception{
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	assertNotEquals("呂哲光", grade.getName());
    }
    @Test
    public void grades_getScores_1() throws Exception{
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	int[]scores = grade.getScores();
    	assertEquals(scores[0], 88);
    	assertEquals(scores[1], 92);
    	assertEquals(scores[2], 88);
    	assertEquals(scores[3], 98);
    	assertEquals(scores[4], 91);
    }
    @Test
    public void grades_getScores_2() throws Exception{
    	Grades grade = new Grades("985002009", "呂哲光",81, 83, 86, 82, 90);
    	int[]scores = grade.getScores();
    	assertEquals(scores[0], 81);
    	assertEquals(scores[1], 83);
    	assertEquals(scores[2], 86);
    	assertEquals(scores[3], 82);
    	assertEquals(scores[4], 90);
    }
    @Test
    public void grades_getStudentID_1() throws Exception{
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	assertEquals(grade.getStudentID(), "955002056");
    }
    @Test
    public void grades_getStudentID_2() throws Exception{
    	Grades grade = new Grades("985002009", "呂哲光",81, 83, 86, 82, 90);
    	assertEquals(grade.getStudentID(), "985002009");
    }
    /*
     * 同時測getTotalGrade以及calculateTotalGrade
     */
    @Test
    public void grades_getTotalGrade_1() throws Exception{
    	double[] weights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2};
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	grade.calculateTotalGrade(weights);
    	assertEquals(91, grade.getTotalGrade());
    }
    @Test
    public void grades_getTotalGrade_2() throws Exception{
    	double[] weights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2};
    	Grades grade = new Grades("985002009", "呂哲光",81, 83, 86, 82, 90);
    	grade.calculateTotalGrade(weights);
    	assertEquals(84, grade.getTotalGrade());
    }
    @After
    public void after(){
		System.setIn(System.in);
		System.setOut(System.out);
    }
}
