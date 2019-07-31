package lesson1.appcontext.common.notmainconfig.config;

import lesson1.appcontext.common.notmainconfig.service.WorkService;
import lesson1.appcontext.common.notmainconfig.service.WorkerB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSecond {

    @Bean
    public WorkService workerB(){
        return new WorkerB();
    }
}
