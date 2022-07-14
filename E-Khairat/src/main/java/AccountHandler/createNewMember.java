package AccountHandler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import EkhairatDA.KhairatMemberDA;
import Ekhairat.Javabean.*;
/**
 * Servlet implementation class createNewMember
 */
@WebServlet("/createNewMember")
public class createNewMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private KhairatMemberDA rd;
      public void init(){
  		rd = new KhairatMemberDA();
  	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewMember() {
        super();
        rd =new KhairatMemberDA();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html");
		
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "createKhairatmember": 
				createKhairatmember(request,response);
			break;
	
			}
		}
		catch (SQLException e) {
			throw new ServletException(e);
			}
	}
	private void createKhairatmember(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

		String memberName = request.getParameter("memberName");
		String memberID = request.getParameter("memberID");
		String memberContactNo = request.getParameter("memberContactNo");
		String memberAddress = request.getParameter("memberAddress");
		String memberEmail = request.getParameter("memberEmail");
		String memberPassword = request.getParameter("memberPassword");

		Khairatmember mem = new Khairatmember();
		mem.setmemberName(memberName);
		mem.setmemberID(memberID);
		mem.setmemberContactNo(memberContactNo);
		mem.setmemberAddress(memberAddress);
		mem.setmemberEmail(memberEmail);
		mem.setmemberPassword(memberPassword);
		
		rd.createKhairatmember(mem);
        
        response.sendRedirect("index.jsp");
    }

}
