package Server;

import java.io.InputStream;
import java.io.OutputStream;

public interface ServerStrategy {

    void serverStrategy(InputStream inputStream, OutputStream outputStream);


}
