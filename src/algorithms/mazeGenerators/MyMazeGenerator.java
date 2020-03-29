package algorithms.mazeGenerators;

import javafx.geometry.Pos;

import java.nio.file.Path;
import java.util.*;

public class MyMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int rows, int cols) {
        Maze myMaze = new Maze(rows, cols);
        Random rand = new Random();
        Stack<Position> possibleStack = new Stack<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                myMaze.setValueInMaze(i, j, 1);
        }
        Position[] special = getSpecialPositions(rows, cols);
        myMaze.setStart(special[0]);
        myMaze.setGoal(special[1]);
        addAdjacent(myMaze, possibleStack, special[0]);
        while (!possibleStack.isEmpty()) {
            Position next = possibleStack.pop();
            Position path = possibleStack.pop();
            if (myMaze.getValueInMaze(next.getRowIndex(), next.getColumnIndex()) == 1){
                myMaze.setValueInMaze(path.getRowIndex(), path.getColumnIndex(), 0);
                addAdjacent(myMaze, possibleStack, next);
            }
        }
        return myMaze;
    }

    protected void addAdjacent(Maze myMaze, Stack<Position> adjacentStack, Position position) {
        myMaze.setValueInMaze(position.getRowIndex(), position.getColumnIndex(), 0);
        //need to push adjacent randomly
        ArrayList<Integer> directions = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            directions.add(i);
        Collections.shuffle(directions);
        for (int i = 0; i < 4; i++) {
            if (directions.get(i) == 0) {
                if (position.getRowIndex() - 2 >= 0 && myMaze.getValueInMaze(position.getRowIndex() - 2, position.getColumnIndex()) != 0) {
                    adjacentStack.push(new Position(position.getRowIndex() - 1, position.getColumnIndex()));
                    adjacentStack.push(new Position(position.getRowIndex() - 2, position.getColumnIndex()));
                }
            }
            else if (directions.get(i) == 1) {
                if (position.getColumnIndex() + 2 < myMaze.mazeCols && myMaze.getValueInMaze(position.getRowIndex(), position.getColumnIndex() + 2) != 0) {
                    adjacentStack.push(new Position(position.getRowIndex(), position.getColumnIndex() + 1));
                    adjacentStack.push(new Position(position.getRowIndex(), position.getColumnIndex() + 2));
                }
            }
            else if (directions.get(i) == 2) {
                if (position.getRowIndex() + 2 < myMaze.mazeRows && myMaze.getValueInMaze(position.getRowIndex() + 2, position.getColumnIndex()) != 0) {
                    adjacentStack.push(new Position(position.getRowIndex() + 1, position.getColumnIndex()));
                    adjacentStack.push(new Position(position.getRowIndex() + 2, position.getColumnIndex()));
                }
            }
            else if (directions.get(i) == 3) {
                if (position.getColumnIndex() - 2 >= 0 && myMaze.getValueInMaze(position.getRowIndex(), position.getColumnIndex() - 2) != 0) {
                    adjacentStack.push(new Position(position.getRowIndex(), position.getColumnIndex() - 1));
                    adjacentStack.push(new Position(position.getRowIndex(), position.getColumnIndex() - 2));
                }
            }
        }
    }

}

