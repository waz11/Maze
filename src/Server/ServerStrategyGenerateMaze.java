package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;

public class ServerStrategyGenerateMaze implements IServerStrategy {
    private MyMazeGenerator mazeGenerator;
    private MyCompressorOutputStream compressor;
    private int rows;
    private int cols;

    @Override
    public void serverStrategy(InputStream inputStream, OutputStream outputStream) {
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter toClient = new PrintWriter(outputStream);
        try {
             rows = Integer.parseInt(fromClient.readLine());
             cols = Integer.parseInt(fromClient.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Maze maze = mazeGenerator.generate(rows,cols);
        byte[] byteMaze = maze.toByteArray();
        try {
            compressor.write(byteMaze);
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputStream  = new ByteArrayOutputStream(byteMaze.length);
        try {
            outputStream.write(byteMaze);
        } catch (IOException e) {
            e.printStackTrace();
            toClient.flush();
        }

    }
}
