package PaymentHandler;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class updatestatusbayaran
 */
@WebServlet("/updatestatusbayaran")
public class updatestatusbayaran extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter out = null;
    Connection con = null;
	PreparedStatement ps = null;
    HttpSession session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatestatusbayaran() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dbUrl = "jdbc:postgresql://ec2-52-72-56-59.compute-1.amazonaws.com/dd29m58g7a4tda";
		String username = "qekmfhbqusidva";
		String password = "22cff620d0b06f17950d4f4669a1e0f11f168c04053c0a218b1d83ee130fddb9";
		

		String receiptid= request.getParameter("receiptid");
		String Status="Disahkan";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(dbUrl,username,password);
			String sql = "update khairatpayment set status=? where receiptid=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, Status);
			ps.setString(2, receiptid);
			int status = ps.executeUpdate();
			if(status > 0 ) {
				RequestDispatcher rd = request.getRequestDispatcher("penggesahan_bayaran.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		try {
			if(ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			out.println(e);
		}
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
