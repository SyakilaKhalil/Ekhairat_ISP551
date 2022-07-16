package AccountHandler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Ekhairat.Javabean.Khairatmember;
import EkhairatDA.KhairatMemberDA;


/**
 * Servlet implementation class updateMemberAccount
 */
@WebServlet("/updateMemberAccount")
public class updateMemberAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhairatMemberDA rd;
	public void init(){
		rd = new KhairatMemberDA();
	}
    public updateMemberAccount() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "updateKhairatmember":
				updateKhairatmember(request,response);
				break;
				
			}
		}
		catch (SQLException e) {
			throw new ServletException(e);
			}	
	}
	private void updateKhairatmember(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException {
			
			HttpSession session = request.getSession();
			String memberNAME = request.getParameter("name");
			String memberID = request.getParameter("id");
			String memberCONTACTNO = request.getParameter("contact");
			String memberADDRESS = request.getParameter("address");
			String memberEMAIL = request.getParameter("email");
			String memberPASSWORD = request.getParameter("password");
			Khairatmember mem = new Khairatmember();
			
			mem.setmemberName(memberNAME);
			mem.setmemberID(memberID);
			mem.setmemberContactNo(memberCONTACTNO);
			mem.setmemberAddress(memberADDRESS);
			mem.setmemberEmail(memberEMAIL);
			mem.setmemberPassword(memberPASSWORD);
			
			rd.updateKhairatmember(mem);
			
			session.removeAttribute("name");
			session.removeAttribute("id");
			session.removeAttribute("contact");
			session.removeAttribute("address");
			session.removeAttribute("email");
			session.removeAttribute("password");
			
			session.setAttribute("name", memberNAME);
			session.setAttribute("id", memberID);
			session.setAttribute("contact", memberCONTACTNO);
			session.setAttribute("address" , memberADDRESS);
			session.setAttribute("email" , memberEMAIL);
			session.setAttribute("password", memberPASSWORD);
			
			response.sendRedirect("AKAUN_PENGGUNA.jsp");
			
			
		}

}
