package registrationtask;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet{
	
	ArrayList<Person> ar = StoreServlet.arr;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.println("[");
		// i = 0 - 9
		for (int i = 0; i < ar.size();i++) {
			Person p = ar.get(i);
			out.println("  {");
			
			out.print("\"name\": \""+p.getName()+"\",");
			out.print("\"email\": \""+p.getEmail()+"\",");
			out.print("\"mobile\": \""+p.getMobile()+"\",");
			out.print("\"age\": \""+p.getAge()+"\"");
			
			out.println("  }");
			//9 < 9
			if (i < ar.size() - 1) {
				out.print(",");
			}
			
		}
		out.println("]");
	}
	
	//forward request from post - post then call get mthd
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		doGet(req,res);
	}
}
