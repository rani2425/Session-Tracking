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
Cookie cookies[]=request.getCookies();
String check=null;
if(cookies!=null)
{
	for(Cookie c:cookies)
	{
		if(c.getName().equals("check"))
		{
			check=c.getValue();
		}
	}
}
if(check!=null)
{
	

%>
<h1>Home Page</h1>
<a href ="logout">Logout</a>
<%
}
else
{
	response.sendRedirect("login.html");
}
%>



</body>
</html>