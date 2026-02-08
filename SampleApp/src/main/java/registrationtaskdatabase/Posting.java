package registrationtaskdatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//dbpost
public class Posting  extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "<title>Login Screen</title>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<form action = \"dbpost\" method = \"post\">\r\n"
				+ "\r\n"
				+ "<label for = \"1\">Name :</label>\r\n"
				+ "<input type = \"text\" name = \"name\" id = \"1\">\r\n"
				+ "<br/>\r\n"
				+ "\r\n"
				+ "<label for = \"2\">Email :</label>\r\n"
				+ "<input type = \"text\" name = \"email\" id = \"2\">\r\n"
				+ "<br/>\r\n"
				+ "\r\n"
				+ "<label for = \"3\">Mobile :</label>\r\n"
				+ "<input type = \"text\" name = \"mobile\" id = \"3\">\r\n"
				+ "<br/>\r\n"
				+ "\r\n"
				+ "<label for = \"4\">Age :</label>\r\n"
				+ "<input type = \"text\" name = \"age\" id = \"4\">\r\n"
				+ "<br/>\r\n"
				+ "\r\n"
				+ "<button type = \"submit\">Submit</button>\r\n"
				+ "\r\n"
				+ "</form>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
	}
	
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		int age = Integer.parseInt(req.getParameter("age"));
		
		try {
			ServletConfig src = super.getServletConfig();
			String url = src.getInitParameter("url");
			String uname = src.getInitParameter("uname");
			String pass = src.getInitParameter("pass");
			
			Connection con = Db.connect(url,uname,pass);
			String query = "insert into person(name,email,mobile,age) values (?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, mobile);
			pst.setInt(4, age);
			
			int rows = pst.executeUpdate();
			
			//console ku oru log
			System.out.println("Rows Affected "+rows);
			
			//browser ku oru log
			PrintWriter out = res.getWriter();
			out.println("Data Added Successfully");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}