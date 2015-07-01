<%-- 
    Document   : inserisciAutomobile
    Created on : 12-mag-2015, 14.33.02
    Author     : luca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inserisci automobile</h1>
        <form:form action = "salvacontratto.do" commandName="contratto">

            TARGA: <form:input path="automobile.targa" /> <br>
            MODELLO: <form:input path="automobile.modello" /> <br>
            
            
            DATA ATTIVAZIONE <form:input path="dataAttivazione" /> <br>
            DATA SCANDENZA <form:input path="dataScadenza" /> <br>
            COSTO NOLEGGIO <form:input path="costoNoleggio" /> <br>
            COSTO SERVIZI <form:input path="costoServizi" /> <br>
            KILOMETRI CONTRATTO <form:input path="kilometriContratto" /> <br>
            SOCIETÀ LEASING <form:input path="societaLeasing" /> <br>
            

            <input type="submit" value="Inserisci" />
            <form:errors path="*" element="div" />
        </form:form>
        ${messaggio}

    </body>
</html>
