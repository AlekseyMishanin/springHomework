package lesson3;

import lesson3.dzspring.config.Config;
import lesson3.dzspring.dao.TaskDAO;
import lesson3.dzspring.interfaces.CommandDAO;
import lesson3.dzspring.model.Project;
import lesson3.dzspring.model.Task;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TestTaskDAO extends Assert {

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
                TaskDAO.class.getGenericInterfaces()) {
            if (type.getTypeName().contains("CommandDAO")) {
                flag = true;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void testExtAbstrDAO(){
        boolean flag = false;
        if (TaskDAO.class.getGenericSuperclass().getTypeName().contains("AbstractDAO")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    public void testPersist(){
        try {
            CommandDAO<Task> taskDAO = ctx.getBean("taskDAO", CommandDAO.class);

            Task task = new Task();
            task.setId(id);
            task.setName("testName");

            Project project = new Project();
            project.setId(UUID.randomUUID().toString());
            project.setName("testProject");

            task.setProject(project);

            taskDAO.persist(task);
        } catch (Exception e){
            fail("Very bad in taskDAO.persist()");
        }
        assertTrue(true);
    }

    public void testFind(){
        Task task = null;
        try {
            CommandDAO<Task> taskDAO = ctx.getBean("taskDAO", CommandDAO.class);
            task = taskDAO.find(id);
        } catch (Exception e){
            fail("Exception in taskDAO.find()");
        }
        if(task != null) {
            assertTrue(true);
        } else {
            fail("Null in taskDAO.find()");
        }
    }

    public void testFindAll(){
        List<Task> task = Collections.emptyList();
        try {
            CommandDAO<Task> taskDAO = ctx.getBean("taskDAO", CommandDAO.class);
            task = taskDAO.findAll();
        } catch (Exception e){
            fail("Exception in taskDAO.findAll()");
        }
        if(!task.isEmpty()) {
            assertTrue(true);
        } else {
            fail("Null in taskDAO.findAll()");
        }
    }

    public void testGetById(){
        Task task = null;
        try {
            CommandDAO<Task> taskDAO = ctx.getBean("taskDAO", CommandDAO.class);
            task = (taskDAO.getById(id));
        } catch (Exception e){
            fail("Exception in taskDAO.getById()");
        }
        if(task != null) {
            assertTrue(true);
        } else {
            fail("Null in taskDAO.getById()");
        }
    }

    public void testRemoveAll(){
        CommandDAO<Task> taskDAO = ctx.getBean("taskDAO", CommandDAO.class);
        try {
            taskDAO.removeAll();
        } catch (Exception e){
            fail("Exception in taskDAO.removeAll()");
        }
        if(taskDAO.findAll() == null || taskDAO.findAll().isEmpty()) {
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
