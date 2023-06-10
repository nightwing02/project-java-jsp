<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
	
	String id=request.getParameter("id");
	int no=Integer.parseInt(id);
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");  
	
	Statement stat=con.createStatement();
	stat.executeUpdate("delete from member where id="+ no);
	
	response.sendRedirect("homepage.jsp");
	
%>
