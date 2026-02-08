package registrationtask;

//pojo (plain old java object) - for store and transfer data
// encapulated class
public class Person {

	private String name;
	private String email;
	private String mobile;
	private String age;
	
	//constructor
	public Person(String name, String email, String mobile, String age) {
		
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
	}

	//getter
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAge() {
		return age;
	}

	
	
	
	
	
}
