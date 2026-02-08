package loginvalidate;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginForm  extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println(
"<html>\r\n"
+ "\r\n"
+ "<head>\r\n"
+ "<title>Login Screen</title>\r\n"
+ "</head>\r\n"
+ "\r\n"
+ "<body>\r\n"
+ "\r\n"
+ "<form action = \"validate\" method = \"get\">\r\n"
+ "\r\n"
+ "<label for = \"username\">username</label>\r\n"
+ "<input type = \"text\" name = \"username\" id = \"username\">\r\n"
+ "\r\n"
+ "<label for = \"password\">password</label>\r\n"
+ "<input type = \"text\" name = \"password\" id = \"password\">\r\n"
+ "\r\n"
+ "<button type = \"submit\">submit</button>\r\n"
+ "\r\n"
+ "</form>\r\n"
+ "\r\n"
+ "</body>\r\n"
+ "\r\n"
+ "</html>"
				);
		
	}
}

