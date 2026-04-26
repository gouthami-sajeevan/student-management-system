import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/student_db";
            String user = "root";
            String password = "Root@0987";

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL!");
            return con;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
