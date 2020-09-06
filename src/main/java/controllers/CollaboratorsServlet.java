package controllers;
import models.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CollaboratorsServlet extends HttpServlet {
    UserService userService = new UserService();
    public CollaboratorsServlet() {
            super();
        }
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            HttpSession session =request.getSession();
            User user =(User)session.getAttribute("user");

            if (user!=null) {
               if (session.getAttribute("collaborators")==null){
                   List<User>collaborators=userService.getCollborattors(user.getUsername());
                   session.setAttribute("collaborators",collaborators);
               }else{
                   Optional<String> collaboratorIdOpt = Optional.ofNullable(request.getParameter("id"));
                   collaboratorIdOpt.ifPresent((collboratorId)->{
                       Long id =Long.parseLong(collboratorId);
                       userService.setCollborattors((List<User>)session.getAttribute("collaborators"));
                       userService.deletColaborator(id);
                       List<User> collaborators=userService.getCollborattors(user.getUsername());
                       session.setAttribute("collaborators",collaborators);
                   });
               }

                request.getRequestDispatcher("/vues/collaborators.jsp").forward(request, response);
            }
            else {
                request.setAttribute( "connected", false );
                request.getRequestDispatcher("/vues/error.jsp").forward(request, response);
            }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session =request.getSession();
        User user =(User)session.getAttribute("user");
        List<User> collaborators=(List<User>)session.getAttribute("collaborators");

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String post = request.getParameter("post");
        Integer age = Integer.parseInt(request.getParameter("age"));
        Integer holidaysCounter =Integer.parseInt(request.getParameter("holidaysCounter"));
        Long id = collaborators.get(collaborators.size()-1).getId()+1;
        User collaborator = new User(id,nom,prenom,post,age,holidaysCounter);

        userService.setCollborattors(collaborators);
        userService.addCollaborateur(collaborator);
        collaborators=userService.getCollborattors(user.getUsername());
        session.setAttribute("collaborators",collaborators);

        request.getRequestDispatcher("/vues/collaborators.jsp").forward(request, response);
    }
}
