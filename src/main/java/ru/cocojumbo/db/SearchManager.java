package ru.cocojumbo.db;

import ru.cocojumbo.util.HelpLog;
import ru.cocojumbo.util.StringEncoder;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by ANK on 16.05.2015.
 */
public class SearchManager {    
    private static String CONDITION_STRING = "";
    private static boolean AND_FLAG = false;
    public static final String SELECT_PROD_WITH_CAT = "SELECT * FROM prodwithcat ";

    public static void setField(String fieldName, String condition, String param)
                            throws UnsupportedEncodingException{
        if(param == null || param.equals("")) return;
        if(CONDITION_STRING.equals("")){
            CONDITION_STRING += "WHERE ";
        }
        if(AND_FLAG)
            CONDITION_STRING += " AND ";
        CONDITION_STRING +=  fieldName + " " + condition;
        AND_FLAG = true;
        CONDITION_STRING = CONDITION_STRING.replace(":?", StringEncoder.encode(param));
    }

    public static void clearConditionString(){
        CONDITION_STRING = "";
        AND_FLAG = false;
    }

    public static List<ProdwithcatEntity> returnProd (String category,
                  String nameProd,String priceFrom, String priceTo)
                                throws UnsupportedEncodingException{
        EntityManager em = HibernateUtil.getEm();
        setField("lower(catName)", "REGEXP '(^|[ ]){1}:?([ ]|$){1}'", category);
        setField("lower(name)", "REGEXP '(^|[ ]){1}:?([ ]|$){1}'", nameProd);
        setField("price", ">= :?", priceFrom);
        setField("price", "<= :?", priceTo);
        Query q = em.createNativeQuery(SELECT_PROD_WITH_CAT +
                        CONDITION_STRING, ProdwithcatEntity.class);
        HelpLog.printToLog("query string",SELECT_PROD_WITH_CAT + CONDITION_STRING);
        clearConditionString();
        return (List<ProdwithcatEntity>)q.getResultList();
    }
}
