package registrationtaskdatabase;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//dbget
public class Viewing extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		
		String sql = "SELECT name,email,mobile,age from person";
		boolean track = true;
		StringBuffer sb = new StringBuffer();
		
		sb.append("[");
		
		try {
			//take value from context param and pass to connect method
			ServletConfig src = super.getServletConfig();
			String url = src.getInitParameter("url");
			String uname = src.getInitParameter("uname");
			String pass = src.getInitParameter("pass");
			
			Connection con = Db.connect(url,uname,pass);
			 
			 PreparedStatement pst = con.prepareStatement(sql);
			 ResultSet rst = pst.executeQuery();
			 while(rst.next()) {
				    
				 //commas oru oru detailsku add aaganum but lastla add aaga koodathuu
	                if (!track) {
	                    sb.append(",");
	                }
	                
				    sb.append("  {");
	                sb.append("    \"name\":\"" + rst.getString("name") + "\",");
	                sb.append("    \"email\":\"" + rst.getString("email") + "\",");
	                sb.append("    \"mobile\":\"" + rst.getString("mobile") + "\",");
	                sb.append("    \"age\":" + rst.getInt("age"));
	                sb.append("  }");
	                
	                track = false; // comma ku help panra oru variable.
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		sb.append("]");
		
		String json = sb.toString();
		out.println(json);
	}
}