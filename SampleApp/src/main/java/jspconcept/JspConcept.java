package jspconcept;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getjsp")
public class JspConcept extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		req.setAttribute("username", "fasid");
		
		req.getRequestDispatcher("check.jsp").forward(req, res);
	}

	
}
