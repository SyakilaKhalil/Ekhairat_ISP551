package EkhairatDA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Ekhairat.Javabean.Khairatstaff;

public class KhairatStaffDA {
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
	//create account staff
	public void createKhairatstaff (Khairatstaff sta) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("insert into khairatstaff(staffname,staffid,staffcontactno,staffaddress,staffemail,staffpassword) values(?,?,?,?,?,?)"))
        {
            preparedStatement.setString(1, sta.getstaffName());
            preparedStatement.setString(2, sta.getstaffID());
            preparedStatement.setString(3, sta.getstaffContactNo());
            preparedStatement.setString(5, sta.getstaffEmail());
            preparedStatement.setString(6, sta.getstaffPassword());
            preparedStatement.setString(4, sta.getstaffAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	//update account staff
     public boolean updateKhairatstaff(Khairatstaff sta) throws SQLException{
		
		boolean rowUpdated;
		try (Connection connection= getConnection();
				PreparedStatement statement =connection.prepareStatement("UPDATE khairatstaff set staffname=?,staffcontactno=?,staffaddress=?,staffemail=?,staffpassword=? where staffid=?");){
					statement.setString(1, sta.getstaffName());
		            statement.setString(2, sta.getstaffContactNo());
		            statement.setString(3, sta.getstaffAddress());
		            statement.setString(4, sta.getstaffEmail());
		            statement.setString(5, sta.getstaffPassword());
		            statement.setString(6, sta.getstaffID());
		            
		            rowUpdated=statement.executeUpdate()>0;
				}
				return rowUpdated;
	}
}