package lesson1.appcontext.common.qualifier;

import lesson1.appcontext.common.qualifier.config.JavaConfig;
import lesson1.appcontext.common.qualifier.service.TestService;
import lesson1.appcontext.common.qualifier.service.TestServiceXML;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppQualifier {

    public static void main(String[] args) {

        final ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        TestService testService = ctx.getBean("testService", TestService.class);
        System.out.println(testService.getTestClassA());
        System.out.println(testService.getTestClassB());

        final GenericXmlApplicationContext ctxXml = new GenericXmlApplicationContext();
        ctxXml.load("lesson1/app-context-qualifier.xml");
        ctxXml.refresh();

        TestServiceXML testServiceXml = ctxXml.getBean("testServiceXML", TestServiceXML.class);
        System.out.println(testServiceXml.getTestClassA());
        System.out.println(testServiceXml.getTestClassB());

        ctxXml.close();
    }
}
