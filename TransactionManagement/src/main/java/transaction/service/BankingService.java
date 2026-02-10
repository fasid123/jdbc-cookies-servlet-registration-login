package transaction.service;

import java.sql.SQLException;

import transaction.dao.AccountDao;
import transaction.model.Account;

public class BankingService {

	private AccountDao dao = new AccountDao();
	
	//business logics
	
	public boolean register(Account acc) throws SQLException {
		
		return  dao.register(acc);
		
	}
	
	//from validate
	public Double validate(String name,String accNum) throws SQLException {
		Double balance = dao.validate(name,accNum);
		// return balance to servlet
		if (balance != null) {
			return balance;
		}
		return null;
	}
	
	//to validate , amount checking
	public boolean transaction(String from,double balance,String to,double amt) {
		
		
		try {
			//to account iruku
			if (dao.validate(to)) {
				
					if (balance >= amt) { //SENDER >= RECEIVER anupura amount
						if(dao.doTransaction(from,balance,to,amt)) {
							return true;
						}
						else {
							return false;	
					}
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
}
