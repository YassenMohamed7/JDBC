package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection dbConnection;
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost:5432/fawry_intern_task1";
    private static String username = "postgres";
    private static String password = "Yassen";

    private DBConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(url, username, password);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (dbConnection == null) {
            synchronized (DBConnection.class) {
                if (dbConnection == null) {
                    dbConnection = new DBConnection();
                }
            }
        }
        return connection;
    }
}
