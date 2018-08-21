<%-- 
    Document   : listVehicles
    Created on : 20-ago-2018, 11:08:42
    Author     : victor restrepo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>JSP Page</title>
</head>

<jsp:include page="menu.jsp"></jsp:include>
    <h1>Hello World!</h1>
<c:forEach var="a" items="${vehicles}">
    |${a.enrollment}| |${a.brand}| |${a.model}| |${a.valor}|
    <a onclick="return confirm('Esta seguro?')" href="VehiclesServlet?action=delete&id=${a.enrollment}">Delete</a>
    <hr/>
</c:forEach>
