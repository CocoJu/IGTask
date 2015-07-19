package ru.cj.servlets;

import ru.cj.db.DbManagerFactory;
import ru.cj.db.map.Product;
import ru.cj.util.ParamChecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet{
    private Logger log = LoggerFactory.getLogger("SYSOUT");

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                        throws ServletException, IOException {
        log.info("Index Servlet is run!");

        ParamChecker checkParam = new ParamChecker(request);
        String category = checkParam.getParamIfExist("category");
        String name = checkParam.getParamIfExist("name");
        String priceFrom = checkParam.getParamIfExist("priceFrom");
        String priceOf = checkParam.getParamIfExist("priceOf");
        request.setAttribute("category", category);
        request.setAttribute("name", name);
        request.setAttribute("priceFrom", priceFrom);
        request.setAttribute("priceOf", priceOf);

        Float prFrom, prOf;
        prFrom = prOf = null;
        if(!priceFrom.equals(""))
            prFrom = Float.parseFloat(priceFrom);
        if(!priceOf.equals(""))
            prOf = Float.parseFloat(priceOf);

        List<Product> productList =
                DbManagerFactory.getDbManager()
                        .getProductsByConditions(category, name, prFrom, prOf);
        request.setAttribute("product_list", productList);

        for(Product product : productList) {
                log.info("Product name - " + product.getName().toString());
                log.info("Product price - " + product.getPrice().toString());
                log.info("Product category - " + product.getCat().getName());
                log.info("-----------");
        }

        request.setAttribute("context_path", request.getContextPath());

        RequestDispatcher rd =
                request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
        rd.forward(request,response);
    }
}

