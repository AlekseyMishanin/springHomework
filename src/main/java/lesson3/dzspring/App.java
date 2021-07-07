package lesson3.dzspring;

import lesson3.dzspring.config.Config;
import lesson3.dzspring.dao.ProjectDAO;
import lesson3.dzspring.dao.TaskDAO;
import lesson3.dzspring.dao.UserDAO;
import lesson3.dzspring.enums.Status;
import lesson3.dzspring.interfaces.CommandDAO;
import lesson3.dzspring.model.Project;
import lesson3.dzspring.model.Task;
import lesson3.dzspring.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;

public class App {

    public static void main(String[] args) {

        final ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        CommandDAO<User> userDAO = ctx.getBean("userDAO", CommandDAO.class);

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setLogin("login");
        user.setPassword("paaass");

        userDAO.persist(user);
        userDAO.findAll().stream().forEach(a-> System.out.println(a.getLogin()));
        CommandDAO<Project> projectDAO = ctx.getBean("projectDAO", CommandDAO.class);
        Project project = new Project();
        project.setId(UUID.randomUUID().toString());
        project.setName("prodName");
        project.setStatus(Status.COMPLETED);
        projectDAO.persist(project);
        projectDAO.getSortedByName().stream().forEach(a-> System.out.println(a.getName()));

    }
}
