package test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.SystemMsg;
import gradeSystem.UI;

public class TestCase2 {
	/*
	 * 用來測UI
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
    public void ui_checkID_1() throws Exception{
    	ByteArrayInputStream action = new ByteArrayInputStream("E\nQ\n".getBytes());
    	System.setIn(action);
    	
    	UI ui = new UI();
    	ui.checkID("955002056");
    	
    	assertEquals("歡迎！許文馨\r\n"+
        		SystemMsg.promptCommandMsg+
        		SystemMsg.promptIdMsg+
        		SystemMsg.finishMsg, outContent.toString());
    }
    @Test
    public void ui_checkID_2() throws Exception{
    	ByteArrayInputStream action = new ByteArrayInputStream("E\nQ\n".getBytes());
    	System.setIn(action);
    	
    	UI ui = new UI();
    	ui.checkID("956002056");
    	
    	assertEquals(SystemMsg.errorIdMsg, outContent.toString());
    }
    @Test
    public void ui_promptID_1() throws Exception{
    	ByteArrayInputStream action = new ByteArrayInputStream("955002056\nE\nQ\n".getBytes());
    	System.setIn(action);
    	
    	UI ui = new UI();
    	ui.promptID();
    	
    	assertEquals(SystemMsg.promptIdMsg +
        		"歡迎！許文馨\r\n"+
        		SystemMsg.promptCommandMsg+
        		SystemMsg.promptIdMsg+
        		SystemMsg.finishMsg, outContent.toString(), outContent.toString());
    }
    @Test
    public void ui_promptID_2() throws Exception{
    	ByteArrayInputStream action = new ByteArrayInputStream("985002009\nG\nE\nQ\n".getBytes());
    	System.setIn(action);
    	
    	UI ui = new UI();
		ui.promptID();
		
        assertEquals(SystemMsg.promptIdMsg +
        		"歡迎！呂哲光\r\n"+
        		SystemMsg.promptCommandMsg+
        		"呂哲光的分數: \r\n"+ 
        		"lab_1      : 81\r\n"+
        		"lab_2      : 83\r\n"+
        		"lab_3      : 86\r\n"+
        		"mid-term   : 82\r\n"+
        		"final-exam : 90\r\n"+
        		"total-grade: 86\r\n"+
        		SystemMsg.promptCommandMsg+
        		SystemMsg.promptIdMsg+
        		SystemMsg.finishMsg, outContent.toString());
    }
    @Test
    public void ui_promptID_3() throws Exception{
    	/*
    	 * 輸入學號
    	 * R-> 顯示排名
    	 * E-> 離開指令
    	 * Q-> 離開系統
    	 */
    	ByteArrayInputStream studentId = new ByteArrayInputStream("985002009\nR\nE\nQ\n".getBytes());
    	System.setIn(studentId);
    	
    	UI ui = new UI();
		ui.promptID();
		
        assertEquals(SystemMsg.promptIdMsg +
        		"歡迎！呂哲光\r\n"+
        		SystemMsg.promptCommandMsg+
        		"呂哲光的排名: 56\r\n"+
        		SystemMsg.promptCommandMsg+
        		SystemMsg.promptIdMsg+
        		SystemMsg.finishMsg, outContent.toString());
        
    }
    
    @Test
    public void ui_promptID_4() throws Exception{
    	/*
    	 * 輸入學號
    	 * R-> 顯示平均
    	 * E-> 離開指令
    	 * Q-> 離開系統
    	 */
    	ByteArrayInputStream studentId = new ByteArrayInputStream("985002009\nA\nE\nQ\n".getBytes());
    	System.setIn(studentId);
    	
    	UI ui = new UI();
		ui.promptID();
		
        assertEquals(SystemMsg.promptIdMsg +
        		"歡迎！呂哲光\r\n"+
        		SystemMsg.promptCommandMsg+
        		"lab_1      : 90\r\n"+
        		"lab_2      : 88\r\n"+
        		"lab_3      : 89\r\n"+
        		"mid-term   : 90\r\n"+
        		"final-exam : 90\r\n"+
        		SystemMsg.promptCommandMsg+
        		SystemMsg.promptIdMsg+
        		SystemMsg.finishMsg, outContent.toString());
        
    }
    @Test
    public void ui_promptID_5() throws Exception{
    	/*
    	 * 輸入學號
    	 * W-> 更改配分
    	 * E-> 離開指令
    	 * Q-> 離開系統
    	 */
    	ByteArrayInputStream studentId = new ByteArrayInputStream("985002009\nW\n20\n20\n20\n20\n20\nY\nE\nQ\n".getBytes());
    	System.setIn(studentId);
    	
    	UI ui = new UI();
		ui.promptID();
		
        assertEquals(SystemMsg.promptIdMsg +
        		"歡迎！呂哲光\r\n"+
        		SystemMsg.promptCommandMsg+
        		SystemMsg.enterNewWeightMsg+
        		"lab_1(%): \r\n"+
        		"lab_2(%): \r\n"+
        		"lab_3(%): \r\n"+
        		"mid-term(%): \r\n"+
        		"final_exam(%): \r\n"+
        		SystemMsg.confirmNewWeightHintMsg+
        		"lab_1(%): 20.0\r\n"+
        		"lab_2(%): 20.0\r\n"+
        		"lab_3(%): 20.0\r\n"+
        		"mid-term(%): 20.0\r\n"+
        		"final_exam(%): 20.0\r\n"+
        		SystemMsg.confirmNewWeightMsg+
        		SystemMsg.promptCommandMsg+
        		SystemMsg.promptIdMsg+
        		SystemMsg.finishMsg, outContent.toString());
        
    }
    @After
    public void after(){
		System.setIn(System.in);
		System.setOut(System.out);
    }
}
