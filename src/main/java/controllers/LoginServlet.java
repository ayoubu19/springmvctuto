package controllers;

import models.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    private UserService userService ;

    public LoginServlet(UserService userService) {
        super();
        // TODO Auto-generated constructor stub
        this.userService =userService ;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        request.getRequestDispatcher("/vues/login.jsp").forward(request,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(userService.isUserValid(username,password)){
            User user = userService.getUserByUsername(username);
            HttpSession session= request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher( "/vues/profile.jsp" ).forward( request, response );
        }else{
            request.getRequestDispatcher( "/vues/error.jsp" ).forward( request, response );
        }

     }
}
