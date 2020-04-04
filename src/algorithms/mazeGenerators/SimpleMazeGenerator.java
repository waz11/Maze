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
        maze.setStart(start);
        maze.setGoal(goal);
        makeSolution();
        for(int row = 0; row<rows; row++){
            for(int col=0; col<cols; col++){
                Position position = new Position(row,col);
                if((maze.isPath(position)) && !solution.contains(position)) {
                    setRandomType(position);
                }
            }
        }
        return this.maze;
    }

    private void makeSolution(){
        int advance = 0;
        if(start.getRow() < goal.getRow())
            advance = 1;
        if(start.getRow() > goal.getRow())
            advance = -1;
        int row = start.getRow();
        int col = start.getCol();
        while(row != goal.getRow()) {
            row = row + advance;
            Position p = new Position(row, col);
            solution.add(p);
        }
        advance = 0;
        if(start.getCol() < goal.getCol())
            advance = 1;
        if(start.getCol() > goal.getCol())
            advance = -1;
        while(col != goal.getCol()) {
            col = col + advance;
            Position p = new Position(row, col);
            solution.add(p);
        }
    }

    private void setRandomType(Position position){
        Random random = new Random();
        if(random.nextBoolean())
            maze.setWall(position);
    }

}