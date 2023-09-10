package org.example;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    private static UserService userService = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     /*   try (
                PrintWriter pw = response.getWriter()) {
            response.setContentType("text/html; charset=utf-8");
*/
        HttpSession session= request.getSession();
        if(session.getAttribute("loggedinuser")==null) {
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");
            User u = userService.getUser(name);
            if (u != null) {
                if (userService.checkLoginTrue(pass, u.getPass())) {
                    session.setAttribute("loggedinuser", u);
                    if(u.getRole_id()==1){
                        response.sendRedirect("admin.jsp");
                    } else{
                        response.sendRedirect("news.jsp");

                    }

                } else {

                    request.setAttribute("login", "Password is wrong");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.include(request, response);
                }
            } else {

                request.setAttribute("login", "Username not found");

                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }

        }
    }
}