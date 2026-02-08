package servletintro;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//without api call old method add file in web.xml
//web.xml - dispatcher Servlet

public class EachMethodCall  extends HttpServlet{

	@Override
	public void init() {
		System.out.println("Servlet is Initialized...");
	}
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("Get-Method");
		System.out.println("Get Method is called");
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("Post-Method");
		System.out.println("Post Method is called");
	}
	
	@Override
	public void doPut(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("Put-Method");
		System.out.println("Put Method is called");
	}
	
	@Override
	public void doDelete(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("Delete-Method");
		System.out.println("Delete Method is called");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy method is called...");
	}
}
