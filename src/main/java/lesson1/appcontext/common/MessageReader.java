package lesson1.appcontext.common;

public interface MessageReader {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
