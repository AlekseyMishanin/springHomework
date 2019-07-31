package lesson1.appcontext.common.depends;

import lesson1.appcontext.javaconfig.MyDependsConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppDepends {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyDependsConfig.class);
        Singer singer = context.getBean("singer", Singer.class);
        singer.sing();
    }
}
