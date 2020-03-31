package algorithms.mazeGenerators;

import javafx.geometry.Pos;

public class Maze {
    private int[][] maze;
    private Position start;
    private Position goal;
    int rows;
    int cols;

    public Maze(int rows, int cols) {
        this.maze = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    /* START AND GOAL POSITIONS*/
    public void setStart(Position start) {
        maze[start.getRow()][start.getCol()] = 0;
        this.start = start;
    }

    public void setGoal(Position goal) {
        maze[start.getRow()][start.getCol()] = 0;
        this.goal = goal;
    }

    public Position getStart() {
        return start;
    }

    public Position getGoal() {
        return goal;
    }

    protected boolean isStart(int i, int j) {
        return (i == this.getStart().getRow() && j == this.getStart().getCol());
    }

    protected boolean isGoal(int i, int j) {
        return (i == this.getGoal().getRow() && j == this.getGoal().getCol());
    }


    /* PATH AND WALL POSITIONS*/
    public boolean setPath(Position position) {
        if (!(isLegalPosition(position)))
            return false;
        maze[position.getRow()][position.getCol()] = 0;
        return true;
    }
    public boolean setPath(int i, int j) {
        maze[i][j] = 0;
        return true;
    }

    public boolean setWall(Position position) {
        if (!(isLegalPosition(position)))
            return false;
        maze[position.getRow()][position.getCol()] = 1;
        return true;
    }

    public boolean setWall(int i, int j) {
        maze[i][j] = 1;
        return true;
    }

    public boolean isWall(Position position) {
        if (!isLegalPosition(position))
            return false;
        if(this.maze[position.getRow()][position.getCol()] == 1)
            return true;
        return false;
    }

    public boolean isPath(Position position) {
        if (!isLegalPosition(position))
            return false;
        if(this.maze[position.getRow()][position.getCol()] == 0)
            return true;
        return false;
    }

    protected boolean isLegalPosition(Position position) {
        if (position.getRow() < 0 || position.getRow() >= this.rows || position.getCol() < 0 || position.getCol() >= this.cols)
            return false;
        return true;
    }

    public void print() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isStart(row, col))
                    System.out.print("S");
                else if (isGoal(row, col))
                    System.out.print("E");
                else
                    System.out.print(this.maze[row][col]);
            }
            System.out.println();
        }
    }


}
