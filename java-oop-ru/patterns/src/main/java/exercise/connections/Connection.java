package exercise.connections;

import java.util.ArrayList;

public interface Connection {
    // BEGIN
    void connect();
    void disconnect();
    void write(String data);
    String getStatus();
    String getData();
    // END
}
