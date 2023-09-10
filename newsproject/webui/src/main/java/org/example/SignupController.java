package org.example;

import org.example.exception.DuplicateValueException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "SignupController", value = "/SignupController")
public class SignupController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("loggedinuser") == null) {
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");
            String role = request.getParameter("role");
            User u = new User();
            u.setName(name);
            u.setPass(pass);
            session.setAttribute("loggedinuser", u);
            if (role.equalsIgnoreCase("admin")) {
                u.setRole_id(1);
                saveUser(u,request,response);
                response.sendRedirect("admin.jsp");


            } else {
                u.setRole_id(2);
                saveUser(u,request,response);
                response.sendRedirect("index.jsp");


            }

        }
    }

    private void saveUser(User u,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        try {
            userService.addUser(u);
        } catch (DuplicateValueException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
            request.setAttribute("signuperror",e.getMessage());
            dispatcher.forward(request,response);
            e.printStackTrace();
        }

    }
}
