import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/employee_db";
        String username = "postgres";
        String password = "1234";

        try{
            Connection conn = DriverManager.getConnection(url,username,password);
            if(conn != null){
                System.out.println("Connected to the database");
                conn.close();
            }
        }catch (Exception e){
            System.out.println("Connection FAILED "+e.getMessage());
            e.printStackTrace();
        }
    }
}
