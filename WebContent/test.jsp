<%@page import="com.vo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="handleErrorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<h2 align="center">Test Page</h2>
		
		CustomerDetails:<br>
		
		<%
				
			//Customer customer = (Customer)request.getAttribute("customer");
			//Customer customer = (Customer)pageContext.getAttribute("customer",PageContext.REQUEST_SCOPE);
			
		%>
		
		<jsp:useBean id="customer" type="com.vo.Customer" scope="request"></jsp:useBean>
		
		CustomerId   :<jsp:getProperty property="id" name="customer"/> <br>
		CustomerName :  <jsp:getProperty property="name" name="customer"/><br>

</body>
</html>