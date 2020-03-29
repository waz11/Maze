package algorithms.mazeGenerators;

public class
Maze {
    private int[][] maze;
    private Position start;
    private Position goal;
    int mazeRows;
    int mazeCols;

    //How should we define the constructor?
    public Maze(int rows, int cols) {
        this.maze = new int[rows][cols];
        this.mazeRows = rows;
        this.mazeCols = cols;
    }

    public Position getStartPosition() {
        return start;
    }

    public Position getGoalPosition() {
        return goal;
    }

    public void setStart(Position start) {
        maze[start.getRowIndex()][start.getColumnIndex()] = 0;
        this.start = start;
    }

    public void setGoal(Position goal) {
        maze[start.getRowIndex()][start.getColumnIndex()] = 0;
        this.goal = goal;
    }

    public void setValueInMaze(int row, int col, int value){
        if (row>=0 && col>=0 && row<this.mazeRows && col<this.mazeCols)
            this.maze[row][col] = value;
    }

    public int getValueInMaze(int row, int col){
        return this.maze[row][col];
    }

    //Still need to find out how to find the start and end position in order to print them
    public void print(){
        for (int i=0; i<mazeRows; i++){
            for (int j=0; j<mazeCols; j++){
                if (isStart(i,j))
                    System.out.print("S");
                else if(isGoal(i,j))
                    System.out.print("E");
                else
                    System.out.print(this.maze[i][j]);
            }
            System.out.println();
        }
    }

    protected boolean isStart(int i, int j){
        return (i == this.getStartPosition().getRowIndex() && j == this.getStartPosition().getColumnIndex());
    }

    protected boolean isGoal(int i, int j){
        return (i == this.getGoalPosition().getRowIndex() && j == this.getGoalPosition().getColumnIndex());
    }
}
