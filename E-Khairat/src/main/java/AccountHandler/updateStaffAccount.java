package AccountHandler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Ekhairat.Javabean.Khairatstaff;
import EkhairatDA.KhairatStaffDA;


/**
 * Servlet implementation class updateStaffAccount
 */
@WebServlet("/updateStaffAccount")
public class updateStaffAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private KhairatStaffDA sd;
	public void init(){
		sd = new KhairatStaffDA();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStaffAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "updateKhairatstaff":
				updateKhairatstaff(request,response);
				break;
			}
		}
		catch (SQLException e) {
			throw new ServletException(e);
			}
	}
		
		private void updateKhairatstaff(HttpServletRequest request, HttpServletResponse response)
		        throws SQLException, IOException {
				
				HttpSession session = request.getSession();
				String staffNAME = request.getParameter("name");
				String staffID = request.getParameter("id");
				String staffCONTACTNO = request.getParameter("contact");
				String staffADDRESS = request.getParameter("address");
				String staffEMAIL = request.getParameter("email");
				String staffPASSWORD = request.getParameter("password");
				Khairatstaff sta = new Khairatstaff();
				
				sta.setstaffName(staffNAME);
				sta.setstaffID(staffID);
				sta.setstaffContactNo(staffCONTACTNO);
				sta.setstaffAddress(staffADDRESS);
				sta.setstaffEmail(staffEMAIL);
				sta.setstaffPassword(staffPASSWORD);
				sd.updateKhairatstaff(sta);
				
				session.removeAttribute("name");
				session.removeAttribute("id");
				session.removeAttribute("contact");
				session.removeAttribute("email");
				session.removeAttribute("password");
				
				session.setAttribute("name", staffNAME);
				session.setAttribute("id", staffID);
				session.setAttribute("contact", staffCONTACTNO);
				session.setAttribute("address" , staffADDRESS);
				session.setAttribute("email" , staffEMAIL);
				session.setAttribute("password", staffPASSWORD);
				
				response.sendRedirect("AKAUN_STAFF.jsp");
	}
}
