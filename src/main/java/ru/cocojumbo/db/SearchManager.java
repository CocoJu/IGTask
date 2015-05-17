package ru.cocojumbo.db;

//import org.hibernate.criterion.CriteriaQuery;
import ru.cocojumbo.util.HelpLog;
import ru.cocojumbo.util.StringEncoder;

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
    public static List<ProdwithcatEntity> returnProd (String category,
                  String nameProd,String priceFrom, String PriceTo)
                                throws UnsupportedEncodingException{
        EntityManager em = HibernateUtil.getEm();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProdwithcatEntity> query = cb.createQuery(ProdwithcatEntity.class);
        Root<ProdwithcatEntity> rootProdWithCat = query.from(ProdwithcatEntity.class);
        CriteriaQuery<ProdwithcatEntity> cq = query.select(rootProdWithCat);
        /*String printers = "принтеры";
            cq.where(cb.like(rootProdWithCat.get("catName"), printers));
                   // "%" + StringEncoder.encode(category) + "%"));*/

        if(nameProd != null){
            cq.where(cb.like(rootProdWithCat.get("name"),
                    "%" + StringEncoder.encode(nameProd) + "%"));}
        //HelpLog.pringToLog("system encoding", System.getProperty("file.encoding"));
        //HelpLog.pringToLog("printers var", printers);
        TypedQuery<ProdwithcatEntity> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }
}
