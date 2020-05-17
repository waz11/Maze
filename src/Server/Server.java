package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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


    public void runServer()
    {
        //Lielle: Need to change the code here so it'll use thread pool

        try {
            ExecutorService executor = Executors.newFixedThreadPool(2); //Lielle: change that later
            ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(waiting);

            while (!stop)
            {
                try {
                    Socket clientSocket = serverSocket.accept();
                    InputStream inFromClient = clientSocket.getInputStream();
                    OutputStream outToClient = clientSocket.getOutputStream();
                    //Lielle: Not sure I did this part right-
                    pool.execute(new Thread(() -> {
                        this.serverStrategy.serverStrategy(inFromClient, outToClient);
                    }));
                    inFromClient.close();
                    outToClient.close();
                    clientSocket.close();
                }
                catch (IOException e) {
                    //Lielle: What should we write here?
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop()
    {
        this.stop = true;
    }

}
