<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>

<%
	
	int id=Integer.parseInt(request.getParameter("id"));
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");  
	Statement stat=con.createStatement();
	ResultSet rs= stat.executeQuery("select * from member where id=" + id);
	rs.next();
	
	String user=request.getParameter("xuser");
	String mail=request.getParameter("xmail");
	String phone=request.getParameter("xphone");
	String password=request.getParameter("xpass");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<form action="Update2.jsp" method="post">
		<input type="hidden" name="xid" value="<% out.print(id); %>"/><br/>
		<label> USer Name </label>
		<input type="text" name="xuser" value="<% out.print(user); %>"/><br/>
		<label>Email</label>
		<input type="text" name="xmail"  value="<% out.print(mail); %>" /><br/>
		<label>phone</label>
		<input type="text" name="xphone"  value="<% out.print(phone); %>"/><br/>
		<label>Password</label>
		<input type="password" name="xpass"  value="<% out.print(password); %>"/><br/>
		<br/>
		<input type="submit" value="submit" name="xsub"/>
	</form>	

</body>
</html>
