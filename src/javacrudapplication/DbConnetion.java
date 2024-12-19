
package javacrudapplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnetion {
    public static Connection getConnection() throws SQLException {
       final String URL = "jdbc:mysql://localhost:3306/test";
       final String USERNAME = "root";
       final String PASS = "";
       
       return DriverManager.getConnection(URL, USERNAME, PASS);
    }
}
