package servletintro;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Lifecycle METHOD IN servlet

@WebServlet("/lifecycle")
public class LifeCycleMethodServlet extends HttpServlet{
	
	//life cycle method
	@Override
	public void init() {
		System.out.println("Servlet is initialized...");
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Service method is called...");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy method is called...");
	}
	
}
