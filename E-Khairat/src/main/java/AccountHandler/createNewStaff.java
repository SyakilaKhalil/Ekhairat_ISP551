package AccountHandler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Ekhairat.Javabean.Khairatstaff;
import EkhairatDA.KhairatStaffDA;


/**
 * Servlet implementation class createNewStaff
 */
@WebServlet("/createNewStaff")
public class createNewStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhairatStaffDA sd;
	public void init(){
		sd = new KhairatStaffDA();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html");
		
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "createKhairatstaff": 
				createKhairatstaff(request,response);
			break;
			}
		}
		catch (SQLException e) {
			throw new ServletException(e);
			}	
	}
	
	private void createKhairatstaff(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

		String staffName = request.getParameter("staffName");
		String staffID = request.getParameter("staffID");
		String staffContactNo = request.getParameter("staffContactNo");
		String staffAddress = request.getParameter("staffAddress");
		String staffEmail = request.getParameter("staffEmail");
		String staffPassword = request.getParameter("staffPassword");
		
		Khairatstaff sta = new Khairatstaff();

		sta.setstaffName(staffName);
		sta.setstaffID(staffID);
		sta.setstaffContactNo(staffContactNo);
		sta.setstaffAddress(staffAddress);
		sta.setstaffEmail(staffEmail);
		sta.setstaffPassword(staffPassword);

        sd.createKhairatstaff(sta);
        response.sendRedirect("staff.index.jsp");
    }

}
