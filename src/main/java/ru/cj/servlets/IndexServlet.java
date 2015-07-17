package ru.cj.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.cj.db.DbManagerFactory;
import ru.cj.db.map.Product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

public class IndexServlet extends HttpServlet{

    private Logger log = LoggerFactory.getLogger("SYSOUT");

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response){

        log.info("Index Servlet is run!");

        List<Product> productList = DbManagerFactory.getDbManager()
                        .getProductsByConditions("epson", 8000.0F, 9000.0F);

        for(Product product : productList){
                log.info("Product name - " + product.getName().toString());
                log.info("Product price - " + product.getPrice().toString());
                log.info("Product category - " + product.getCat().getName());
                log.info("-----------");
        }

    }
}

