<%-- 
    Document   : formDipendente
    Created on : 12-mag-2015, 14.45.00
    Author     : corsojava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h3>Hello World!</h3>

        <form:form action="inserisciDipendente.do" commandName="dip">

            CODICE FISCALE: <form:input path="codiceFiscale" /> </br>
            NOME <form:input path="nome" /> </br>
            COGNOME <form:input path="cognome"/> </br>
            INDIRIZZO: <form:input path="indirizzo" /> </br>
            STIPENDIO MENSILE: <form:input path="stipendioMensile" /> </br>
            
            <input type="submit" value="salva"/> </br>

            ${messaggio}

        </form:form>
    </body>

</html>
