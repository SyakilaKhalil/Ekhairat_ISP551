package EkhairatDA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	static String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    static String user = "ekhairat";
    static String pass = "system";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(dbURL, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }
}
