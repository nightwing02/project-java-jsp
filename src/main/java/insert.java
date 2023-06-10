

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
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
		
		
		String user=request.getParameter("xuser");
		String sale=request.getParameter("xmail");
		String city=request.getParameter("xphone");
		String pass=request.getParameter("xpass");
		String arr[]= {user,sale,city};
		  HttpSession session=request.getSession();  
		
		  try
          {
            
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");  
                        
                        PreparedStatement st = con.prepareStatement("insert into member(username,email,mobile,password) values(?, ?, ?, ?)");
                       
                       st.setString(1,request.getParameter("xuser"));
                       st.setString(2,request.getParameter("xmail"));
                       st.setString(3,request.getParameter("xphone")); 
                       st.setString(4,request.getParameter("xpass")); 
                       st.executeUpdate();
                       st.close();
                       con.close();
                    
                       response.sendRedirect("contact.jsp"); 
              
          }
        
          
          catch(Exception exp)
          {
        	  
             System.out.print("Not" + exp.getMessage());
       
          }
		 
	}

}
