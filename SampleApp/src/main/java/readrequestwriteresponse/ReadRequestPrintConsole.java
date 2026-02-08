package readrequestwriteresponse;

import java.io.BufferedReader;
import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class ReadRequestPrintConsole extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader bfr = req.getReader();
		int i;
		
		while((i = bfr.read()) != -1) {
			char ch = (char) i;
			
			System.out.print(ch);
		}
		System.out.println();
		
	}
}

