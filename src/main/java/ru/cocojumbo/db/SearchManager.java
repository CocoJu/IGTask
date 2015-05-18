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
        conditionString = conditionString.replace("?", StringEncoder.encode(param));
    }
    public static void clearConditionString(){
        conditionString = "";
        andFlag = false;
    }
    public static List<ProdwithcatEntity> returnProd (String category,
                  String nameProd,String priceFrom, String PriceTo)
                                throws UnsupportedEncodingException{
        EntityManager em = HibernateUtil.getEm();
        setField("c.catName", "LIKE '%?%'", category);
        setField("c.name", "LIKE '%?%'", nameProd);
        HelpLog.pringToLog("query",selectProdWithCat + conditionString);
        Query q =  em.createQuery(selectProdWithCat + conditionString);
        clearConditionString();
        /*CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProdwithcatEntity> query = cb.createQuery(ProdwithcatEntity.class);
        Root<ProdwithcatEntity> rootProdWithCat = query.from(ProdwithcatEntity.class);
        CriteriaQuery<ProdwithcatEntity> cq = query.select(rootProdWithCat);
        Predicate pre1=null;
        Predicate pre2=null;
        if(category != null && !category.equals(""))
            pre1 = cb.like(rootProdWithCat.get("catName"),
                    "%" + StringEncoder.encode(category) + "%");
            cq.where(cb.like(rootProdWithCat.get("catName"),
                    "%" + StringEncoder.encode(category) + "%"));
        if(nameProd != null && !nameProd.equals(""))
            cq.where(cb.like(rootProdWithCat.get("name"),
                            "%" + StringEncoder.encode(nameProd) + "%"));
            pre2 = cb.like(rootProdWithCat.get("name"),
                    "%" + StringEncoder.encode(nameProd) + "%");
        String printers = "принтеры";
            cq.where(cb.like(rootProdWithCat.get("catName"), printers));
                   // "%" + StringEncoder.encode(category) + "%"));
*/

        //HelpLog.pringToLog("system encoding", System.getProperty("file.encoding"));
        //HelpLog.pringToLog("printers var", printers);
        //TypedQuery<ProdwithcatEntity> typedQuery = em.createQuery(query);
        return q.getResultList();
        //return null;
    }
}
