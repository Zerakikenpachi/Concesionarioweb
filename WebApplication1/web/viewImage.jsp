<%-- 
    Document   : viewImage
    Created on : 20-ago-2018, 15:28:24
    Author     : victor restrepo
--%>

<html> 
     <head> 
         <title> View  Image </title> 
     </head> 
    
     <body> 
    
         <b> View   |   <a   href = "index.jsp" > Upload </a> </b> <br/> <br/> 
        
		 <% String   id   =   request . getParameter ( "id" ) ; %> 
		 <img  src = "getImage.jsp?id= <%= id %> "   width = "400px" /> 
 
     </body> 
 </html> 
