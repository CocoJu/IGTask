/*
package ru.cj.filters;
import ru.cj.Util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ContentFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;


            chain.doFilter(request, response);
            return;
        }else{
            HttpSession session = req.getSession(false);
            if(session != null && Util.getCookieByName(req, "JSESSIONID")!= null) {
                if (session.getAttribute("user") != null
                        && session.getAttribute("role") != null) {
                    chain.doFilter(request, response);
                    return;
                }
            }
            res.sendRedirect(Util.APP_URL+"/login.jsp");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
*/
