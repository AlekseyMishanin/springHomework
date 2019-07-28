package lesson1.appcontext.javaconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = "app-context-xml.xml")
@Configuration
public class MyImportResource {
}
