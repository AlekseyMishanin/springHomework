package lesson3.hibernate;

import lesson3.hibernate.entity.NotSimple;
import lesson3.hibernate.entity.NotSimpleWithAnnotation;
import lesson3.hibernate.entity.SimpleA;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AppSimpleHibernate {

    private static final EntityManagerFactory factory;

    static {
        final String name = "ENTERPRISE";
        factory = Persistence.createEntityManagerFactory(name);
    }

    public static void main(String[] args) {

//        final EntityManager entityManager = factory.createEntityManager();
        final EntityManager entityManager = myEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from " + NotSimple.class.getSimpleName()).executeUpdate();

        final NotSimple notSimple = new NotSimple();
        final String id = UUID.randomUUID().toString();
        notSimple.setId(id);
        entityManager.persist(notSimple);
        entityManager.getTransaction().commit();

        List<NotSimple> list = entityManager.createQuery("from " + NotSimple.class.getSimpleName(),NotSimple.class).getResultList();
        list.stream().forEach(a-> System.out.println(a.getId()));
        System.out.println(entityManager.find(NotSimple.class,"3"));

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(NotSimple.class,id));
        entityManager.getTransaction().commit();

        list = entityManager.createQuery("from " + NotSimple.class.getSimpleName(),NotSimple.class).getResultList();
        list.stream().forEach(a-> System.out.println(a.getId()));


//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<NotSimple> c = cb.createQuery(NotSimple.class);
//        Root<NotSimple> r = c.from(NotSimple.class);
//        c.select(r);
        entityManager.close();
    }

    private static EntityManagerFactory myEntityManagerFactory(){

        final HashMap<String,String> settings = new HashMap<>();
        settings.put(Environment.DRIVER,"org.mariadb.jdbc.Driver");
        settings.put(Environment.URL,"jdbc:mariadb://localhost:3306/test");
        settings.put(Environment.USER,"test");
        settings.put(Environment.PASS,"test");
        settings.put(Environment.DIALECT,"org.hibernate.dialect.MariaDB10Dialect");
        settings.put(Environment.HBM2DDL_AUTO,"update");
        settings.put(Environment.SHOW_SQL,"true");
        final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(settings).build();
        final MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(SimpleA.class);
        metadataSources.addAnnotatedClass(NotSimple.class);
        metadataSources.addAnnotatedClass(NotSimpleWithAnnotation.class);
        final Metadata metadata = metadataSources.getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }
}
