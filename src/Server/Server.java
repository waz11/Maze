package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private IServerStrategy serverStrategy;
    private int waiting;
    private volatile boolean stop;

    public Server(int port,int waiting, IServerStrategy serverStrategy) {
        this.port = port;
        this.serverStrategy = serverStrategy;
        this.waiting = waiting;
    }


    public void start()
    {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(1000);

            while (!stop)
            {
                try {
                    Socket clientSocket = serverSocket.accept();

                    InputStream inFromClient = clientSocket.getInputStream();
                    OutputStream outToClient = clientSocket.getOutputStream();

                    this.serverStrategy.serverStrategy(inFromClient, outToClient);

                    inFromClient.close();
                    outToClient.close();
                    clientSocket.close();
                }
                catch (IOException e) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop()
    {
        System.out.println("The server has stopped!");
        this.stop = true;
    }

}
