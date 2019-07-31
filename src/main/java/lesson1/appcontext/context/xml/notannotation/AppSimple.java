package lesson1.appcontext.context.xml.notannotation;

import lesson1.appcontext.common.MessageReader;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppSimple {

    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("lesson1/app-context-xml.xml");
        context.refresh();
        MessageReader messageReader = context.getBean("renderer", MessageReader.class);
        messageReader.render();
        context.close();
    }
}
