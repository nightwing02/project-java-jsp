

import java.io.IOException;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logincheck
 */
@WebServlet("/logincheck")
public class logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincheck() {
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
		doGet(request, response);
		
		
		HttpSession session=request.getSession();
		String qry = null; 
		ResultSet rs=null;
		
		try
         {
           
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			

			 String user=request.getParameter("xuser");
			String pass=request.getParameter("xpass");
			Statement st=null;
			
			
			st=con.createStatement();
			
	       qry ="select count(*) from member where username='" + user + "' and password='" + pass + "'";
	       rs= st.executeQuery(qry);
	       rs.next();
	       int x=rs.getInt(1);
	       if(x>=1)
	       {
				 session.setAttribute("username", user);
				 session.setAttribute("login", true);

	    	   response.sendRedirect("homepage.jsp");
	       }
	       
	       else
	       {
	    	   session.setAttribute("error", x + " User name or password is not match");
	    	   response.sendRedirect("contact.jsp");
	       }
         }
         
		 catch(Exception exp)
		 {
			 response.sendRedirect("contact.jsp");
		 }
		 
	}     	 

}
