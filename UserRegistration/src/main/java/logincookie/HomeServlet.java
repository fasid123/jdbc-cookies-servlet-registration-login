package logincookie;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(false); //session check
		Cookie[] cookie = req.getCookies();
		String user = null;
		//if session present
		if (session != null && session.getAttribute("username") != null) {
			user = (String) session.getAttribute("username");
		}
		//if session not present cookiesla irukkanu check pannanum
		else {
			if (cookie != null) {
				for (Cookie ck : cookie) {
					if(ck.getName().equals("username")) {
						user = ck.getName();
						//cookies found
						//set session
						session = req.getSession(true);
						session.setAttribute("username", user);
						
					}
				}
			}
		}
		
		if (session != null) {
			res.getWriter().println("<h1> Welcome "+ session.getAttribute("username") + "</h1> <br> <a href = \"signout\"> Logout </a>");	
			}
		else {
			res.sendRedirect("login.html");
		}
		
	}
}
