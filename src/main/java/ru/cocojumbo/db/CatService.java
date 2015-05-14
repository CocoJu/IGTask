package ru.cocojumbo.db;

import javax.persistence.EntityManager;

/**
 * Created by ANK on 14.05.2015.
 */
public class CatService {
    public static void addCat(String name){
        CatEntity category = new CatEntity();
        category.setName(name);
        EntityManager em = HibernateUtil.getEm();
        em.getTransaction().begin();
        em.merge(category);
        em.getTransaction().commit();
    }

}
