package readrequestwriteresponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Read request body data and print whatever request has been sent

@WebServlet("/saveresponse")
public class PostAndResponse extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//reader
		//read request body content : JSON
		BufferedReader bfr = req.getReader();
		String i;
		StringBuilder sb = new StringBuilder();
		
		while((i = bfr.readLine()) != null) {
			sb.append(i);//store in stringbuffer
		}
		
		//console output
		String json = sb.toString();
		//why this conversion reason is after finished this appending process the final thing is end result so again we convert into string for give as a n input to println
	    System.out.println(json);
	    
	    //writer - postman response
	    res.setContentType("application/json");
	    PrintWriter out =  res.getWriter();
	    out.println(json);
		
	}
}
