<%-- 
    Document   : getImage
    Created on : 20-ago-2018, 15:30:41
    Author     : victor restrepo
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

 <% 
 String   id   =   request . getParameter ( "id" ) ; 
 
 String   connectionURL   =   "jdbc:mysql://localhost:3306/dbconcesionario?zeroDateTimeBehavior=convertToNull" ; 
 String   user   =   "newuser" ; 
 String   pass   =   "Tatsumi11" ; 
 
 Connection   con   =   null ; 
 
 try { 
     Class . forName ( "com.mysql.jdbc.Driver" ) ; 
     con   =   DriverManager . getConnection ( connectionURL ,   user ,   pass ) ; 
    
     PreparedStatement   ps   =   con . prepareStatement ( "select * from data where id=?" ) ; 
     ps . setString ( 1 ,   id ) ; 
     ResultSet   rs   =   ps . executeQuery ( ) ; 
 
     if ( rs . next ( ) ) { 
         Blob   blob   =   rs . getBlob ( "image" ) ; 
         byte   byteArray [ ]   =   blob . getBytes ( 1 ,   ( int ) blob . length ( ) ) ; 
 
         response . setContentType ( "image/gif" ) ; 
         OutputStream   os   =   response . getOutputStream ( ) ; 
         os . write ( byteArray ) ; 
         os . flush ( ) ; 
         os . close ( ) ; 
     } 
 } 
 catch ( Exception   e ) { 
     e . printStackTrace ( ) ; 
 }    
 finally { 
     if ( con   !=   null ) { 
         try { 
             con . close ( ) ; 
         } 
         catch ( Exception   e ) { 
             e . printStackTrace ( ) ; 
         } 
     } 
 } 
 %> 
