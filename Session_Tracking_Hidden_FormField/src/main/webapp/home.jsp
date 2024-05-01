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
String check =(String)request.getAttribute("check");
if(check!=null)
{
	
%>
<h1>Home Page</h1>

<form action="about.jsp">
<input type="hidden" name="check" value="<%=check%>">
<button>about</button>
</form>
<a href ="logout">Logout</a><br><br>
<%}
else
{
	response.sendRedirect("login.html");
}
%>



</body>
</html>