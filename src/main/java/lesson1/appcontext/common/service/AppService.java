package lesson1.appcontext.common.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("lesson1.appcontext.common.service")
public class AppService {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppService.class);
        TestService testService = context.getBean("testService", TestService.class);
        BetaService betaService = context.getBean("betaService", BetaService.class);
        MegaService megaService = context.getBean("megaService", MegaService.class);
        OmegaService omegaService = context.getBean("omegaService", OmegaService.class);

        testService.getBestService().getBest();
        betaService.getBestService().getBest();
        megaService.getBestService().getBest();
        omegaService.getBestService().getBest();
    }
}
