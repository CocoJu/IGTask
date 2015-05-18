package ru.cocojumbo.util;
import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.IntegerType;


/**
 * Created by ANK on 18.05.2015.
 */
public class AppMySQLDialect extends MySQLDialect {
    public AppMySQLDialect() {
        super();
        /**
         * Function to evaluate regexp in MySQL
         */
        registerFunction("regexp", new SQLFunctionTemplate(IntegerType.INSTANCE, "?1 REGEXP ?2"));
    }
}
