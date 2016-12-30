package ru.inno.training.servlets;

import org.apache.catalina.Session;
import org.apache.log4j.Logger;
import ru.inno.training.pojo.Users;
import ru.inno.training.service.AuthService;
import ru.inno.training.service.SessionUserMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mikhail on 28/12/16.
 */
public class AuthServlet extends HttpServlet {


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
        HttpSession a =  request.getSession();
        log.debug("HTTPSessiom{a}" + a.toString());



    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        request.getRequestDispatcher("/").forward(request,response);
//        response.sendRedirect("/");

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        log.info(AuthService.checkAuth(email, password));
        if (AuthService.checkAuth(email, password)){
            Users user;
            user = AuthService.getUserbyEmail("email");
            //user.setSession(req.getSession().getId());
            SessionUserMap.addUserSession(req.getSession().getId(), user);


//            req.getRequestDispatcher("/yourTrainings.jsp").forward(req,resp);
            resp.sendRedirect("/yourTrainings.jsp");
        }
        else{
            log.info("AuthServlet else statement");
            req.setAttribute("errorMessage", "email or password is incorect, try again");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }
    }
    public void destroy () {
    }
}

