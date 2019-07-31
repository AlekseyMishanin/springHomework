package lesson1.appcontext.context.javaclass.withimportresource;

import lesson1.appcontext.common.MessageReader;
import lesson1.appcontext.javaconfig.MyImportResource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyImportResource.class);
        MessageReader reader = (MessageReader)context.getBean("renderer",MessageReader.class);
        reader.render();
    }
}
