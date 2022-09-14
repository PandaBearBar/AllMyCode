package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPool {
    //Step 1 - Mutual Instance
    private static ConnectionPool instance = null;
    private static final int SIZE = 10;
    private Stack<Connection> connections = new Stack<>();

    //Step 2 - Upgrade Into Private

    private ConnectionPool() throws SQLException {
        initializeAllConnections();
    }

    //Step 3 - Expose To Static Method

    public void initializeAllConnections() throws SQLException {
        for (int i = 0; i < SIZE; i++) {
            this.connections.push(DriverManager.getConnection(JDBCUtils.URL, JDBCUtils.USER, JDBCUtils.PASSWORD));
        }
    }

    public static ConnectionPool getInstance() throws SQLException {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        synchronized (connections) {
            if (connections.empty()) {
                connections.wait();
            }
            return connections.pop();
        }
    }

    public void restoreConnection(Connection connection) {
        synchronized (connections) {
            connections.push(connection);
            connections.notify();
        }
    }

    public void closeAllConnections() {

        if (this.connections.size() == SIZE) {
            for (int i = 0; i < SIZE; i++) {
                this.connections.pop();
            }
        }
    }
}
