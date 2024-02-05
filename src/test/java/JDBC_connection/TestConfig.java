package JDBC_connection;
public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "yarocker12@gmail.com";
	public static String password = "yash1234";
	public static String[] to ={"yashagarwal12081999@gmail.com"};
	public static String subject = "Extent Project Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="D:\\Documents\\Me\\Photo.jpg";
	public static String attachmentName="Photo.jpg";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="training"; 
	public static String dbPassword="training"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.cj.jdbc.Driver";
	public static String mysqluserName = "training";
	public static String mysqlpassword = "training";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/demo";
	
	
	
	
	
	
	
	
}
