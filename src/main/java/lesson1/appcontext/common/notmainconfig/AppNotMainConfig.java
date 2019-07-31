package lesson1.appcontext.common.notmainconfig;

import lesson1.appcontext.common.notmainconfig.service.WorkService;
import lesson1.appcontext.common.notmainconfig.service.WorkerA;
import lesson1.appcontext.common.notmainconfig.service.WorkerB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppNotMainConfig {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("lesson1.appcontext.common.notmainconfig.config");
        context.refresh();
        WorkService w1 = context.getBean("workerA", WorkerA.class);
        WorkService w2 = context.getBean("workerB", WorkerB.class);
        w1.doAnyThing();
        w2.doAnyThing();
    }
}
