import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.SystemMsg;
import gradeSystem.UI;

public class TestCase1 {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void before() {
    	//將訊息欄分離
    	//寫出其他的test
    	//檢查header
    	//最後檢查
    	System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void test1() throws Exception{
    	/*
    	 * Q->離開系統
    	 */
    	ByteArrayInputStream exit = new ByteArrayInputStream("Q".getBytes());
    	System.setIn(exit);
    	
    	UI ui = new UI();
		ui.promptID();
		
        assertEquals(SystemMsg.promptIdMsg + SystemMsg.finishMsg , outContent.toString());
        
    }
    
    @Test
    public void test2() throws Exception{
    	/*
    	 * 輸入學號
    	 * E->離開指令
    	 * Q->離開系統
    	 */
    	ByteArrayInputStream studentId = new ByteArrayInputStream("985002009\nE\nQ\n".getBytes());
    	System.setIn(studentId);
    	
    	UI ui = new UI();
		ui.promptID();
		
        assertEquals(SystemMsg.promptIdMsg +
        		"歡迎！呂哲光\r\n"+
        		SystemMsg.promptCommandMsg+
        		SystemMsg.promptIdMsg+
        		SystemMsg.finishMsg, outContent.toString());
        
    }
    
    @Test
    public void test3() throws Exception{
    	/*
    	 * 輸入學號
    	 * G-> 顯示成績
    	 * E-> 離開指令
    	 * Q-> 離開系統
    	 */
    	ByteArrayInputStream studentId = new ByteArrayInputStream("985002009\nG\nE\nQ\n".getBytes());
    	System.setIn(studentId);
    	
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
    public void test4() throws Exception{
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
    public void test5() throws Exception{
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
    public void test6() throws Exception{
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
