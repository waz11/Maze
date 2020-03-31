package algorithms.mazeGenerators;

import java.util.Random;

public abstract class AMazeGenerator implements IMazeGenerator {
    @Override
    public long measureAlgorithmTimeMillis(int rows, int cols) {
        long startTime = System.currentTimeMillis();
        generate(rows, cols);
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    /**
     * this function return two special positions on the edges of a quad,
     * and ensures that both of them are on different edges of a maze
     * @param rows - num of rows in the maze
     * @param cols - num of cols in the maze
     * @return array of 2 special positions:
     * position[0] contains Start position of the maze
     * position[1] contains Goal position of the maze
     */
    protected Position[] getSpecialPositions(int rows, int cols){
        Position[] ans = new Position[2];
        Position startPos, goalPos;
        startPos = getRandomSpecialPosition(rows, cols);
        goalPos = getRandomSpecialPosition(rows, cols);
        while (sameEdge(startPos, goalPos)){
            goalPos = getRandomSpecialPosition(rows, cols);
        }
        ans[0] = startPos;
        ans[1] = goalPos;
        return ans;
    }

    /**
     * this function notify if two Positions found at the same side of a quad
     * @param p1 - Position 1
     * @param p2 - Position 2
     * @return true - two points at the same edge, false - else;
     */
    private boolean sameEdge(Position p1, Position p2){
        int rowsDiff = p1.getRow() - p2.getRow();
        int colsDiff = p1.getCol() - p2.getCol();
        boolean ans = (rowsDiff == 0) || (colsDiff == 0);
        return ans;
    }

    /**
     * this function set a position by random
     * @param rows - num of rows in the maze
     * @param cols - num of cols in the maze
     * @return
     */
    protected Position getRandomSpecialPosition(int rows, int cols){
        Position point;
        Random rand = new Random();
        int edge = rand.nextInt(4);
        if (edge == 0)
            point = new Position(rand.nextInt(rows), 0);
        else if (edge == 1)
            point = new Position(0, rand.nextInt(cols));
        else if (edge == 2)
            point = new Position(rand.nextInt(rows), cols-1);
        else
            point = new Position(rows-1, rand.nextInt(cols));
        return point;
    }
}
