<%@ page import = "java.io.*,java.util.*" %>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.* "%>
<%
	if(session.getAttribute("login")==null)
	{
		response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>

<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "mydb";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<nav class="navbar navbar-light bg-light">
	<div> Wel come <% out.print(session.getAttribute("username")); %></div>
</nav>
<div class="container">
	<div class="row" >
			<div class="col-sm-3"></div>	
			<div class="col-sm-6">
			<a href="logout.jsp"> Logout</a>
			
					<!-- Start Code of table -->
					<table class="table table-bordered">
						<tr>
						<td>ID<td>
						<td>User name</td>
						<td>Email</td>
						<td>Phone</td>
						<td>Password</td>
						<td> DELETE </td>
						<Td> Edit </Td>
						</tr>
							<%
							try{
							connection = DriverManager.getConnection(connectionUrl+database, userid, password);
							statement=connection.createStatement();
							String sql ="select * from member";
							resultSet = statement.executeQuery(sql);
							while(resultSet.next()){
								int id=Integer.parseInt(resultSet.getString("id"));
							%>
							<tr>
							<td><%=resultSet.getString("id") %></td>
							<td><%=resultSet.getString("username") %></td>
							<td><%=resultSet.getString("email") %></td>
							<td><%=resultSet.getString("mobile") %></td>
							<td><%=resultSet.getString("password") %></td>
							<td><a href=deldata.jsp?id=<%=resultSet.getString("id")%> ><i class='fa fa-trash'></i></a></td>
							<td><a href='edit.jsp?id=<%=resultSet.getString("id")%>'><i class='fa fa-edit'></i></a></td>
							
							</tr>
							<%
							}  
							connection.close();
							} catch (Exception e) {
							e.printStackTrace();
							}
							%>
							</table>
						
						
															
			</div>	
			<div class="col-sm-3"></div>	
	</div>
</div>

</body>
</html>