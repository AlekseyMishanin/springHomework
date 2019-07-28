package lesson1.appcontext.context.javaclass.withcomponentscan;

import lesson1.appcontext.common.MessageReader;
import lesson1.appcontext.javaconfig.Simple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Simple.class);
        MessageReader reader = (MessageReader)context.getBean("reader",MessageReader.class);
        reader.render();

    }
}
