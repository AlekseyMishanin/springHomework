package lesson3.spring;

import lesson3.spring.config.Config;
import lesson3.spring.dao.SimpleDAO;
import lesson3.spring.model.Simple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;

public class App {

    public static void main(String[] args) {
        final ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        final SimpleDAO simpleDAO = ctx.getBean("simpleDAO", SimpleDAO.class);

        simpleDAO.removeAll();

        final Simple s1 = new Simple();
        s1.setId(UUID.randomUUID().toString());
        simpleDAO.persist(s1);

        final Simple s2 = new Simple();
        s2.setId(UUID.randomUUID().toString());
        simpleDAO.persist(s2);

        System.out.println(simpleDAO.findAll());
    }
}
