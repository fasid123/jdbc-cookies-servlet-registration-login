package transaction.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import transaction.service.BankingService;

@WebServlet("/transaction")
public class TransactionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private BankingService service = new BankingService();
	
	//full checking panrom to account irukka, then andha amount sender ta irukkaanu
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		//sender
		String fromacc = req.getParameter("fromAcc");
		double fromBalance = Double.parseDouble(req.getParameter("fromBalance"));

		//receiver
		String toacc = req.getParameter("accnumber");
		Double amount = Double.parseDouble(req.getParameter("amounts"));

		
		if (service.transaction(fromacc,fromBalance,toacc,amount)) {
			req.getRequestDispatcher("/views/success.jsp").forward(req, res);
		}
		else {
			req.getRequestDispatcher("/views/invalid.jsp").forward(req, res);
		}
		
		
		
	}
	
}
