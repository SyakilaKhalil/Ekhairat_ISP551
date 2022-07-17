package KhairatAcceptorHandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class deleteAcceptor
 */
@WebServlet("/deleteAcceptor")
public class deleteAcceptor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement ps = null;
    HttpSession session = null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAcceptor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dbURL = "jdbc:postgresql://ec2-52-72-56-59.compute-1.amazonaws.com/dd29m58g7a4tda";
		String user = "qekmfhbqusidva";
		String pass = "22cff620d0b06f17950d4f4669a1e0f11f168c04053c0a218b1d83ee130fddb9";
		String acceptorid= request.getParameter("id");
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(dbURL,user,pass);
			ps = connection.prepareStatement("DELETE FROM khairatacceptor WHERE acceptorid=?");
			
			ps.setString(1, acceptorid);
			
			int status = ps.executeUpdate();
			if(status > 0 ) {
				RequestDispatcher rd = request.getRequestDispatcher("HOMEPAGE_STAFF.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
