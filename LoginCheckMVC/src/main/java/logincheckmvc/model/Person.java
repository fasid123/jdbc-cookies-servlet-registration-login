package logincheckmvc.model;

public class Person {

    private String name;
    private String email;
    private String mobile;
    private String username;
    private String password;

    public Person() {
    	
    }

    public Person(String name, String email, String mobile,
                  String username, String password) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
