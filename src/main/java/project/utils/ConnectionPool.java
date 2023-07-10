package project.utils;

import java.net.CookieHandler;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private String url;
    private String username;
    private String password;
    private int maxConnections;

    private List<Connection> connections;

    public ConnectionPool(String url, String username, String password, int maxConnections){
        this.url = url;
        this.username = username;
        this.password = password;
        this.maxConnections = maxConnections;

        connections = new ArrayList<>();
        initializePool();
    }

    private void initializePool(){
        for (int i = 0; i < maxConnections; i++){
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                connections.add(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized Connection getConnection(){
        while (connections.isEmpty()){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return connections.remove(connections.size() - 1);
    }

    public synchronized void releaseConnection(Connection connection){
        connections.add(connection);
        notify();
    }
}
