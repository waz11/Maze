package algorithms.mazeGenerators;
import java.util.Random;

public class EmptyMazeGenerator extends AMazeGenerator {

    //Still need to define a start and end positions
    @Override
    public Maze generate(int rows, int cols){
        Maze maze = new Maze(rows,cols);
        Position[] specialPositions = getSpecialPositions(rows,cols);
        maze.setStart(specialPositions[0]);
        maze.setGoal(specialPositions[1]);
        for (int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++)
                maze.setValueInMaze(i, j, 0);
        }
        return maze;
    }

}
