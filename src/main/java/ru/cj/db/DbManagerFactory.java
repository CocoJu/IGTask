package ru.cj.db;

import ru.cj.db.hibernate.HibernateUtil;

public class DbManagerFactory {

    private DbManagerFactory(){};

    public static DbManager getDbManager(){
        return new DbManagerPersistence(HibernateUtil.getEm());
    };
}
