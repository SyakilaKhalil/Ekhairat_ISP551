package AnnouncementHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;


import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EkhairatDA.AnnouncementDA;
import Ekhairat.Javabean.announcement;

/**
 * Servlet implementation class createAnnouncement
 */
@WebServlet("/createAnnouncement")
public class createAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnnouncementDA ad;
	public void init() {
		ad = new AnnouncementDA();
	}  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createAnnouncement() {
        super();
        ad = new AnnouncementDA();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("announce", AnnouncementDA.getAllAnnounce());
		RequestDispatcher view = request.getRequestDispatcher("HOMEPAGE_STAFF.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "createAnnounce": 
				createAnnounce(request,response);
			break;
			}
		}
		catch (SQLException e) {
			throw new ServletException(e);
			}
	}
	private void createAnnounce(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
		
		Timestamp Datentime = new Timestamp(System.currentTimeMillis());
		String announceDetail = request.getParameter("announceDetail");
		HttpSession session = request.getSession();
		String staffid =(String)session.getAttribute("id");
		session.setAttribute("id",staffid);
		
		announcement ann = new announcement();
		
		ann.setDatentime(Datentime);
		ann.setannounceDetail(announceDetail);
		ann.setstaffid(staffid);
		
		ad.createAnnounce(ann);
		response.sendRedirect("HOMEPAGE_STAFF.jsp");
	}

}
