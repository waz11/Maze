package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {
    private LinkedList<Position> solution;
    private Maze maze;
    private Position start;
    private Position goal;

    public SimpleMazeGenerator() {
        this.solution = new LinkedList<>();
    }

    public Maze generate(int rows, int cols) {
        this.maze = new Maze(rows,cols);
        Position[] sp = getSpecialPositions(rows,cols);
        start = sp[0];
        goal = sp[1];
        this.maze.setStart(start);
        this.maze.setGoal(goal);
        makeSolution();
        for(int row = 0; row<rows; row++){
            for(int col=0; col<cols; col++){
                Position position = new Position(row,col);
                if((maze.isPath(position)) && !solution.contains(position))
                    setRandomType(position);
            }
        }
        return maze;
    }

    private void makeSolution(){
        LinkedList<Integer> rowIndexes = goToIndex(start.getRow(), goal.getRow());
        for(int row : rowIndexes){
            Position p = new Position(row, start.getCol());
            this.solution.add(p);
        }

        LinkedList<Integer> colIndexes = goToIndex(start.getCol(), goal.getCol());
        for(int col : colIndexes){
            Position p = new Position(rowIndexes.getLast(), col);
            solution.add(p);
        }
    }

    private LinkedList<Integer> goToIndex(int currIndex, int destIndex){
        LinkedList<Integer> indexes = new LinkedList<>();
        int advance = 0;
        if(currIndex < destIndex)
            advance = 1;
        else if(currIndex > destIndex)
            advance = -1;
        while(currIndex != destIndex) {
            currIndex += advance;
            indexes.add(currIndex);
        }
        return indexes;
    }

    private void setRandomType(Position position){
        Random random = new Random();
        if(random.nextBoolean())
            maze.setWall(position);
    }

}