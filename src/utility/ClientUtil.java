package utility;

import server.model.entities.Message;

public class ClientUtil {
    public static String formatMessage(Message msg){
        return "[" + msg.getTime() + "]: " + msg.getLogin() + " :>> " + msg.getMessage();
    }
}
