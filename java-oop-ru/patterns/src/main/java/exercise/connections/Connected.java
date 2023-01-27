package exercise.connections;

import exercise.TcpConnection;

import java.util.ArrayList;

// BEGIN
public class Connected implements Connection{
    private TcpConnection tcpConnection;
    private ArrayList<String> bufer = new ArrayList<>();

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }
    @Override
    public void connect() {
        System.out.print("Error");
    }

    @Override
    public void disconnect() {
        this.tcpConnection.setStatus(new Disconnected(this.tcpConnection));
        System.out.print("");
    }

    @Override
    public void write(String data) {
        bufer.add(data);
        System.out.print("");
    }

    @Override
    public String getStatus() {
        return "connected";
    }
    @Override
    public String getData() {
        return bufer.toString();
    }
}
// END
