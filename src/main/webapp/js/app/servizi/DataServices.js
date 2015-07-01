angular.module('myBenefit').factory('dataServices', function ($http) {
    var login = function (user, callback, error) {
        $http({data: user, method: 'POST', url: 'login.do'})
                .success(function (risposta, status, headers, config) {
                    callback(risposta)
                })
                .error(function (rispostastatus, headers, config) {
                    error(rispostastatus);
                });
    };
    var listadipendentijson = function (callback) {
        $http.get('listadipendentijson.do').success(function (risposta,status,header,config) {
            callback(risposta);
        });
    };
    var salva = function (dipendente, callback, error) {
        $http({data: dipendente, method: 'POST', url: 'inseriscidipendentejson.do'})
                .success(function (risposta, status, headers, config) {
                    callback(risposta);
                })
                .error(function (risposta,status, headers, config) {
                    error(rispostastatus);
                });
    };

    var salvaAuto = function (automobile, callback, error) {
        var auto = {};
        auto.dipendente = {};
        auto.dipendente.codiceFiscale = automobile.codiceFiscale;

        auto.idAuto = automobile.idAuto;
        auto.targa = automobile.targa;
        auto.modello = automobile.modello;
        $http({data: auto, method: 'POST', url: 'inserisciauto.do'});
    };


    var aggiungiContrattoTelefonico = function (nuovoContratto, callback,error) {
        console.log(nuovoContratto);
        $http({data: nuovoContratto, method: 'POST', url: 'inseriscicontrattojson.do'})
                .success(function (risposta, status, headers, config) {
                    callback(risposta);
                })
                .error(function (rispostastatus, headers, config) {
                    error(rispostastatus);
                });
    };
    var aggiungiContrattoAuto = function (contrattoAuto, callback,error) {
//        contrattoAuto.automobile.dipendente = {};
//        contrattoAuto.automobile.dipendente.codiceFiscale = codiceFiscale;
        console.log(contrattoAuto);
        $http({data: contrattoAuto, method: 'POST', url: 'salvacontratto.do'})
         .success(function (risposta, status, headers, config) {
                    callback(risposta);
                })
                .error(function (rispostastatus, headers, config) {
                    error(rispostastatus);
                });
    };

    var modificaContrattoAuto = function (contrattoAuto, codiceFiscale) {
        var contratto = {};
        contratto.automobile = {};
        contratto.automobile.dipendente = {};
        contratto.automobile.dipendente.codiceFiscale = contrattoAuto.codiceFiscale;
        contratto.automobile.idAuto = contrattoAuto.idAuto;
        contratto.idContratto = contrattoAuto.idContratto;
        contratto.dataAttivazione = contrattoAuto.dataAttivazione;
        contratto.dataScadenza = contrattoAuto.dataScadenza;
        contratto.costoNoleggio = contrattoAuto.costoNoleggio;
        contratto.costoServizi = contrattoAuto.costoServizi;
        contratto.kilometriContratto = contrattoAuto.kilometriContratto;
        contratto.societaLeasing = contrattoAuto.societaLeasing;
        contratto.automobile.targa = contrattoAuto.targa;
        contratto.automobile.modello = contrattoAuto.modello;
        console.log(contratto);
        $http({data: contratto, method: 'POST', url: 'salvacontratto.do'});
    };

    var modificaCellulare = function (cellulare, codiceFiscale) {

        $http({data: cellulare, method: 'POST', url: 'salvacellulare.do'});
    };


    var modificaContrattoTelefonico = function (nuovoContratto, callback, error) {
        
        var contratto = {};
        contratto.cellulare={};
        contratto.cellulare.dipendente = {};
        contratto.cellulare.dipendente.codiceFiscale = nuovoContratto.cellulare.dipendente.codiceFiscale;
        contratto.cellulare.id=nuovoContratto.cellulare.id;
        contratto.costoBimestrale=nuovoContratto.costoBimestrale;
        contratto.profiloContratto=nuovoContratto.profiloContratto;
        contratto.tipoContratto=nuovoContratto.tipoContratto;
        contratto.dataAttivazione=nuovoContratto.dataAttivazione;
        contratto.dataScadenza=nuovoContratto.dataScadenza;
        
        console.log(contratto);
        $http({data: contratto, method: 'POST', url: 'inseriscicontrattojson.do'});
    };



    var ListaAuto = function (codiceFiscale, callback) {

        $http.get('listaauto.do?codiceFiscale=' + codiceFiscale).success(function (automobili) {
            callback(automobili);
        });
    };


    var ListaCellulari = function (codiceFiscale, callback) {

        $http.get('listacellulari.do?codiceFiscale=' + codiceFiscale).success(function (cellulari) {
            callback(cellulari);
        });
    };



    var logout = function () {
        $http({method: 'GET', url: 'logout.do'})
                .success(function (risposta, status, headers, config) {
                    callback(risposta);
                })
                .error(function (rispostastatus, headers, config) {
                    error(rispostastatus);
                });
    };

    var ListaContrattiAuto = function (id, callback) {

        $http.get('ListaContrattiAuto.do?id=' + id).success(function (automobili) {
            callback(automobili);
        });
    };

    var ListaContrattiCellulare = function (id, callback) {

        $http.get('ListaContrattiCellulare.do?id=' + id).success(function (cellulari) {
            callback(cellulari);
        });
    };

    return{
        login: login,
        listadipendentijson: listadipendentijson,
        aggiungiContrattoTelefonico: aggiungiContrattoTelefonico,
        aggiungiContrattoAuto: aggiungiContrattoAuto,
        ListaAuto: ListaAuto,
        ListaCellulari: ListaCellulari,
        salva: salva,
        ListaContrattiAuto: ListaContrattiAuto,
        ListaContrattiCellulare: ListaContrattiCellulare,
        salvaAuto: salvaAuto,
        modificaContrattoAuto: modificaContrattoAuto,
        modificaCellulare: modificaCellulare,
        modificaContrattoTelefonico:modificaContrattoTelefonico,
        logout: logout

    };
});