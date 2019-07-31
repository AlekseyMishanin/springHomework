package lesson1.appcontext.context.xml.withannotation;

import lesson1.appcontext.common.inspiration.Singer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppFieldInjection {

    public static void main(String[] args) {
        GenericXmlApplicationContext context= new GenericXmlApplicationContext();
        context.load("lesson1/app-context-field.xml");
        context.refresh();

        Singer singer = context.getBean(Singer.class);
        singer.sing();
        context.close();
    }
}
