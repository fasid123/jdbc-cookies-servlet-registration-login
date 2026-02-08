package contenttask;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


class Employee{
	
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {

		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}

@WebServlet("/employees")
public class TaskContentXML extends HttpServlet {
	static ArrayList<Employee> arr = new ArrayList<>();
	
	public static void addEmployee() {
		arr.add(new Employee(1,"mohan",12000));
		arr.add(new Employee(2,"fasid",10000));
		arr.add(new Employee(3,"muneef",24000));
		arr.add(new Employee(4,"deva",21000));
		arr.add(new Employee(5,"sridhar",23000));
		arr.add(new Employee(6,"kumar",27000));
		arr.add(new Employee(7,"sharath",53000));
		arr.add(new Employee(8,"mahesh",83000));
		arr.add(new Employee(9,"lokesh",13000));
		arr.add(new Employee(10,"tamil",32000));
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		res.setContentType("application/xml");
		PrintWriter out = res.getWriter();
		
		
		addEmployee();
		
		out.println("<employees>");
		for (Employee emp: arr) {
			out.println("<employee>");
			
			out.println("<id>"+emp.getId()+"</id>");
			out.println("<name>"+emp.getName()+"</name>");
			out.println("<salary>"+emp.getSalary()+"</salary>");
			
			
			out.println("</employee>");
		}
		out.println("</employees>");
	}
	
	
}
