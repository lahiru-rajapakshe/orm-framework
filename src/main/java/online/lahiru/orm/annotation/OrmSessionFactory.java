package online.lahiru.orm.annotation;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class OrmSessionFactory {

    private final List<Class<?>> entityClassList = new ArrayList<>();
    private Connection connection;

    public OrmSessionFactory addAnnotatedClass(Class<?> entityClass){
        if (entityClass.getDeclaredAnnotation(Entity.class) == null){
            throw new RuntimeException("Invalid entity class");
        }
        entityClassList.add(entityClass);
        return this;
    }

    public OrmSessionFactory setConnection(Connection connection){
        this.connection = connection;
        return this;
    }


}
