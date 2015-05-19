package ru.cocojumbo.util;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by df on 19.05.2015.
 */
public class ParamChecker {
    private static HttpServletRequest req;
    public static void setRequest(HttpServletRequest request){
        req = request;
    }
    public static String showValueIfExist(String param)
                        throws UnsupportedEncodingException{
        if(req.getParameter(param) != null){
            if(!req.getParameter(param).equals(""))
                HelpLog.printToLog("value sring", StringEncoder.encode(req.getParameter(param)));
                HelpLog.printToLog("value return","value="+StringEncoder.encode(req.getParameter(param)));
                return "value="+"'"+StringEncoder.encode(req.getParameter(param))+"'";
        }
        return "";
    }
}
