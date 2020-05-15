package Server;

import algorithms.mazeGenerators.Maze;
import algorithms.search.ASearchingAlgorithm;
import algorithms.search.ISearchable;
import algorithms.search.ISearchingAlgorithm;
import algorithms.search.Solution;

import java.io.*;
import java.util.Arrays;

public class ServerStrategySolveSearchProblem implements IServerStrategy {
    private ISearchingAlgorithm solving;


    @Override
    public void serverStrategy(InputStream inputStream, OutputStream outputStream) {
        Maze maze;
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inputStream);
            ObjectOutputStream toClient = new ObjectOutputStream(outputStream);
            maze = (Maze)fromClient.readObject();

            byte[] byteMaze = maze.toByteArray();
            int mazeHash = Arrays.hashCode(byteMaze);
            String mazeName = "" + mazeHash + ".maze";
            Solution s = solving.solve((ISearchable) maze);
            saveMazeSolution(mazeName, s);

            toClient.writeObject(s);
            toClient.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public boolean isExist(String mazeName){
        String tempDirectoryPath = System.getProperty("java.io.tmpdir");
        return true;
    }

    public void saveMazeSolution(String mazeName, Solution s){
        if(!isExist((mazeName))){
            try {
                File myObj = new File(mazeName);
                myObj.createNewFile();
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(myObj));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
