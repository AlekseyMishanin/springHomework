package lesson1.appcontext.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("provider")
@Qualifier("hellopro")
public class HelloWorldMessageProvider implements MessageProvider {

    public String getMessage() {
        return "Hello world!";
    }
}
