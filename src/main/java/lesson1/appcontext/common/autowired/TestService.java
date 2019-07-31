package lesson1.appcontext.common.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("lesson1.appcontext.common.autowired")
public class TestService {

    @Autowired(required = true)
    private BetaService betaService;

    @Autowired(required = true)
    private AlphaService alphaService;

    @Autowired(required = true)
    private OmegaService omegaService;

    @Autowired(required = false)
    private BestService bestService;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestService.class);
        BetaService betaService = context.getBean("betaService", BetaService.class);
        AlphaService alphaService = context.getBean("alphaService", AlphaService.class);
        OmegaService omegaService = context.getBean("omegaService", OmegaService.class);
    }
}
