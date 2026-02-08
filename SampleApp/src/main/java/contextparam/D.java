package contextparam;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//common rescource
//context param
public class D extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		ServletContext src = req.getServletContext();
		String s = src.getInitParameter("name");
		System.out.println(s);
	}
}
