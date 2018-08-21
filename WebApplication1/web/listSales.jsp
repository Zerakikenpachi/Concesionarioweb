<%-- 
    Document   : listSales
    Created on : 20-ago-2018, 11:08:28
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
<c:forEach var="a" items="${sales}">
    |${a.id}| |${a.client}| |${a.enrollment}| |${a.payment}| |${a.giveback}| 
    <a onclick="return confirm('Esta seguro?')" href="SaleServlet?action=delete&id=${a.id}">Delete</a>
    <hr/>
</c:forEach>
