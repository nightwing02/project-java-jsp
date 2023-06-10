

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Update2
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Update2" })
public class Update2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int id=Integer.parseInt(request.getParameter("xid"));
		String user=request.getParameter("xuser");
		String mail=request.getParameter("xmail");
		String phone=request.getParameter("xphone");
		String password=request.getParameter("xpass");
	
		  HttpSession session=request.getSession();  
		
		  try
          {
            
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");  
			Statement stat;
			  PreparedStatement st = con.prepareStatement("update member set user=? where phone=?");
              
             // st.setString(1,request.getParameter("xid"));
              st.setString(2,request.getParameter("xuser"));
              st.setString(3,request.getParameter("xmail"));   
              st.setString(4,request.getParameter("xphone"));
              st.setString(5,request.getParameter("xpass"));
              st.executeUpdate();
              st.close();
              con.close();
          }
          catch(Exception exp)
          {
        	  String st=exp.getMessage();
             System.out.print("Not" + exp.getMessage());
          }
		  
		
		  
		
	}
}


