package DonationHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import Ekhairat.Javabean.*;

/**
 * Servlet implementation class uploadDonation
 */
@WebServlet("/uploadDonation")
@MultipartConfig(maxFileSize = 16177215)
public class uploadDonation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadDonation() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
			response.setContentType("text/html");	
			String action = request.getParameter("action");
			try {
				switch (action) {
				case "createDonation": 
					createDonation(request,response);
				break;
				}
			}
			catch (SQLException e) {
				throw new ServletException(e);
				}
		}
		
		private void createDonation (HttpServletRequest request, HttpServletResponse response)
		        throws SQLException, IOException, ServletException{
			 	FileInputStream fis=null; 
			 	
			 	Part filePart =request.getPart("filedonation");  
				String paymenttype = "Sumbangan";
				int donate = Integer.parseInt(request.getParameter("donate"));
			 	HttpSession session=request.getSession(false);
				String memberID=(String)session.getAttribute("id");
				Timestamp Datentime = new Timestamp(System.currentTimeMillis());
				
				InputStream fileContent = filePart.getInputStream();
				donation don = new donation();
				
				String dbUrl = "jdbc:postgresql://ec2-52-72-56-59.compute-1.amazonaws.com/dd29m58g7a4tda";
				String username = "qekmfhbqusidva";
				String password = "22cff620d0b06f17950d4f4669a1e0f11f168c04053c0a218b1d83ee130fddb9";
				
				try {
					Class.forName("org.postgresql.Driver");
					Connection connection = DriverManager.getConnection(dbUrl,username,password);
					
					PreparedStatement p = connection.prepareStatement("insert into donation(paymentdetail,paymenttype,datentime,memberid,donationvalue) values(?,?,?,?,?)");
					p.setBinaryStream(1, fileContent);
					p.setString(2, paymenttype);
					p.setTimestamp(3, Datentime);
					p.setString(4, memberID);
					p.setFloat(5, donate);
					
					p.executeUpdate();
					response.sendRedirect("sucess.jsp");
					connection.close();
					p.close();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
	}

}
