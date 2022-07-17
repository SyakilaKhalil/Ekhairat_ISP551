package DonationHandler;

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
 * Servlet implementation class uploadDonation
 */
@WebServlet("/uploadDonation")
public class uploadDonation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadDonation() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		throws ServletException, IOException{
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
		
		private void createDontion
	}

}
