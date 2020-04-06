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
     * this function return two special positions on different edges of a quad,
     * @param rows - num of rows in a maze
     * @param cols - num of cols in a maze
     * @return array of 2 special positions while -
     *          position[0] contains Start position
     *          position[1] contains Goal position
     */
    protected Position[] getSpecialPositions(int rows, int cols){
        Position[] ans = new Position[2];
        Position startPos, goalPos;
        startPos = getRandomSpecialPosition(rows, cols);
        goalPos = getRandomSpecialPosition(rows, cols);
        while (sameEdge(startPos, goalPos, rows, cols)){
            goalPos = getRandomSpecialPosition(rows, cols);
        }
        ans[0] = startPos;
        ans[1] = goalPos;
        return ans;
    }

    /**
     * @param rows - num of rows in the maze
     * @param cols - num of cols in the maze
     * @return a random position on one of a quad side by random
     */
    protected Position getRandomSpecialPosition(int rows, int cols){
        Position position;
        Random rand = new Random();
        int edge = rand.nextInt(4);
        if (edge == 0)
            position = new Position(rand.nextInt(rows), 0);
        else if (edge == 1)
            position = new Position(0, rand.nextInt(cols));
        else if (edge == 2)
            position = new Position(rand.nextInt(rows), cols-1);
        else
            position = new Position(rows-1, rand.nextInt(cols));
        return position;
    }

    /**
     * this function notify if two Positions found at the same side of a quad
     * @param p1 - Position 1
     * @param p2 - Position 2
     * @return true - two points at the same edge, false - else;
     */
    private boolean sameEdge(Position p1, Position p2, int rows, int cols){
        boolean ans = false;
        int edge1 = getEdge(p1, rows,cols);
        int edge2 = getEdge(p2, rows,cols);
        if (edge1 == edge2)
            ans = true;
        if(edge1%2 != edge2%2){
            if(p1.getRowIndex() == p2.getRowIndex() || p1.getColumnIndex() == p2.getColumnIndex())
                ans = true;
        }
        return ans;
    }

    /**

     * this function return the quad edge of a position- while the quad divided as follows:
     *     30000
     *     3***1
     *     3***1
     *     22221
     * @param position - position on a quad
     * @param rows - rows of a quad
     * @param cols - columns of a quad
     * @return quad edge while - 0=left, 1=up, 2=right, 3=down
     */
    protected int getEdge(Position position, int rows, int cols){
        int row = position.getRowIndex();
        int col = position.getColumnIndex();
        int ans = -1;
        if(row > 0 && col == 0)
            ans = 0;
        else if(row == 0 && col < cols - 1)
            ans = 1;
        else if(row < rows-1 && col == cols-1)
            ans = 2;
        else if(row == rows-1 && col > 0)
            ans = 3;
        return ans;
    }

}
