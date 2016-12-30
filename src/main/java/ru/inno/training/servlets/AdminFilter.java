package ru.inno.training.servlets;

import ru.inno.training.service.AuthService;
import ru.inno.training.service.SessionAdminMap;
import ru.inno.training.service.SessionUserMap;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by mikhail on 30/12/16.
 */
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;

        if(SessionAdminMap.isSessionExist(httpRequest.getSession().getId())){
            chain.doFilter(request, response);

        }

        else{
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
