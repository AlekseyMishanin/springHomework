package lesson1.appcontext.common.notmainconfig.config;

import lesson1.appcontext.common.notmainconfig.service.WorkService;
import lesson1.appcontext.common.notmainconfig.service.WorkerA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFirst {

    @Bean
    public WorkService workerA(){
        return new WorkerA();
    }
}
