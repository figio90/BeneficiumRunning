<%-- 
    Document   : inseriscicellulare
    Created on : 12-mag-2015, 14.30.59
    Author     : corsojava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserimento cellulare</title>
    </head>
    <body>
        <h3>Inserimento cellulare associato a dipendente</h3>
        <form:form action="inseriscicontrattojson.do" commandName="contratto"> 
            Numero cel:<form:input path="cellulare.numero" /> <br />
            NumeroSim: <form:input path="cellulare.numeroSim" /> <br />
            Modello:   <form:input path="cellulare.modello" /> <br />
            Costo Bimestrale:   <form:input path="costoBimestrale" /> <br />
            Profilo Contratto:   <form:input path="profiloContratto" /> <br />                 
            Tipo Contratto:   <form:input path="tipoContratto" /> <br />
            <input type="submit" value="Salva "/> 
            <form:errors path="*" element="div"/>
        </form:form>

        ${messaggio}

    </body>
</html>
