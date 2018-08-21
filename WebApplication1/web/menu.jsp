<%-- 
    Document   : menu
    Created on : 20-ago-2018, 11:09:15
    Author     : victor restrepo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty login}">
    |<a href="login.jsp">Login</a>|
    |<a href="newClient.jsp">Register</a>|
    |<a href="newVehicles.jsp">Register Vehicles</a>|
    |<a href="newSale.jsp">Register Sales</a>|
</c:if>
<c:if test="${not empty login}">
    |<a href="ClientServlet?action=logout">Logout</a>|
    |<a href="ClientServlet?action=list">List Clients</a>|
    |<a href="VehiclesServlet?action=list">List Vehicles</a>|
    |<a href="SaleServlet?action=list">List Sales</a>|
</c:if>
|<a href="about.jsp">About</a>|
<hr/>
