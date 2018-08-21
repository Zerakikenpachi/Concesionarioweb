<%-- 
    Document   : newSale
    Created on : 20-ago-2018, 11:09:42
    Author     : victor restrepo
--%>

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
            <form action="AccountServlet?action=insert" method="post">
                <table>
                    <tr>
                        <th> <label><b>Username:</b></label></th>
                        <th><input type="text" placeholder="Enter Username" class="form-control" name="username" required=""/></th>
                    </tr>
                    
                    <tr>
                        <th> <label><b>ID Client:</b></label></th>
                        <th><input type="text" placeholder="Enter Email" class="form-control" name="email" required=""/></th>
                    </tr>
                    <tr>
                        <th> <label><b>Fecha:</b></label></th>
                        <th><input type="text" placeholder="Enter Password" class="form-control" name="password" required=""/></th>
                    </tr>
                    <tr>
                        <th> <label><b>Matricula:</b></label></th>
                        <th><input type="text" placeholder="Enter Direction" class="form-control" name="direccion" required=""/></th>
                    </tr>
                    <tr>
                        <th> <label><b>Valor Pagado:</b></label></th>
                        <th><input type="text" placeholder="Enter Thelephone" class="form-control" name="telefono" required=""/></th>
                    </tr>
                    <tr>
                        <th> <label><b>Devuelta:</b></label></th>
                        <th><input type="text" placeholder="Enter Returned" class="form-control" name="email" required=""/></th>
                    </tr>
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
