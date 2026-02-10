package transaction.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import transaction.service.BankingService;

@WebServlet("/accvalidate")
public class ValidateServlet  extends HttpServlet{
	
	private BankingService service = new BankingService();
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String accNum = req.getParameter("accnumber");
		
			try {
				Double bal = service.validate(name,accNum);//ipdi oru acc irukka
				if(bal != null) {
					//servlet to jsp 
					//from page validation inga dhan
					req.setAttribute("name", name); //sender account name
					req.setAttribute("accNum", accNum); //sender acc num
					req.setAttribute("balance",bal); //sender acc balance
					req.getRequestDispatcher("/views/topage.jsp").forward(req, res);
				}
				else {
					req.getRequestDispatcher("/views/invalid.jsp").forward(req, res);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} 
		
	}

}