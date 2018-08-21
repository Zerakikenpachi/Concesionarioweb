<%-- 
    Document   : result
    Created on : 20-ago-2018, 16:57:40
    Author     : victor restrepo
--%>

<% 
 String   message   =   request . getParameter ( "message" ) ; 
 if ( message   !=   null ) { 
	 out . print ( message ) ; 
 } 
 %>
