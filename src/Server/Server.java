package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Aviadjo on 3/2/2017.
 */
public class Server {
    private int port;
    private int listeningInterval;
    private IServerStrategy serverStrategy;
    private volatile boolean stop;
    private ExecutorService threadPoolExecutor;


    public Server(int port, int listeningInterval, IServerStrategy serverStrategy) {
        this.port = port;
        this.listeningInterval = listeningInterval;
        this.serverStrategy = serverStrategy;
        this.threadPoolExecutor =  Executors.newFixedThreadPool(5);
    }

    public void start() {
        new Thread(() -> {
            runServer();
        }).start();
    }

    private void runServer() {
        try {

            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(listeningInterval);

            while (!stop) {
                try {
                    Socket clientSocket = serverSocket.accept(); // blocking call
                    serverStrategy.serverStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
                    threadPoolExecutor.execute(() ->{
                        clientHandle(clientSocket);
                    });
                    stop();
                } catch (SocketTimeoutException e) {
                    threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
                    threadPoolExecutor.setCorePoolSize(2);
                    threadPoolExecutor.setMaximumPoolSize(2);
                }
            }
            serverSocket.close();
        } catch (IOException e) {

        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            serverStrategy.serverStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
            clientSocket.close();
        } catch (IOException e) {

        }
    }

    public void stop() {
        stop = true;
    }
}
