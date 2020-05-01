import java.io.*;
import java.net.Socket;

public class Agent {
    public static void main(String [] args) throws IOException {
        Socket socket = new Socket(Bank.BANK_IPADDRESS,Bank.BANK_PORT);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(input.readLine());
    }


}
