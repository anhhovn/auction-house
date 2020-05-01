import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bank implements Runnable{
    public static final String BANK_IPADDRESS = "127.0.0.1";
    public static final int BANK_PORT = 4444;
    private PrintWriter out;
    private BufferedReader in;
    private ServerSocket listener;
    private Thread currentThread;
    private ExecutorService pool = Executors.newFixedThreadPool(4);
    private List<AgentController> agentContrs = new ArrayList<>();
    public Bank() throws IOException {
        listener = new ServerSocket(BANK_PORT);
        currentThread = new Thread(this);
        currentThread.start();
    }
    @Override
    public void run() {
                while(true){
                    try {
                        Socket client = listener.accept();
                        System.out.println("[BANK] Connected to Client");
                        AgentController ac = new AgentController(client);
                        agentContrs.add(ac);
                        pool.execute(ac);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
        }
    }
}
