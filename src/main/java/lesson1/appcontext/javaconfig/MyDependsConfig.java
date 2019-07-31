package lesson1.appcontext.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("lesson1.appcontext.common.depends")
public class MyDependsConfig {
}
