package application.wagonrepairmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
    private static final String URL = System.getenv("DB_URL");
    private static final String USERNAME = System.getenv("DB_USERNAME");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");
    private static Connection connection;

    public static Connection connect()
    {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to database!");

        } catch (SQLException e) {
            System.out.println("Failed to connect to the database!");
            e.printStackTrace();
        }

        return connection;
    }

    public static void disconnect()
    {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
