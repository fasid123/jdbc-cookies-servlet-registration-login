package servletdatasharing;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/B")
public class B extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		
		String name = (String) req.getAttribute("name");
	    int pass = (int) req.getAttribute("pass");
		
		System.out.println(name +" - "+pass);
	}
}
