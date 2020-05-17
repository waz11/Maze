package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;

public class ServerStrategyGenerateMaze implements IServerStrategy {
    //Lielle: Not sure these should be attributes. Maybe we just create instances in the function itself
    private MyMazeGenerator mazeGenerator;
    private MyCompressorOutputStream compressor;

    @Override
    public void serverStrategy(InputStream inputStream, OutputStream outputStream) {
        int rows, cols;
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter toClient = new PrintWriter(outputStream);
        try {
             rows = Integer.parseInt(fromClient.readLine());
             cols = Integer.parseInt(fromClient.readLine());
             Maze maze = mazeGenerator.generate(rows,cols);
             byte[] byteMaze = maze.toByteArray();
             compressor.write(byteMaze);
             toClient.flush();
             outputStream  = new ByteArrayOutputStream(byteMaze.length);
             outputStream.write(byteMaze);
             toClient.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
