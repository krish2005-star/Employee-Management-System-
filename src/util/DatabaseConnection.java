package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static final Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/config.properties");
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Error loading config file: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        try {
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            Connection conn = DriverManager.getConnection(url, user, password);
            //System.out.println("Connected successful");
            return conn;
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}
