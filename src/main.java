import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.SimpleMazeGenerator;

public class main {
    public static void main(String[] args) {
        SimpleMazeGenerator sm = new SimpleMazeGenerator();
        Maze m = sm.generate(10, 8);
        m.print();
        System.out.println(m.getStartPosition());
    }
}
