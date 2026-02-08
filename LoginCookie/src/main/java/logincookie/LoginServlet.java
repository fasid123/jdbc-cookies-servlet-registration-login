package logincookie;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signin")
public class LoginServlet  extends HttpServlet{

	
	private static final long serialVersionUID = 1L;


	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(false);
		
		Cookie[] cookie = req.getCookies();
		String user = null;
		//session present
		if(session != null && session.getAttribute("username") != null) {
			user = (String) session.getAttribute("username"); //user = root
		}
		else {
			if(cookie != null) {
				
				for (Cookie ck: cookie) {
					
					if(ck.getName().equals("username")) {
						user = ck.getValue(); //root
						//cookies found
						//session set 
						session = req.getSession(true);
						session.setAttribute("username",user);
						
					}
				}
			}
			
			
		}
		
		if (user != null) {
			
			res.sendRedirect("home");//
		}
		else {
			res.sendRedirect("login.html");
		}
		
		
		
	}//doGet - ends
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//validate
		String uname = req.getParameter("uname"); //mohan
		String pass = req.getParameter("pass");//mohan123
		
		
		//connection establish:
		try {
			Connection con = Db.connect();
			String query = "select * from person where username = ? AND password = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, uname);
			pst.setString(2, pass);
			
			ResultSet rst = pst.executeQuery();
			
			if (rst.next()) {
				//authorized user
				
				HttpSession session = req.getSession();
				session.setAttribute("username",uname); //session create
				
				Cookie cookie = new Cookie("username",uname);
				cookie.setHttpOnly(true); //js attack prevent
				cookie.setSecure(true);
				cookie.setMaxAge(60 * 60 * 24); // 1 day cookie
				res.addCookie(cookie); //cookie create
				res.sendRedirect("home"); //get 
				return;
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//if username and password wrong
		res.getWriter().println("<html>\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "<title>Invalid </title>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<h1>Invalid Credentials </h1>\r\n"
				+ "\r\n"
				+ "<a href = \"signin\">Try Again... </a>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
	}
	
	
	
}
