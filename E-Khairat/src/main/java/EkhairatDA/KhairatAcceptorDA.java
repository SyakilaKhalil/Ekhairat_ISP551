package EkhairatDA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Ekhairat.Javabean.Khairatacceptor;

public class KhairatAcceptorDA {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	private static final String dbURL = "jdbc:postgresql://ec2-52-72-56-59.compute-1.amazonaws.com/dd29m58g7a4tda";
	private static final String user = "qekmfhbqusidva";
	private static final String pass = "22cff620d0b06f17950d4f4669a1e0f11f168c04053c0a218b1d83ee130fddb9";
	public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;

    }
	
	public void createAcceptor (Khairatacceptor ac) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("insert into khairatacceptor(acceptorvalue,memberid,staffid) values(?,?,?)"))
        {
            preparedStatement.setInt(1, ac.getacceptorvalue());
            preparedStatement.setString(2, ac.getmemberid());
            preparedStatement.setString(3, ac.getstaffid());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
