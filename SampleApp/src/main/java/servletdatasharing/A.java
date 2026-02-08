package servletdatasharing;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// a servlet req and resp b servlet share panrom or forward panrom
@WebServlet("/A")
public class A extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		req.setAttribute("name","mohan");
		req.setAttribute("pass",123);
		
		//FORWARD  SERVLET A REQUEST AND RESPONSE  - SERVLET B RE AND RES
		req.getRequestDispatcher("B").forward(req, res);
	}
	
}

