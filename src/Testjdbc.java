import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {
    // Create a test file or test in Main.java

        public static void main(String[] args) {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                System.out.println("✅ Connection successful!");
            }
        }
}
