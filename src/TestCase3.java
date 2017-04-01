import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.Grades;
import gradeSystem.SystemMsg;
import gradeSystem.UI;

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
    	Grades grade = new Grades("955002056","許文馨",88, 92, 88, 98, 91);
    	grade.showGrade();
    	grade.calculateTotalGrade(new double[]{20, 20, 20, 20, 20});
    	assertEquals("許文馨的分數: \r\n"+ 
        		"lab_1      : 88\r\n"+
        		"lab_2      : 92\r\n"+
        		"lab_3      : 88\r\n"+
        		"mid-term   : 98\r\n"+
        		"final-exam : 91\r\n"+
        		"total-grade: 86\r\n", outContent.toString());
    }
    @Test
    public void grades_showGrade_2() throws Exception{
    	
    }
    @Test
    public void grades_match_1() throws Exception{
    	
    }
    @Test
    public void grades_match_2() throws Exception{
    	
    }
    @Test
    public void grades_getName_1() throws Exception{
    	
    }
    @Test
    public void grades_getName_2() throws Exception{
    	
    }
    @Test
    public void grades_getScores_1() throws Exception{
    	
    }
    @Test
    public void grades_getScores_2() throws Exception{
    	
    }
    @Test
    public void grades_getStudentID_1() throws Exception{
    	
    }
    @Test
    public void grades_getStudentID_2() throws Exception{
    	
    }
    @Test
    public void grades_getTotalGrade_1() throws Exception{
    	
    }
    @Test
    public void grades_getTotalGrade_2() throws Exception{
    	
    }
    @Test
    public void grades_calculateTotalGrade_1() throws Exception{
    	
    }
    @Test
    public void grades_calculateTotalGrade_2() throws Exception{
    	
    }
    @After
    public void after(){
		System.setIn(System.in);
		System.setOut(System.out);
    }
}
