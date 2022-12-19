package com.example.web;

import com.example.dao.DeputyDao;
import com.example.model.Deputy;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/do/*"})
public class ControllerServlet extends HttpServlet {
    boolean isLogged = false;
    boolean isErrorLogin = false;
    AtomicReference<DeputyDao> dao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = (AtomicReference<DeputyDao>) config.getServletContext().getAttribute("dao");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            pathInfo = "/";
        }
        try {
                switch (pathInfo) {
                    case "/login":
                        login(request, response);
                        break;
                    case "/logout":
                        logout(request, response);
                        break;
                    case "/checkTable":
                        checkTable(request, response);
                        break;
                    case "/back":
                        greating(request, response);
                        break;
                    default:
                        greating(request, response);
                        break;
                }

        } catch (RuntimeException ex) {
            ex.printStackTrace();
            //error.jsp
        }

    }

    protected void greating(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isLogged){
            Deputy deputy = (Deputy) request.getAttribute("deputy");
            request.setAttribute("deputy", deputy);
            request.getRequestDispatcher("/user_greating.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        isLogged = false;
        request.getSession().removeAttribute("deputy");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void checkTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(isLogged){
            List<Deputy> deputies = dao.get().getDeputies();
            request.setAttribute("deputies", deputies);
            request.getRequestDispatcher("/verhovnaRadaTable.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }


    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!isLogged) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            Deputy deputy = dao.get().getDeputyByLoginAndPassword(login, password);
            if (deputy.getId() == -1) {
                isErrorLogin = true;
                request.getSession().setAttribute("isErrorLogin", isErrorLogin);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                isLogged = true;
                isErrorLogin = false;
                request.getSession().setAttribute("isErrorLogin", isErrorLogin);
                request.getSession().setAttribute("deputy", deputy);
                greating(request, response);
            }
        }
        else{
            greating(request, response);
        }

    }





    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }



}
