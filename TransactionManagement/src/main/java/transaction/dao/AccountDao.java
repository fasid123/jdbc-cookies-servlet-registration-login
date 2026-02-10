package transaction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import transaction.model.Account;
import transaction.util.Db;
import transaction.util.RandomGenerateNumber;

public class AccountDao {
    
	private  String random;
	
	//1 Register Data
	public boolean register (Account acc) throws SQLException {
		//check account number is unique
		random = RandomGenerateNumber.generateRandom(); //12 DIGIT GENERATE
		
		String query = "select * from customers where accountNumber = ?";
		try(Connection con = Db.connect();
				PreparedStatement pst = con.prepareStatement(query);){
			pst.setString(1, random); //check already present
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				register(acc); //already  acc number number present
			}
			else {
				 
				 return register(acc,random); //new number
				 
			}
			
		}
		return false;
		
		
		
	}
	// 2 db related queries
	public boolean register(Account acc,String accNo) throws SQLException {
		
		
		
		
		//random 12 number
		
		String query = "insert into customers values(?,?,?,?,?,?,?)";
		try(Connection con = Db.connect();
				PreparedStatement pst = con.prepareStatement(query);){
			pst.setString(1, accNo);
			pst.setString(2, acc.getName());
			pst.setString(3, acc.getEmail());
			pst.setString(4, acc.getMobile());
			pst.setDouble(5, acc.getBalance());
			pst.setString(6, acc.getUserName());
			pst.setString(7, acc.getPassword());
			
			int row = pst.executeUpdate();
			System.out.println("Rows Affected "+row);
			return true;
			
		}
		
		
		
		
	}
	
	
	//3 from validate using name and accNum
	public Double validate(String name,String accNum) throws SQLException {
		
		String query = "select * from customers where name = ? and accountNumber = ?;";
		
		try(Connection con = Db.connect(); PreparedStatement pst = con.prepareStatement(query);){
			
			pst.setString(1, name);
			pst.setString(2, accNum);
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				return rst.getDouble("balance");
			}
			
		}
		return null;
		
	}
	
	
//4 to  validate accNum
public boolean validate(String accNum) throws SQLException {
		
		String query = "select * from customers where accountNumber = ?;";
		
		try(Connection con = Db.connect(); PreparedStatement pst = con.prepareStatement(query);){
			
			
			pst.setString(1, accNum);
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				return true;
			}
			
		}
		return false;
		
	}

//5 dao.doTransaction(from,balance,to,amt);
public boolean doTransaction(String from,double fromBal,String to,double recAmt) throws SQLException {
	
	Connection con = Db.connect();
    con.setAutoCommit(false);   // START TRANSACTION

    try {

        // debit sender
        String debit = "UPDATE customers SET balance = balance - ? WHERE accountNumber = ?";
        try (PreparedStatement ps1 = con.prepareStatement(debit)) {
            ps1.setDouble(1, recAmt);
            ps1.setString(2, from);
            ps1.executeUpdate();
        }

        // credit receiver
        String credit = "UPDATE customers SET balance = balance + ? WHERE accountNumber = ?";
        try (PreparedStatement ps2 = con.prepareStatement(credit)) {
            ps2.setDouble(1, recAmt);
            ps2.setString(2, to);
            ps2.executeUpdate();
        }

        con.commit();  
        System.out.println(" Transfer Successful");
        return true;

    } catch (Exception e) {
        con.rollback(); // edachu FAIL aachuna
        System.out.println("Transfer Failed. Money Rolled Back.");
        return false;
    } finally {
        con.close();
    }
	
}


}
