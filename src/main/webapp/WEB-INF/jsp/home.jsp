<%-- 
    Document   : home
    Created on : 12-mag-2015, 14.42.55
    Author     : dave
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="${pageContext.request.contextPath}/css/newcss.css" rel="stylesheet">
        
        <title>JSP Page</title>
    </head>
 
    <body
         
        <h1>Home!</h1>
        ${utente.username}
    </body>
</html>
