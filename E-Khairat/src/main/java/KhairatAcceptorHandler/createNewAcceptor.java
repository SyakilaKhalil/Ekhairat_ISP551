package KhairatAcceptorHandler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Ekhairat.Javabean.Khairatacceptor;
import EkhairatDA.KhairatAcceptorDA;

/**
 * Servlet implementation class createNewAcceptor
 */
@WebServlet("/createNewAcceptor")
public class createNewAcceptor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhairatAcceptorDA rd;
    public void init(){
		rd = new KhairatAcceptorDA();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewAcceptor() {
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

		int acceptorvalue = Integer.parseInt(request.getParameter("acceptorvalue"));
		String memberid = request.getParameter("memberid");
		String staffid = request.getParameter("staffid");


		Khairatacceptor ac = new Khairatacceptor();
		ac.setacceptorvalue(acceptorvalue);
		ac.setmemberid(memberid);
		ac.setstaffid(staffid);

		
		rd.createAcceptor(ac);
        
        response.sendRedirect("index.jsp");
    }
}
