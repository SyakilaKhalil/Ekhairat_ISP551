package DonationHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class displaykhairatpayment
 */
@WebServlet("/displayDonation")
public class displayDonation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayDonation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
        String receiptid = request.getParameter("receiptid");
        java.sql.Connection con = null;
        Statement st1;
        
        String dbURL = "jdbc:postgresql://ec2-52-72-56-59.compute-1.amazonaws.com/dd29m58g7a4tda";
        String user = "qekmfhbqusidva";
        String pass = "22cff620d0b06f17950d4f4669a1e0f11f168c04053c0a218b1d83ee130fddb9";
        
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbURL,user,pass);
            st1 = con.createStatement();
            PreparedStatement ps = con.prepareStatement("SELECT paymentdetail FROM donation WHERE receiptid=?");
            ps.setString(1, receiptid);
            ResultSet rs = ps.executeQuery();
 
            String imgLen = "";
            while (rs.next()) {
                imgLen = rs.getString(1);
                System.out.println(imgLen.length());
                int len = imgLen.length();
                byte[] rb = new byte[len];
                InputStream readImg = rs.getBinaryStream(1);
                int index = readImg.read(rb, 0, len);
                out.println("index----------------" + index);
                response.reset();
                response.setContentType("image");
                response.getOutputStream().write(rb, 0, len);
                response.getOutputStream().flush();
 
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        //out.println(e);
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
