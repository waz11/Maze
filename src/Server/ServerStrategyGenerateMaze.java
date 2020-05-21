package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;

public class ServerStrategyGenerateMaze implements IServerStrategy {

    @Override
    public void serverStrategy(InputStream inputStream, OutputStream outputStream) {
        MyMazeGenerator mazeGenerator = new MyMazeGenerator();

        int rows, cols;
        try {
            try (ObjectInputStream fromClient = new ObjectInputStream(inputStream)) {
                ObjectOutputStream toClient = new ObjectOutputStream(outputStream);
                toClient.flush();
                try {
                    int[] msg = (int[]) fromClient.readObject();
                    rows = msg[0];
                    cols = msg[1];
                    Maze maze = mazeGenerator.generate(rows, cols);
                    ByteArrayOutputStream ByteOutputStream = new ByteArrayOutputStream();
                    MyCompressorOutputStream compressor = new MyCompressorOutputStream(ByteOutputStream);
                    byte[] byteMaze = maze.toByteArray();
                    compressor.write(byteMaze);
                    compressor.flush();
                    toClient.writeObject(ByteOutputStream.toByteArray());
                    toClient.flush();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}