package exercise.connections;

import exercise.TcpConnection;

import java.util.ArrayList;

// BEGIN
public class Disconnected implements Connection{
    private TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public void connect() {
        this.tcpConnection.setStatus(new Connected(this.tcpConnection));
        System.out.print("");
    }

    @Override
    public void disconnect() {
        System.out.print("Error");
    }

    @Override
    public void write(String data) {
        System.out.print("Error");
    }

    @Override
    public String getStatus() {
        return "disconnected";
    }

    @Override
    public String getData() {
        return "Error";
    }
}
// END
