package algorithms.mazeGenerators;

import java.util.Random;

//Still need to define a start and end positions
//We need to define walls:empty and the random method will work with it
public class SimpleMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int rows, int cols) {
        Maze simpleMaze = new Maze(rows,cols);
        Random rand = new Random();
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                int value = rand.nextInt(5);
                if (value%5 == 0)
                    simpleMaze.setValueInMaze(i, j, 1);
                else
                    simpleMaze.setValueInMaze(i, j, 0);
            }
        }
        Position[] specialPositions = getSpecialPositions(rows,cols);
        simpleMaze.setStart(specialPositions[0]);
        simpleMaze.setGoal(specialPositions[1]);

        simpleMaze.setValueInMaze(simpleMaze.getStartPosition().getRowIndex(), simpleMaze.getStartPosition().getColumnIndex(), 0);
        simpleMaze.setValueInMaze(simpleMaze.getGoalPosition().getRowIndex(), simpleMaze.getGoalPosition().getColumnIndex(), 0);
        return simpleMaze;
    }
}
