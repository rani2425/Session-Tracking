<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
String check =(String)request.getParameter("check");
if(check!=null)
{
	

%>
<h1>Home Page</h1>
<a href ="logout">Logout</a><br><br>
<a href ="about.jsp?check="+<%=check %>>about</a>
<%}
else
{
	response.sendRedirect("login.html");
}
%>



</body>
</html>