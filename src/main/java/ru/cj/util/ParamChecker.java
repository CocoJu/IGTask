package ru.cj.util;

import javax.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;

public class ParamChecker {
    private final HttpServletRequest req;

    public ParamChecker(HttpServletRequest request) {
        req = request;
    }

    public String getParamIfExist(String param)
                        throws UnsupportedEncodingException {
        if(req.getParameter(param) != null){
            if(!req.getParameter(param).equals(""))
                return StringEncoder.encode(req.getParameter(param));
        }
        return "";
    }
}
