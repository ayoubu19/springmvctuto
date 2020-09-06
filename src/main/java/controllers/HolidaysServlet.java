package controllers;

import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HolidaysServlet extends HttpServlet {
   public HolidaysServlet() {
   super();
   }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();
        User user =(User)session.getAttribute("user");

        if (user!=null) {

        request.getRequestDispatcher("/vues/holidays.jsp").forward(request, response);

        }else {
        request.setAttribute( "connected", false );
        request.getRequestDispatcher("/vues/error.jsp").forward(request, response);
    }
    }


}
