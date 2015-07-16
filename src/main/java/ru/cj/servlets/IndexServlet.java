package ru.cj.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet{

    private Logger log = LoggerFactory.getLogger("SYSOUT");

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response){
        log.info("Index Servlet is run!");
    }
}

