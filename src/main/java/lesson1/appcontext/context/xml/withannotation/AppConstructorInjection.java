package lesson1.appcontext.context.xml.withannotation;

import lesson1.appcontext.common.ConfigurableMessageProvider;
import lesson1.appcontext.common.MessageProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppConstructorInjection {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("lesson1/app-context-annotation.xml");
        context.refresh();

        MessageProvider messageProvider = context.getBean("providerConfigurable", ConfigurableMessageProvider.class);
        System.out.println(messageProvider.getMessage());
        context.close();
    }
}
