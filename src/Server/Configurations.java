package Server;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public abstract class Configurations {

    private static Properties prop;

    public static void Configurations(String[] args) {
        try (OutputStream output = new FileOutputStream("resources/config.properties")) {
            prop = new Properties();
            prop.setProperty("threads", "10");
            prop.setProperty("searchAlgorithm", "DepthFirstSearch");
            prop.setProperty("generator", "MyMazeGenerator");
            prop.store(output, null);
        }
        catch (EOFException e){ e.printStackTrace(); }
        catch (IOException io) { io.printStackTrace(); }

    }

}
