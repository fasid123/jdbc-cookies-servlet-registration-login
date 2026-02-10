package logincheckmvc.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import logincheckmvc.model.Person;
import logincheckmvc.service.PersonService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private PersonService service = new PersonService();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.getRequestDispatcher("views/register.jsp")
           .forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Person p = new Person(
            req.getParameter("name"),
            req.getParameter("email"),
            req.getParameter("mobile"),
            req.getParameter("uname"),
            req.getParameter("pass")
        );

        if (service.register(p)) {   // ← SERVICE USED HERE
            res.sendRedirect("signin");
        } else {
            req.setAttribute("msg", "Registration Failed");
            req.getRequestDispatcher("views/register.jsp")
               .forward(req, res);
        }
    }
}
