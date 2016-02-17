<%@page import="com.vo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>


	<% 
		
	//	Customer customer = new Customer(101,"Hary");
	
		//request.setAttribute("customer",customer);
		
		//pageContext.setAttribute("customer",customer,PageContext.REQUEST_SCOPE);
	
	//	RequestDispatcher requestDispatcher = request.getRequestDispatcher("test.jsp");
	
	//	requestDispatcher.forward(request, response);
	
//		pageContext.forward("test.jsp");
	
	%>
	
	<jsp:useBean id="customer" class="com.vo.Customer" scope="request"></jsp:useBean>
	
	<jsp:setProperty property="id" name="customer" value="101"/>
	<jsp:setProperty property="name" name="customer" value="Raj"/>
	
	<jsp:forward page="test.jsp"></jsp:forward>
</body>
</html>