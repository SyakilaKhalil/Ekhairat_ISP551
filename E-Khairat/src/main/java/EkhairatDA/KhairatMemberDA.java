package EkhairatDA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Ekhairat.Javabean.Khairatmember;




public class KhairatMemberDA {
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
	//untuk create member account
	public void createKhairatmember (Khairatmember mem) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("insert into khairatmember(membername,memberid,membercontactno,memberaddress,memberemail,memberpassword) values(?,?,?,?,?,?)"))
        {
            preparedStatement.setString(1, mem.getmemberName());
            preparedStatement.setString(2, mem.getmemberID());
            preparedStatement.setString(3, mem.getmemberContactNo());
            preparedStatement.setString(5, mem.getmemberEmail());
            preparedStatement.setString(6, mem.getmemberPassword());
            preparedStatement.setString(4, mem.getmemberAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	//untuk update user
		public boolean updateKhairatmember(Khairatmember mem) throws SQLException{
			
			boolean rowUpdated;
			try (Connection connection= getConnection();
					PreparedStatement statement =connection.prepareStatement("UPDATE khairatmember set membername=?,membercontactno=?,memberaddress=?,memberemail=?,memberpassword=? where memberid=?");){
						statement.setString(1, mem.getmemberName());
			            statement.setString(2, mem.getmemberContactNo());
			            statement.setString(3, mem.getmemberAddress());
			            statement.setString(4, mem.getmemberEmail());
			            statement.setString(5, mem.getmemberPassword());
			            statement.setString(6, mem.getmemberID());
			            
			            rowUpdated=statement.executeUpdate()>0;
					}
					return rowUpdated;
		}


}
