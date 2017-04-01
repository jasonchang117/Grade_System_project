package gradeSystem;

public class SystemMsg {
	
	public final static String promptIdMsg="請輸入學號，或者輸入Q離開系統\r\n";
	public final static String promptCommandMsg="Please choose the command:\r\n"
			+ "1) G -> 顯示分數\r\n"
			+ "2) R -> 顯示排名\r\n"
			+ "3) A -> 顯示班平均\r\n"
			+ "4) W -> 更改配分\r\n"
			+ "5) E -> 離開\r\n";
	public final static String finishMsg="完成查詢！離開系統\n";
	public final static String welcomeMsg="歡迎！";
	
	public final static String enterNewWeightMsg="請輸入新配分\r\n"+
			"單位:%，總合為100%\r\n";
	public final static String confirmNewWeightHintMsg="請確認新配分\r\n";
	public final static String confirmNewWeightMsg="以上正確嗎? Y(yes) 或 N(No)\r\n";
	public final static String errorIdMsg="ID輸入錯誤！\r\n";
	public final static String[] scoreType = new String[] {"lab_1", "lab_2", "lab_3", "mid-term", "final-exam"};
	public final static String weightError="配分錯誤！\r\n";
	public final static String commandError="指令錯誤！\r\n";
}
