package EkhairatDA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Ekhairat.Javabean.*;


public class AnnouncementDA {
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
            Class.forName("oracle.jdbc.driver.OracleDriver");
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
	
	public void createAnnounce (announcement ann) throws SQLException {
		 try (Connection con = getConnection();
	             PreparedStatement preparedStatement = con.prepareStatement("insert into announcement(announcedatentime, announcedetail, staffid) values(?,?,?)"))
	        {
			 	preparedStatement.setTimestamp(1, ann.getDatentime());
			 	preparedStatement.setString(2, ann.getannounceDetail());
			 	preparedStatement.setString(3, ann.getstaffid());
			 	
			 	
			 	preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	}
	
	public static List<announcement> getAllAnnounce(){
		List<announcement> announcements = new ArrayList<announcement>();
		
		Connection con = DB.getConnection();
		Statement st;
		try
		{		
				st = con.createStatement();
				ResultSet rs = st.executeQuery("Select * from announcement order by announcedatentime");
				
				while(rs.next()){
				announcement i = new announcement();
				i.setDatentime(rs.getTimestamp("announcedatentime"));
				i.setannounceDetail(rs.getString("announcedetail"));
				i.setstaffid(rs.getString("staffid"));
			
				announcements.add(i);
			}
			con.close();
		}catch (Exception e) {
	          e.printStackTrace();
	    }
		
		return announcements;
	}
	
}
