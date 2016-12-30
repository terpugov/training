package ru.inno.training.servlets;
import org.apache.log4j.Logger;
import ru.inno.training.pojo.Users;
import ru.inno.training.service.RegistrationService;
import ru.inno.training.service.SessionUserMap;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Created by mikhail on 27/12/16.
 */
public class RegistrationServlet extends HttpServlet {

    private static Logger log = Logger.getLogger(RegistrationServlet.class.getName());
    private String message;


    public void init() throws ServletException {
        // Do required initialization
        message = "I am in registration";
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        log.debug("in DO_GET");
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        request.getRequestDispatcher("/").forward(request,response);
//        response.sendRedirect("/");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        req.setAttribute("name", name);
        req.setAttribute("surname", surname);
        req.setAttribute("email", email);



        RegistrationService registrationService = new RegistrationService();
        if (password.equals("") || password.length() < 6){
            req.setAttribute("errorMessage", "password should be take more than 6 symbols");
            req.getRequestDispatcher("/registration.jsp").forward(req,resp);
        }
        else if(!registrationService.validateEmail(email)){
            req.setAttribute("errorMessage", "wrong email");
            req.getRequestDispatcher("/registration.jsp").forward(req,resp);
        }
        else if (registrationService.checkAvailiableEmail(email)){
            log.info("I am in checkAvailiable{ }" + registrationService.checkAvailiableEmail(email) + email);
            registrationService.addUserToDB(name, surname, email,false , password);
            Users usr = registrationService.createInstanceUser(name, surname, email, password, req.getSession().getId(),false);
            SessionUserMap.addUserSession(req.getSession().getId(), usr);
            resp.sendRedirect("/yourTrainings.jsp");

        }
        else{
            log.info("I am in else{ } ");
            req.setAttribute("errorMessage", "user existed");
            req.getRequestDispatcher("/registration.jsp").forward(req,resp);
        }
    }
    public void destroy () {

    }
}
