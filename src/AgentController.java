import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AgentController implements Runnable{
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    public AgentController(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(),true);
    }
    @Override
    public void run() {
        while(true){

        }
    }
}
