package transaction.model;

public class Account {
	//pojo 
	//data store pannura container use pannuvom
	String name;
	String email;
	String mobile;
	double balance;
	String userName;
	String password;
	
	public Account(String name, String email, String mobile, double balance, String userName, String password) {
		
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.balance = balance;
		this.userName = userName;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public double getBalance() {
		return balance;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	
	
	
	
	
	
	
	
	
}
