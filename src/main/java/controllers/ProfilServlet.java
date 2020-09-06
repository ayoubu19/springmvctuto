package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfilServlet  extends HttpServlet {

 public ProfilServlet() {
    super();
}
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user")!=null) {
            request.getRequestDispatcher("/vues/profile.jsp").forward(request, response);
        }
        else {
            request.setAttribute( "connected", false );
            request.getRequestDispatcher("/vues/error.jsp").forward(request, response);
        }
    }
}