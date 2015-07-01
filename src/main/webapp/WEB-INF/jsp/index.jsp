<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html ng-app="dipendentiController">
    <head>
        <title>Lista dipendenti</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body ng-controller="dipCtrl">
        <h3>Lista Dipendenti</h3>
        <table border=1>
            <thead>
            <th>CODICE FISCALE</th>
            <th>NOME</th>
            <th>COGNOME</th>
            <th>INDIRIZZO</th>
            <th>STIPENDIO MENSILE</th>
            </thead>
            <tr ng-repeat="dipendente in dipendenti">
                <td>{{dipendente.codiceFiscale}}</td>
                <td>{{dipendente.nome}}</td>
                <td>{{dipendente.cognome}}</td>
                <td>{{dipendente.indirizzo}}</td>
                 <td>{{dipendente.stipendioMensile}}</td>
                 <td><input type="button" value="Visualizza Auto" ng-Click="gestioneAuto()"/></td>
                 <td><input type="button" value="Visualizza Cellulare"/></td>
              
            </tr>
        </table>
        <script src="js/lib/angular.min.js"></script>
        <script src="js/app/servizi/app.js"></script>
        <script src="js/app/controllers/DipendentiController.js"></script>
    </body>
</html>
