package loginvalidate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/validate")

public class Validating extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		System.out.println(uname + " - "+pass);
		
	}
}
