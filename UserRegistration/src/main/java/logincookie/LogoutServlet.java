package logincookie;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signout")
public class LogoutServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(false);
		
		if (session != null) {
			session.invalidate();//session destroy
			Cookie cookie = new Cookie("username","");
			cookie.setHttpOnly(true);
			cookie.setSecure(true);
			cookie.setMaxAge(0);
			res.addCookie(cookie); //cookie destroy
		}
		
		res.sendRedirect("index.html");
	}
}
