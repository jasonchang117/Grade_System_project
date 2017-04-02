package test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.GradeSystem;
import gradeSystem.SystemMsg;

public class TestCase1 {
	/*
	 * 用來測GradeSystem
	 */
	/**
	 * @uml.property  name="outContent"
	 */
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void before() {
    	System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void gradeSystem_containsID_1() throws Exception{
    	
    	GradeSystem gradeSystem = new GradeSystem();
		assertTrue(gradeSystem.containsID("985002009"));
    }
    
    @Test
    public void gradeSystem_containsID_2() throws Exception{
    	GradeSystem gradeSystem = new GradeSystem();
		assertFalse(gradeSystem.containsID("986002009"));
    }
    @Test
    public void gradeSystem_showGrade_1() throws Exception{
    	GradeSystem gradeSystem = new GradeSystem();
    	gradeSystem.showGrade("955002056");
    	assertEquals("許文馨的分數: \r\n"+ 
        		"lab_1      : 88\r\n"+
        		"lab_2      : 92\r\n"+
        		"lab_3      : 88\r\n"+
        		"mid-term   : 98\r\n"+
        		"final-exam : 91\r\n"+
        		"total-grade: 93\r\n"
        		, outContent.toString());
    }
    @Test
    public void gradeSystem_showGrade_2() throws Exception{
    	GradeSystem gradeSystem = new GradeSystem();
    	gradeSystem.showGrade("985002009");
    	assertEquals("呂哲光的分數: \r\n"+ 
        		"lab_1      : 81\r\n"+
        		"lab_2      : 83\r\n"+
        		"lab_3      : 86\r\n"+
        		"mid-term   : 82\r\n"+
        		"final-exam : 90\r\n"+
        		"total-grade: 86\r\n"
        		, outContent.toString());
    }
    @Test
    public void gradeSystem_showRank_1() throws Exception{
    	GradeSystem gradeSystem = new GradeSystem();
    	gradeSystem.showRank("985002009");
    	assertEquals("呂哲光的排名: 56\r\n", outContent.toString());
    }
    @Test
    public void gradeSystem_showRank_2() throws Exception{
    	GradeSystem gradeSystem = new GradeSystem();
    	gradeSystem.showRank("955002056");
    	assertEquals("許文馨的排名: 14\r\n", outContent.toString());
    }
    @Test
    public void gradeSystem_showAverage_1() throws Exception{
    	GradeSystem gradeSystem = new GradeSystem();
    	gradeSystem.showAverage();
    	assertEquals("lab_1      : 90\r\n"+
        		"lab_2      : 88\r\n"+
        		"lab_3      : 89\r\n"+
        		"mid-term   : 90\r\n"+
        		"final-exam : 90\r\n", outContent.toString());
    }
    @Test
    public void gradeSystem_showAverage_2() throws Exception{
    	GradeSystem gradeSystem = new GradeSystem();
    	gradeSystem.showAverage();
    	assertEquals("lab_1      : 90\r\n"+
        		"lab_2      : 88\r\n"+
        		"lab_3      : 89\r\n"+
        		"mid-term   : 90\r\n"+
        		"final-exam : 90\r\n", outContent.toString());
    }
    @Test
    public void gradeSystem_updateWeights_1() throws Exception{
    	GradeSystem gradeSystem = new GradeSystem();
    	gradeSystem.updateWeights(new double[]{10, 20, 20, 20, 20});
    	assertEquals(SystemMsg.weightError +
    			"90\r\n", outContent.toString());
    }
    @Test
    public void gradeSystem_updateWeights_2() throws Exception{
    	GradeSystem gradeSystem = new GradeSystem();
    	gradeSystem.updateWeights(new double[]{20, 20, 20, 20, 20});
    	assertEquals("", outContent.toString());
    }
    @Test
    public void gradeSystem_searchName_1() throws Exception{
    	GradeSystem gradeSystem = new GradeSystem();
    	assertEquals("呂哲光", gradeSystem.searchName("985002009"));
    }
    @Test
    public void gradeSystem_searchName_2() throws Exception{
    	GradeSystem gradeSystem = new GradeSystem();
    	assertNull(gradeSystem.searchName("986002009"));
    }
    @After
    public void after(){
		System.setIn(System.in);
		System.setOut(System.out);
    }
}
