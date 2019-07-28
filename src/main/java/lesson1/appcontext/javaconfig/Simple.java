package lesson1.appcontext.javaconfig;

import lesson1.appcontext.common.HelloWorldMessageProvider;
import lesson1.appcontext.common.MessageProvider;
import lesson1.appcontext.common.MessageReader;
import lesson1.appcontext.common.StandartMessageReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Simple {

    @Bean
    public MessageProvider provider(){
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageReader reader (){
        MessageReader rdr = new StandartMessageReader();
        rdr.setMessageProvider(provider());
        return rdr;
    }
}
