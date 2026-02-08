package contenttask;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


class Product{
	
	private int id;
	private String name;
	private double price;
	
	public Product(int id, String name, double price) {
		
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return price;
	}
}

@WebServlet("/products")
public class TaskContentJson extends HttpServlet {
	static ArrayList<Product> arr = new ArrayList<>();
	
	public static void addProduct() {
		arr.add(new Product(1,"Laptop",12000));
		arr.add(new Product(2,"Mobile",10000));
		arr.add(new Product(3,"Mixie",24000));
		arr.add(new Product(4,"Ac",21000));
		arr.add(new Product(5,"Tv",23000));
		arr.add(new Product(6,"Oven",27000));
		arr.add(new Product(7,"Fridge",53000));
		arr.add(new Product(8,"Fan",83000));
		arr.add(new Product(9,"Washing-Machine",13000));
		arr.add(new Product(10,"Kettle",32000));
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		
		addProduct();
		
		out.println("[");
		
		for (int i = 0; i < arr.size();i++) {
			Product p = arr.get(i);
			out.println("     {");
			out.println("       \"id\":"+p.getId()+",");
			out.println("       \"name\":"+"\""+p.getName()+"\""+",");
			out.println("       \"price\":"+p.getPrice());
			out.print("     }");
			
			
			if (i < arr.size() - 1) {
				out.println(",");
			}
		}
		
		out.println();
		out.println("]");
	}
	
	
}
