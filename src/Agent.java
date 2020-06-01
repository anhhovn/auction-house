import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Agent implements Runnable{
    private final boolean isAgent = true;
    private final boolean isAuctionHouse = false;
    private static String ip;
    private static int port;
    private static String agentName;
    private Socket socket;
    private ObjectInputStream receiver;
    private ObjectOutputStream sender;

    public Agent() throws IOException {
        establishConnection();
    }

    /**
     * connect to server using port and ip inputs
     * @throws IOException
     */
    private void establishConnection() throws IOException {
        socket = new Socket(ip,port);
        InetAddress inetAddress= InetAddress.getLocalHost();
        if(!socket.isClosed()){
            System.out.println("You're on " + inetAddress.getHostAddress() +
                    "\n Successfully connected to Server");
        }
    }

    @Override
    public void run() {

        try {
            receiver = new ObjectInputStream(socket.getInputStream());
            sender = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                Message input = (Message) receiver.readObject();
                System.out.println("What do you want to send to Server ?");
                Scanner scanner = new Scanner(System.in);
                String messageContent = scanner.nextLine();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * get agent name
     * @return
     */

    public String getName(){
        return agentName;
    }

    /**
     * check who is talking
     * @return
     */
    public boolean isAgent(){
        return isAgent;
    }

    public boolean isAuctionHouse(){
        return isAuctionHouse;
    }


    /**
     * main method
     * get argument inputs from agent client
     * input must be in order : server ip, server port, agent name
     * valid input tests
     * @param args
     */
    public static void main(String [] args){
        if(args.length != 3){
            System.err.println("Incorrect number of arguments.\n 1. IP Address \n 2. Port Number \n 3. Agent Name");
            System.exit(0);
        }
        ip = args[0];
        port = Integer.parseInt(args[1]);
        agentName = args[2];
        isValidInput(ip,agentName);
    }

    /**
     *
     * @param ip
     * @param agentName
     */
    private static void isValidInput(String ip, String agentName){
        if(!ValidateIPv4.isValidIpv4Address(ip) && !Pattern.compile("[0-9]").matcher(agentName).matches()){
            throw new IllegalArgumentException("Invalid IP Address OR Name can't contain numbers");
        }
    }
}
