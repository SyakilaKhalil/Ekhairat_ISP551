package PaymentHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
/**
 * Servlet implementation class uploadkhairatpayment
 */
@WebServlet("/uploadkhairatpayment")
@MultipartConfig(fileSizeThreshold = 1024*1024*10)
public class uploadkhairatpayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter out = null;
    Connection con = null;
    PreparedStatement ps = null;
    HttpSession session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadkhairatpayment() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		

		
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "ekhairat";
		String password = "system";
		
		try {
			out= response.getWriter();
			session = request.getSession(false);
			String folderName = "ReceiptPaymentDetails";
			String uploadPath = request.getServletContext().getRealPath("") + folderName;
			File dir = new File(uploadPath);
			
			if(!dir.exists()) {
				dir.mkdirs();
			}
			Part filePart = request.getPart("filekhairat");
			String paymentDetail = filePart.getSubmittedFileName();
			String Path = folderName + File.separator + paymentDetail;
			Timestamp Datentime = new Timestamp(System.currentTimeMillis());
			HttpSession session=request.getSession(false);
			String memberID=(String)session.getAttribute("id");
			System.out.println("fileName: " + paymentDetail);
			System.out.println("Path: " + uploadPath);
			InputStream is = filePart.getInputStream();
			Files.copy(is, Paths.get(uploadPath + File.separator + paymentDetail), StandardCopyOption.REPLACE_EXISTING);
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection connection = DriverManager.getConnection(dbUrl,username,password);
				String sql = "insert into khairatpayment(paymentdetail,path,datentime, memberid) values (?,?,?,?)";
				ps = connection.prepareStatement(sql);
				ps.setString(1, paymentDetail);
				ps.setString(2, Path);
				ps.setTimestamp(3, Datentime);
				ps.setString(4, memberID);
				int status = ps.executeUpdate();
				if(status > 0 ) {
					
					session.setAttribute("paymentDetail", paymentDetail);
					session.setAttribute("Datentime", Datentime);
					session.setAttribute("memberID", memberID);
					
					String msg = "" + paymentDetail + " FIle uploaded successfully...";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
					rd.forward(request, response);
					System.out.println("FIle uploaded successfully...");
					System.out.println("Uploaded Path: " + uploadPath);
				}
			} catch (Exception e) {
				out.println("Exception: " + e);
				System.out.println("Exception: " + e);
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
		} catch (IOException | ServletException e) {
			out.println("Exception: "  + e);
			System.out.println("Exception2: " + e);
		}
	}
    
}