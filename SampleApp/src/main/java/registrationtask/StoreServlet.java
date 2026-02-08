package registrationtask;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/store")
public class StoreServlet extends HttpServlet {

	static ArrayList<Person> arr = new ArrayList<>();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "<title>Student Registration</title>\r\n"
				+ "\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "<h1> Student Registration </h1>\r\n"
				+ "<form action = \"store\" method = \"post\">\r\n"
				+ "\r\n"
				+ "<label for = \"studentname\">Name : </label>\r\n"
				+ "<input type=\"text\" name = \"name\" id = \"studentname\"  />\r\n"
				+ "<br/>\r\n"
				+ "\r\n"
				+ "<label for = \"studentemail\">Email : </label>\r\n"
				+ "<input type=\"text\" name = \"email\" id = \"studentemail\"  />\r\n"
				+ "<br/>\r\n"
				+ "\r\n"
				+ "<label for = \"student\">Mobile :  </label>\r\n"
				+ "<input type=\"text\" name = \"mobile\" id = \"studentmobile\"  />\r\n"
				+ "<br/>\r\n"
				+ "\r\n"
				+ "<label for = \"studentage\">Age :  </label>\r\n"
				+ "<input type=\"text\" name = \"age\" id = \"studentage\"  />\r\n"
				+ "<br/>\r\n"
				+ "\r\n"
				+ "<button type = \"submit\">Submit </button>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</form>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String age = req.getParameter("age");
		
		Person p = new Person(name,email,mobile,age);
		arr.add(p);
		
		//servlet - servlet communication : forward req and resp to another servlet
	
		//req.getRequestDispatcher("display").forward(req, res);
		
		
		
	}
	
}
