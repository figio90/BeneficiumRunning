angular.module('myBenefit').config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
                .when('/login', {
                    templateUrl: 'partials/login.html',
                    controller: 'loginCtrl'
                }).
                when('/listadipendentijson', {
                    templateUrl: 'partials/listadipendenti.html',
                    controller: 'dipCtrl'
                }).
                when('/logout', {
                    templateUrl: 'partials/login.html',
                    controller: 'logoutController'
                }).
                when('/inseriscidipendentejson', {
                    templateUrl: 'partials/nuovo-dipendente.html',
                    controller: 'dipCtrl'
                }).
                when('/inseriscicontrattojson', {
                    templateUrl: 'partials/listadipendenti.html',
                    controller: 'dialogoNuovoContrattoTelefonicoController'
                }).
                when('/salvacontratto', {
                    templateUrl: 'partials/nuovoContrattoAuto.html',
                    controller: 'dialogoNuovoContrattoAutoController'
                }).
                when('/listaauto/:codiceFiscale', {
                    templateUrl: 'partials/listaAuto.html',
                    controller: 'listaAutoController'
                }).
                when('/listacellulari/:codiceFiscale', {
                    templateUrl: 'partials/listaCellulari.html',
                    controller: 'listaCellulariController'
                }).
                when('/listaContrattiAuto/:id', {
                    templateUrl: 'partials/listaContrattiAuto.html',
                    controller: 'listaContrattiAutoController'
                }).
                when('/listaContrattiCellulare/:id', {
                    templateUrl: 'partials/listaContrattiCellulare.html',
                    controller: 'listaContrattiCellulareController'
                }).
//                when('/inserisciauto', {
//                    templateUrl: 'partials/modificaauto.html',
//                    controller: 'dialogoNuovoContrattoAutoController'
//                }).

//                when('/modificacontratto', {
//                    templateUrl: 'partials/modificacontrattoauto.html',
//                    controller: 'dialogoNuovoContrattoAutoController'
//                }).
                otherwise({
                    redirectTo: '/login'
                });
    }


]);

