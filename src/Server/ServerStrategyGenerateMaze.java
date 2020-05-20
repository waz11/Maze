package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;

public class ServerStrategyGenerateMaze implements IServerStrategy {

    @Override
    public void serverStrategy(InputStream inputStream, OutputStream outputStream) {
        MyMazeGenerator mazeGenerator = new MyMazeGenerator();
        MyCompressorOutputStream compressor = new MyCompressorOutputStream(outputStream);
        int rows, cols;
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inputStream);
            ObjectOutputStream toClient = new ObjectOutputStream(outputStream);
            try {
                int[] msg = (int[]) fromClient.readObject();
                rows = msg[0];
                cols = msg[1];
                Maze maze = mazeGenerator.generate(rows,cols);
                byte[] byteMaze = maze.toByteArray();
                compressor.write(byteMaze);
                toClient.flush();
                outputStream  = new ByteArrayOutputStream(byteMaze.length);
                outputStream.write(byteMaze);
                toClient.flush();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
