package lesson1.appcontext.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "lesson1.appcontext.common")
@Configuration
public class WithComponentScan {
}
