package lesson1.appcontext.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("providerConfigurable")
public class ConfigurableMessageProvider implements MessageProvider {

    private String[] message;
    private int intValue;

    @Autowired
    public ConfigurableMessageProvider(String message, String message1, @Value("final value") String message2) {
        System.out.println("ConfigurableMessageProvider(String message, String message1, @Value(\"final value\") String message2) called");
        this.message = new String[3];
        this.message[0] = message;
        this.message[1] = message1;
        this.message[2] = message2;
    }

    public ConfigurableMessageProvider(String message){
        System.out.println("ConfigurableMessageProvider(String message) called");
        this.message = new String[1];
        this.message[0] = message;
    }

    public ConfigurableMessageProvider(int intValue){
        System.out.println("ConfigurableMessageProvider(int intValue) called");
        this.intValue = intValue;
    }

    public String getMessage() {
        return Arrays.toString(message) + " " + intValue;
    }
}
