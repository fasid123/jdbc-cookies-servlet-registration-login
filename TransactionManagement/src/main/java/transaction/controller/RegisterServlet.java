package transaction.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import transaction.model.Account;
import transaction.service.BankingService;

@WebServlet("/accregister")
public class RegisterServlet  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private BankingService service = new BankingService();
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		Account acc = new Account(
		req.getParameter("name"),
		req.getParameter("email"),
		req.getParameter("mobile"),
	    Double.parseDouble(req.getParameter("balance")),
		req.getParameter("uname"),
		req.getParameter("pass")
	);
		//service la ulla register methodanupu
		try {
			if (service.register(acc)) {
				req.getRequestDispatcher("/views/reg-success.jsp").forward(req, res);
				//register success
			}
		} catch (SQLException  e) {
			
			e.printStackTrace();
		}
	}

}
