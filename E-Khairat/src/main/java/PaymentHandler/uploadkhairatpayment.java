package PaymentHandler;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class Uploader
 */
@WebServlet("/uploaddetail")
@MultipartConfig(maxFileSize = 16177215)
public class uploadkhairatpayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public uploadkhairatpayment() {
    	super();
        // TODO Auto-generated constructor stub
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
	 response.setContentType("text/html");
		
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "createPayment": 
				createPayment(request,response);
			break;
			}
		}
		catch (SQLException e) {
			throw new ServletException(e);
			}
	}
 		
		private void createPayment (HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException{
	 	FileInputStream fis=null; 
	 	
	 	Part filePart =request.getPart("filekhairat");  
		String paymenttype = "Khairat";
	 	HttpSession session=request.getSession(false);
		String memberID=(String)session.getAttribute("id");
		Timestamp Datentime = new Timestamp(System.currentTimeMillis());
		String receiptid = null;
		
		InputStream fileContent = filePart.getInputStream();
		paymentkhairat pay = new paymentkhairat();
		
		String dbUrl = "jdbc:postgresql://ec2-52-72-56-59.compute-1.amazonaws.com/dd29m58g7a4tda";
		String username = "qekmfhbqusidva";
		String password = "22cff620d0b06f17950d4f4669a1e0f11f168c04053c0a218b1d83ee130fddb9";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(dbUrl,username,password);
			
			PreparedStatement p = connection.prepareStatement("insert into khairatpayment(paymentdetail,paymenttype,datentime,memberid) values(?,?,?,?)");
			p.setBinaryStream(1, fileContent);
			p.setString(2, paymenttype);
			p.setTimestamp(3, Datentime);
			p.setString(4, memberID);
			
			p.executeUpdate();
			response.sendRedirect("BUAT BAYARAN KHAIRAT.jsp");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
		/*private void createPaymentdetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			// TODO Auto-generated method stub
			FileInputStream fis=null; 
		 	Part filePart =request.getPart("fileKhairat");  
			String paymenttype = "Khairat";
			HttpSession session=request.getSession(false);
			String receiptid=(String)session.getAttribute("receiptid");
		 	
			InputStream fileContent = filePart.getInputStream();
			paymentkhairat pay = new paymentkhairat();
			
			String dbUrl = "jdbc:postgresql://ec2-52-72-56-59.compute-1.amazonaws.com/dd29m58g7a4tda";
			String username = "qekmfhbqusidva";
			String password = "22cff620d0b06f17950d4f4669a1e0f11f168c04053c0a218b1d83ee130fddb9";
			
			try {
				Class.forName("org.postgresql.Driver");
				Connection connection = DriverManager.getConnection(dbUrl,username,password);
				
				//SQL Statement/Query 
				PreparedStatement pst = connection.prepareStatement("insert into payment(paymentdetail,paymenttype,receiptid) values(?,?,?)");
				pst.setBinaryStream(1, fileContent);
				pst.setString(2, paymenttype);
				pst.setString(3, receiptid);
				
				pst.executeUpdate();
				response.sendRedirect("BUAT BAYARAN KHAIRAT.jsp");
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}*/
