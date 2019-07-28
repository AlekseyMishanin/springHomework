package lesson1.appcontext.context.xml.notannotation;

import lesson1.appcontext.common.MessageProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppWithConstructor {
    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("lesson1/app-context-constructor.xml");
        context.refresh();
        MessageProvider provider1 = (MessageProvider)context.getBean("messageProvider");
        MessageProvider provider2 = (MessageProvider)context.getBean("provider");
        MessageProvider provider3 = (MessageProvider)context.getBean("constructorConfussion");
        MessageProvider provider4 = (MessageProvider)context.getBean("constructorNoConfussion");
        System.out.println("With constructor-arg value - " + provider1.getMessage());
        System.out.println("With c:message - " + provider2.getMessage());
        System.out.println("With constructor confussion - " + provider3.getMessage());
        System.out.println("With constructor not  confussion - " + provider4.getMessage());
        context.close();
    }
}
