import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.SystemMsg;
import gradeSystem.UI;

/*
 * Integrated Test
 */
public class TestCase4 {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void before() {
    	System.setOut(new PrintStream(outContent));
    }
    /*
     * 1. ��J�Ǹ�
     * 2. G ->��ܦ��Z
     * 3. R ->��ܱƦW
     * 4. A ->��ܥ���
     * 5. W ->���t��
     * 6. E ->���}
     * 7. Q ->���}�t��
     */
    @Test
    public void integrationTest() throws Exception{
    	ByteArrayInputStream studentId = new ByteArrayInputStream("985002009\nG\nR\nA\nW\n20\n20\n20\n20\n20\nY\nE\nQ\n".getBytes());
    	System.setIn(studentId);
    	
    	UI ui = new UI();
		ui.promptID();
		
        assertEquals(SystemMsg.promptIdMsg +
        		"�w��I�f����\r\n"+
        		SystemMsg.promptCommandMsg+
        		"�f����������: \r\n"+ 
        		"lab_1      : 81\r\n"+
        		"lab_2      : 83\r\n"+
        		"lab_3      : 86\r\n"+
        		"mid-term   : 82\r\n"+
        		"final-exam : 90\r\n"+
        		"total-grade: 86\r\n"+
        		SystemMsg.promptCommandMsg+
        		"�f�������ƦW: 56\r\n"+
        		SystemMsg.promptCommandMsg+
        		"lab_1      : 90\r\n"+
        		"lab_2      : 88\r\n"+
        		"lab_3      : 89\r\n"+
        		"mid-term   : 90\r\n"+
        		"final-exam : 90\r\n"+
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
    /*
     * 1. ��J�Ǹ�
     * 2. G ->��ܦ��Z
     * 3. W ->���t��
     * 4. R ->��ܱƦW
     * 5. A ->��ܥ���
     * 6. E ->���}
     * 7. ��J�t�@�ӾǸ�
     * 8. G ->��ܦ��Z
     * 9. E ->���}
     * 10. Q ->���}�t��
     */
    @Test
    public void integrationTest2() throws Exception{
    	ByteArrayInputStream studentId = new ByteArrayInputStream("985002009\nG\nW\n20\n20\n20\n20\n20\nY\nR\nA\nE\n962001051\nG\nE\nQ\n".getBytes());
    	System.setIn(studentId);
    	
    	UI ui = new UI();
		ui.promptID();
		
        assertEquals(SystemMsg.promptIdMsg +
        		"�w��I�f����\r\n"+
        		SystemMsg.promptCommandMsg+
        		"�f����������: \r\n"+ 
        		"lab_1      : 81\r\n"+
        		"lab_2      : 83\r\n"+
        		"lab_3      : 86\r\n"+
        		"mid-term   : 82\r\n"+
        		"final-exam : 90\r\n"+
        		"total-grade: 86\r\n"+
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
        		"�f�������ƦW: 61\r\n"+
        		SystemMsg.promptCommandMsg+
        		"lab_1      : 90\r\n"+
        		"lab_2      : 88\r\n"+
        		"lab_3      : 89\r\n"+
        		"mid-term   : 90\r\n"+
        		"final-exam : 90\r\n"+
        		SystemMsg.promptCommandMsg+
        		SystemMsg.promptIdMsg +
        		"�w��I���§�\r\n"+
        		SystemMsg.promptCommandMsg+
        		"���§ʪ�����: \r\n"+ 
        		"lab_1      : 81\r\n"+
        		"lab_2      : 32*\r\n"+
        		"lab_3      : 50*\r\n"+
        		"mid-term   : 90\r\n"+
        		"final-exam : 93\r\n"+
        		"total-grade: 69\r\n"+
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
