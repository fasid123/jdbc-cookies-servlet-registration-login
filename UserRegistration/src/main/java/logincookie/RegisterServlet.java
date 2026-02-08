package logincookie;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {

    	
        HttpSession session = req.getSession(false);
        
        String user = null;

        if(session != null && session.getAttribute("username") != null) {
        	 user = (String) session.getAttribute("username");
        }
        else {
           
        	Cookie[] cookie = req.getCookies();
        	if (cookie != null) {
        		for(Cookie ck:cookie) {
        			if(ck.getName().equals("username")) {
        				user = ck.getValue();
        				//session create pannanum
        				session = req.getSession(true);//session illana create aagum
        				session.setAttribute("username", user);
        			}
        		}
        	}
           
        }
        
        if(user != null) {
        	res.sendRedirect("home");
        }
        else {
        	 res.sendRedirect("registeration.html");
        }
    }

    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String username = req.getParameter("uname");
        String password = req.getParameter("pass");

//        ServletConfig src = super.getServletConfig();
//        String url = src.getInitParameter("url");
//        String uname = src.getInitParameter("uname");
//        String pass = src.getInitParameter("pass");

        try {
            Connection con = Db.connect();
            String query = "insert into person values(?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, mobile);
            pst.setString(4, username);
            pst.setString(5, password);

            pst.executeUpdate();
            pst.close();
            con.close();
            
            res.setContentType("text/html");
            res.getWriter().println("""
            		
            		<!DOCTYPE html>
            		<html>
            		<body>

                    <h2>Registration Successful </h2>

            		<a href="login.html">Go to Login</a>

            		</body>
            		</html>

            		""");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
