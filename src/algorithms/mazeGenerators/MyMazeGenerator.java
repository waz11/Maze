package algorithms.mazeGenerators;

import java.util.*;

public class MyMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int rows, int cols) {
        Maze maze = new Maze(rows, cols);
        Random rand = new Random();
        Stack<Position> walls = new Stack<>();
        for (int row = 0; row < maze.rows; row++) {
            for (int col = 0; col < maze.cols; col++)
                maze.setWall(row, col);
        }
        Position start = new Position(rand.nextInt(rows), rand.nextInt(cols));
        maze.setStart(start);
        addWall(maze, walls, start);

        while (!walls.isEmpty()) {
            Position next = walls.pop();
            Position path = walls.pop();
            if (maze.isWall(next)){
                maze.setPath(path);
                addWall(maze, walls, next);
            }
        }

        Position goal = new Position(rand.nextInt(rows), rand.nextInt(cols));
        while (goal.equals(start) || maze.isWall(goal)){
            goal = new Position(rand.nextInt(rows), rand.nextInt(cols));
        }
        maze.setGoal(goal);

        return maze;
    }

    /**
     * this function add to walls stack all the wall positions around a position
     * @param maze     - a maze
     * @param walls    - stack of walls in a maze
     * @param position - the current Position, Where the route will start from
     */
    protected void addWall(Maze maze, Stack<Position> walls, Position position) {
        maze.setPath(position);

        LinkedList<Integer> directionsBucket = new LinkedList<>();
        for (int i = 0; i < 4; i++)
            directionsBucket.add(i);
        Collections.shuffle(directionsBucket);

        Position farPosition = new Position(0,0);
        Position nearPosition = new Position(0,0);
        for(int direction : directionsBucket){
            if (direction == 0) {
                farPosition = new Position(position.getRow() - 2, position.getCol());
                nearPosition = new Position(position.getRow() - 1, position.getCol());
            } else if (direction == 1) {
                farPosition = new Position(position.getRow(), position.getCol() + 2);
                nearPosition = new Position(position.getRow(), position.getCol() + 1);
            } else if (direction == 2) {
                farPosition = new Position(position.getRow() + 2, position.getCol());
                nearPosition = new Position(position.getRow() + 1, position.getCol());
            } else if (direction == 3) {
                farPosition = new Position(position.getRow(), position.getCol() - 2);
                nearPosition = new Position(position.getRow(), position.getCol() - 1);
            }
            walls.push(nearPosition);
            walls.push(farPosition);
        }
    }
}

