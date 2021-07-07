package lesson3;

import lesson3.dzspring.config.Config;
import lesson3.dzspring.dao.UserDAO;
import lesson3.dzspring.interfaces.CommandDAO;
import lesson3.dzspring.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TestUserDAO extends Assert {

    private static ApplicationContext ctx;
    private static String id;

    @BeforeClass
    public static void setUp() {
        ctx = new AnnotationConfigApplicationContext(Config.class);
        id = UUID.randomUUID().toString();
    }

    @Test
    public void testImplAnnotation(){
        boolean flag = false;
        for (Type type:
                UserDAO.class.getGenericInterfaces()) {
            if (type.getTypeName().contains("CommandDAO")) {
                flag = true;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void testExtAbstrDAO(){
        boolean flag = false;
        if (UserDAO.class.getGenericSuperclass().getTypeName().contains("AbstractDAO")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    public void testPersist(){
        try {
            CommandDAO<User> userDAO = ctx.getBean("userDAO", CommandDAO.class);

            User user = new User();
            user.setId(id);
            user.setLogin("testName");

            userDAO.persist(user);
        } catch (Exception e){
            fail("Very bad in userDAO.persist()");
        }
        assertTrue(true);
    }

    public void testFind(){
        User user = null;
        try {
            CommandDAO<User> userDAO = ctx.getBean("userDAO", CommandDAO.class);
            user = userDAO.find(id);
        } catch (Exception e){
            fail("Exception in userDAO.find()");
        }
        if(user != null) {
            assertTrue(true);
        } else {
            fail("Null in userDAO.find()");
        }
    }

    public void testFindAll(){
        List<User> user = Collections.emptyList();
        try {
            CommandDAO<User> userDAO = ctx.getBean("userDAO", CommandDAO.class);
            user = userDAO.findAll();
        } catch (Exception e){
            fail("Exception in userDAO.findAll()");
        }
        if(!user.isEmpty()) {
            assertTrue(true);
        } else {
            fail("Null in userDAO.findAll()");
        }
    }

    public void testGetById(){
        User user = null;
        try {
            CommandDAO<User> userDAO = ctx.getBean("userDAO", CommandDAO.class);
            user = (userDAO.getById(id));
        } catch (Exception e){
            fail("Exception in userDAO.getById()");
        }
        if(user != null) {
            assertTrue(true);
        } else {
            fail("Null in userDAO.getById()");
        }
    }

    public void testRemoveAll(){
        CommandDAO<User> userDAO = ctx.getBean("userDAO", CommandDAO.class);
        try {
            userDAO.removeAll();
        } catch (Exception e){
            fail("Exception in userDAO.removeAll()");
        }
        if(userDAO.findAll() == null || userDAO.findAll().isEmpty()) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    @Test
    public void testOrder(){
        testPersist();
        testFind();
        testFindAll();
        testGetById();
        testRemoveAll();
    }
}
