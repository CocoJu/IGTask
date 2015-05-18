package ru.cocojumbo.db;

//import org.hibernate.criterion.CriteriaQuery;
import ru.cocojumbo.util.HelpLog;
import ru.cocojumbo.util.StringEncoder;

import javax.persistence.Query;
import javax.persistence.Embeddable;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by ANK on 16.05.2015.
 */
public class SearchManager {

    private static String conditionString = "";
    private static boolean andFlag = false;

    public static final String selectProdWithCat = "SELECT c FROM ProdwithcatEntity c ";
    public static void setField(String fieldName, String condition, String param)
                            throws UnsupportedEncodingException{
        if(param == null || param.equals(""))
            return;
        if(conditionString.equals("")){
            conditionString += "WHERE ";
        }
        if(andFlag)
            conditionString += " AND ";
        conditionString +=  fieldName + " " + condition;
        andFlag = true;
        conditionString = conditionString.replace(":?", StringEncoder.encode(param));
    }
    public static void clearConditionString(){
        conditionString = "";
        andFlag = false;
    }
    public static List<ProdwithcatEntity> returnProd (String category,
                  String nameProd,String priceFrom, String PriceTo)
                                throws UnsupportedEncodingException{
        EntityManager em = HibernateUtil.getEm();
        setField("catName", "like '(^|[ ]){1}:?([ ]|$){1}')", category);
        //setField("c.name", "REGEXP '(^|[ ]){1}:?([ ]|$){1}'", nameProd);
        HelpLog.pringToLog("query", selectProdWithCat + conditionString);
        Query q = em.createQuery(selectProdWithCat + conditionString);
        clearConditionString();
        return q.getResultList();
    }
}
