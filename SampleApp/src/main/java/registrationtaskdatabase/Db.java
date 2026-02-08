package registrationtaskdatabase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Db Connection - Utility Class
public class Db  {
	
	//Eppo Db class load aagudho appo static block first execte aagum
	static {
		
		//Manualla Driver class Load Panrom
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	        System.out.println("Driver Loaded");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	}
	
	public static Connection connect(String url,String uname,String pass) throws SQLException {
		
		//Connection - object return aagum
		return DriverManager.getConnection(url,uname,pass);
		
	}
	
}
