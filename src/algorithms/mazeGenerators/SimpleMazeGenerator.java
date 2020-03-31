package algorithms.mazeGenerators;

import java.util.Random;

//Still need to define a start and end positions
//We need to define walls:empty and the random method will work with it
public class SimpleMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int rows, int cols) {
        Maze maze = new Maze(rows,cols);
        Random rand = new Random();
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                int value = rand.nextInt(5);
                if (value%5 == 0)
                    maze.setWall(i,j);
                else
                    maze.setWall(i,j);
            }
        }
        Position[] specialPositions = getSpecialPositions(rows,cols);
        maze.setStart(specialPositions[0]);
        maze.setGoal(specialPositions[1]);

        maze.setPath(maze.getStart());
        maze.setPath(maze.getGoal());
        return maze;
    }
}
