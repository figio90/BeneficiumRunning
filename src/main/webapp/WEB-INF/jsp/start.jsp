<%-- 
    Document   : jsp
    Created on : May 5, 2015, 2:18:47 PM
    Author     : ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        
         <link href="${pageContext.request.contextPath}/css/newcss.css" rel="stylesheet">
        
        <title>JSP Page</title>

        <title>Beneficium</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/miocss.css" rel="stylesheet" media="screen">

    </head>
    <body id="sfondo">
        <div class="container">
            <div class="row">
                <div class="header col-md-12">
                    <h1>Beneficium</h1>
                    <h5>Gestione benefit CSP</h5>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12"><h3> </h3></div>
            </div>
            <div class="row">
                <div class="col-md-9"></div>
                <div class="barradestra col-md-3">
                    <h2>Benvenuto!</h2>
                    <form:form action = "login.do" commandName="utente">
                        <div class="form-group">
                            <label for="inputUsername">Username</label>
                            <!--input type="text" class="form-control" id="inputUsername" placeholder="Username" name="username"-->
                            <form:input path="username" cssClass="form-control" id="inputUsername" placeholder="Username"/>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Password</label>
                            <!--input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password"-->
                            <form:input path="password" cssClass="form-control" id="inputPassword" placeholder="Password"/>
                        </div>
                        <button type="submit" class="btn btn-default">Login</button>
                        <form:errors path="*" element="div"/>
                    </form:form>    
                    ${messaggio}
                </div>
            </div>
        </div>
    </body>
</html>
