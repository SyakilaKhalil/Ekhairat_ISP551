package AccountHandler;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginstaff
 */
@WebServlet("/loginstaff")
public class loginstaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginstaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String staffid = request.getParameter("nomborkp");
		String staffpassword = request.getParameter("pass");
		
		//Create session
		HttpSession session = request.getSession();
		
		//request dispatcher
		RequestDispatcher dispatcher = null;
		
		String dbUrl = "jdbc:postgresql://ec2-52-73-184-24.compute-1.amazonaws.com/dckqi5pj1ki93c";
		String username = "olkzesmgaifpnp";
		String password = "e13b8bdf28023c60fd1bfde4b54a707571b971a82e85d244b7871afc806f26ed";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(dbUrl,username,password);
			
			
			
			//SQL Statement/Query 
			PreparedStatement ps = connection.prepareStatement("select * from khairatstaff where staffid = ? and staffpassword = ?");
			
			// Set string - set for ? by order
			ps.setString(1, staffid);
			ps.setString(2, staffpassword);
			
			// Execute Query Method
			ResultSet result = ps.executeQuery();
			
			// if result has data
			if(result.next()) {
				//will redirect to homepage
				session.setAttribute("name", result.getString("staffname"));
				
				//request dispatcher - if login successful
				dispatcher = request.getRequestDispatcher("HOMEPAGE_MEMBER.jsp");
			}
			else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("staff.index.jsp");
			}
			
			dispatcher.forward(request, response);
			
			{
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
