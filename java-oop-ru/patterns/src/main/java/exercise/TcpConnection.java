package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection {
    private Connection status;
    private String ip;
    private int port;

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.status = new Disconnected(this);
    }

    public void connect() {
        this.status.connect();
    }

    public void write(String data) {
        this.status.write(data);
    }

    public void disconnect() {
        this.status.disconnect();
    }

    public String getCurrentState() {
        return this.status.getStatus();
    }

    public void setStatus(Connection status) {
        this.status = status;
    }

    public String readData() {
        return this.status.getData();
    }
}
// END
