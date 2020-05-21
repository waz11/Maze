package test;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws IOException {


        MyMazeGenerator sm = new MyMazeGenerator();
        Maze m = sm.generate(10,10);
        m.print();
        byte[] lielle = m.toByteArray();
        OutputStream out = new MyCompressorOutputStream(new FileOutputStream("mazeFileName"));
        MyCompressorOutputStream orenzur = new MyCompressorOutputStream(out);
        orenzur.write(lielle);
        orenzur.flush();
        out.close();




    }
}
