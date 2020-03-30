
import algorithms.mazeGenerators.*;

/**
 * Created by Aviadjo on 3/22/2017.
 */
public class RunMazeGenerator {
    public static void main(String[] args) {
        MyMazeGenerator pm = new MyMazeGenerator();
        Maze m = pm.generate(6, 6);
        m.print();
    }
}