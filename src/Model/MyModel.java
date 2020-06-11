package Model;

import javafx.scene.input.KeyCode;

import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyModel extends Observable implements IModel {
    private int[][] maze;
    private int characterPositionRow;
    private int characterPositionCol;
    private ExecutorService threadPool = Executors.newCachedThreadPool();

    //Lielle: constructor?
    public MyModel(){
        //Raise the servers?
    }

    @Override
    public void generateMaze(int width, int height) {

    }

    @Override
    public void moveCharacter(KeyCode movement) {
        switch (movement){
            //case UP:
            //case DOWN:
            //case RIGHT:
            //case LEFT:
        }
    }

    @Override
    public int[][] getMaze() {
        return maze;
    }

    @Override
    public int getCharacterPositionRow() {
        return characterPositionRow;
    }

    @Override
    public int getCharacterPositionCol() {
        return characterPositionCol;
    }
}
