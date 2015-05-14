package ru.cocojumbo.servlet;

/**
 * Created by df on 13.05.2015.
 */

import ru.cocojumbo.db.CatEntity;
import ru.cocojumbo.db.HibernateUtil;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RootServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //resp.sendRedirect("index.jsp");


        resp.getOutputStream().write("Hello World.".getBytes());
    }
}

