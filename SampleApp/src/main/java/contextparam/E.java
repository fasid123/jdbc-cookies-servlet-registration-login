package contextparam;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//context param and init param used here 
public class E extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		//context param so data share all servlet 
		ServletContext src = req.getServletContext();
		String s = src.getInitParameter("name");
		System.out.println(s);
		
		//init param i mentioned in E servet only so cannot access this data in D
		ServletConfig config = super.getServletConfig();
		String notShare = config.getInitParameter("name");
		System.out.println(notShare);
	}
}
