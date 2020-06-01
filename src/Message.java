import java.io.Serializable;

public class Message implements Serializable {
    private String sender,receiver;
    private String mesInform;
    private String content;
    private boolean isFromAgent;
    public Message(String from, String to , boolean isFromAgent){
        sender = from;
        receiver = to;
        this.isFromAgent = isFromAgent;
        mesInform = "From : " + sender + "\n To : " + receiver;
    }

    public void messageContent(String content){
        this.content = content;
    }

}
