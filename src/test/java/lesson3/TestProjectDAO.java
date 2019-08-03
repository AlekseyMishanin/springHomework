package lesson3;

import lesson3.dzspring.config.Config;
import lesson3.dzspring.dao.ProjectDAO;
import lesson3.dzspring.interfaces.CommandDAO;
import lesson3.dzspring.model.Project;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TestProjectDAO extends Assert {

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
                ProjectDAO.class.getGenericInterfaces()) {
            if (type.getTypeName().contains("CommandDAO")) {
                flag = true;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void testExtAbstrDAO(){
        boolean flag = false;
        if (ProjectDAO.class.getGenericSuperclass().getTypeName().contains("AbstractDAO")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    public void testPersist(){
        try {
            CommandDAO<Project> projectDAO = ctx.getBean("projectDAO", CommandDAO.class);

            Project project = new Project();
            project.setId(id);
            project.setName("testName");

            projectDAO.persist(project);
        } catch (Exception e){
            fail("Very bad in projectDAO.persist()");
        }
        assertTrue(true);
    }

    public void testFind(){
        Project project = null;
        try {
            CommandDAO<Project> projectDAO = ctx.getBean("projectDAO", CommandDAO.class);
            project = projectDAO.find(id);
        } catch (Exception e){
            fail("Exception in projectDAO.find()");
        }
        if(project != null) {
            assertTrue(true);
        } else {
            fail("Null in projectDAO.find()");
        }
    }

    public void testFindAll(){
        List<Project> project = Collections.emptyList();
        try {
            CommandDAO<Project> projectDAO = ctx.getBean("projectDAO", CommandDAO.class);
            project = projectDAO.findAll();
        } catch (Exception e){
            fail("Exception in projectDAO.findAll()");
        }
        if(!project.isEmpty()) {
            assertTrue(true);
        } else {
            fail("Null in projectDAO.findAll()");
        }
    }

    public void testGetById(){
        Project project = null;
        try {
            CommandDAO<Project> projectDAO = ctx.getBean("projectDAO", CommandDAO.class);
            project = (projectDAO.getById(id));
        } catch (Exception e){
            fail("Exception in projectDAO.getById()");
        }
        if(project != null) {
            assertTrue(true);
        } else {
            fail("Null in projectDAO.getById()");
        }
    }

    public void testRemoveAll(){
        CommandDAO<Project> projectDAO = ctx.getBean("projectDAO", CommandDAO.class);
        try {
            projectDAO.removeAll();
        } catch (Exception e){
            fail("Exception in projectDAO.removeAll()");
        }
        if(projectDAO.findAll() == null || projectDAO.findAll().isEmpty()) {
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
