package logincheckmvc.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import logincheckmvc.service.PersonService;

@WebServlet("/signin")
public class LoginServlet extends HttpServlet {

    private PersonService service = new PersonService();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            res.sendRedirect("home");
        } else {
            req.getRequestDispatcher("views/login.jsp")
               .forward(req, res);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");

        if (service.login(uname, pass)) {   // ← SERVICE USED HERE

            HttpSession session = req.getSession();
            session.setAttribute("username", uname);

            Cookie c = new Cookie("username", uname);
            c.setMaxAge(24 * 60 * 60); // 1 day
            res.addCookie(c);

            res.sendRedirect("home");

        } else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("views/login.jsp")
               .forward(req, res);
        }
    }
}
