package lesson1.appcontext.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("renderer")
@Qualifier("mesread")
public class StandartMessageReader implements MessageReader {

    private MessageProvider messageProvider;

    public void render() {

        if (messageProvider == null) {
            throw new RuntimeException("You must set the"
            + " property messageProvider of class:"
            + StandartMessageReader.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

   @Autowired
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
