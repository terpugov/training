package ru.inno.training.servlets;

import ru.inno.training.pojo.Users;
import ru.inno.training.service.AdminService;
import ru.inno.training.service.RegistrationService;
import ru.inno.training.service.SessionUserMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mikhail on 30/12/16.
 */
public class AdminServlet extends HttpServlet {

    public void init() throws ServletException {
        // Do required initialization
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        request.getRequestDispatcher("/").forward(request,response);
//        response.sendRedirect("/");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String complexity = req.getParameter("complexity");
        String type = req.getParameter("type");
        AdminService.addExcercise(name, description, complexity, type);
//        resp.sendRedirect("/yourTrainings.jsp");
        resp.sendRedirect("/admintrainings.jsp");
    }
    public void destroy () {

    }
}
