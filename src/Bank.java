import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

public class Bank implements Runnable{
    private static int port;
    private static String bankName;
    private final boolean isAgent = false;
    private final boolean isAuctionHouse = false;
    private ServerSocket serverSocket;
    public Bank() throws IOException {
        openServer();
    }

    @Override
    public void run() {
        while(true){
            try {
                Socket client = serverSocket.accept();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * open Server for clients
     * @throws IOException
     */
    private void openServer() throws IOException {
        serverSocket = new ServerSocket(port);
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("Server is on " + inetAddress.getHostAddress());

    }

    /**
     * get bank Name
     * @return
     */
    public String getName(){
        return bankName;
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
     * get argument inputs from bank server
     * input must be in order : server port, bank name
     * @param args
     */
    public static void main(String[] args){
        if(args.length != 2){
            System.err.println("Incorrect number of arguments. \n 1. Port Number \n 2. Bank Name");
            System.exit(0);
        }
        port = Integer.parseInt(args[0]);
        bankName = args[1];
        validateName(bankName);
    }

    private static void validateName(String name){
        if(Pattern.compile("[0-9]").matcher(name).matches()){
            throw new IllegalArgumentException("Invalid name. Name can't contain numbers");
        }
    }

}
