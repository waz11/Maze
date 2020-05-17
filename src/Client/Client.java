package Client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private IClientStrategy clientStrategy;
    private int serverPort;
    private InetAddress serverIP;

    public Client(IClientStrategy clientStrategy, int serverPort, InetAddress serverIP) {
        this.clientStrategy = clientStrategy;
        this.serverPort = serverPort;
        this.serverIP = serverIP;
    }

    public void start(){
        try{
            Socket theServer = new Socket(serverIP, serverPort);
            clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
