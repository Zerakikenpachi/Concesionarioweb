<%-- 
    Document   : newVehicles
    Created on : 20-ago-2018, 11:09:56
    Author     : victor restrepo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Hello World!></h1>
        <div class="container well">
            <form action="VehiclesServlet?action=insert" method="post">
                <table>
                    <tr>
                        <th> <label><b>Matricula:</b></label></th>
                        <th><input type="text" placeholder="Enter Enrollment" class="form-control" name="matricula" required=""/></th>
                    </tr>
                    <tr>
                        <th> <label><b>Marca:</b></label></th>
                        <th><input type="text" placeholder="Enter Brand" class="form-control" name="marca" required=""/></th>
                    </tr>
                    <tr>
                        <th> <label><b>Modelo:</b></label></th>
                        <th><input type="text" placeholder="Enter Model" class="form-control" name="modelo" required=""/></th>
                    </tr>
                    <tr>
                        <th> <label><b>Valor:</b></label></th>
                        <th><input type="text" placeholder="Enter Sale" class="form-control" name="valor" required=""/></th>
                    </tr>
                    <form  action = "uploadImage"   method = "post"   enctype = "multipart/form-data"> 
                        <input  type = "file"   name = "image"   required = ""/><br/><br/> 
                    </form>
                    <div class="break"></div>
                    </div>
                    <tr>
                        <td colspan="2">
                            <input class="btn icon-btn btn-success" type="submit" name="action" value="Insertar">
                            <span class="glyphicon glyphicon-ok-sign"></span>

                            <input class="btn btn-info btn-lg" type="reset" name="action" value="Reset">
                            <span class="glyphicon glyphicon-remove"></span>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
        </div>
    </body>
</html>
