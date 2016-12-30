package ru.inno.training.servlets;

import org.apache.log4j.Logger;
import ru.inno.training.service.SessionAdminMap;
import ru.inno.training.service.SessionUserMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mikhail on 30/12/16.
 */
public class AdminLogout extends HttpServlet {
    private String message;
    private static Logger log = Logger.getLogger(RegistrationServlet.class.getName());
    public void init() throws ServletException {
        // Do required initialization
        message = "I am in logout";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionAdminMap.deleteSession(req.getSession().getId());
        resp.sendRedirect("/index.jsp");




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);


    }

    public void destroy () {

    }
}
