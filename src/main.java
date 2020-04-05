import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.SimpleMazeGenerator;

public class main {
    public static void main(String[] args) {

        SimpleMazeGenerator sm = new SimpleMazeGenerator();
        Maze m1 = sm.generate(20,20);
        m1.print();


    }
}
