package ru.cj.db;

import ru.cj.db.hibernate.HibernateUtil;

/**
 * Created by df on 17.07.2015.
 */
public class DbManagerFactory {

    private DbManagerFactory(){};

    public static DbManager getDbManager(){
        return new DbManagerPersistance(HibernateUtil.getEm());
    };
}
