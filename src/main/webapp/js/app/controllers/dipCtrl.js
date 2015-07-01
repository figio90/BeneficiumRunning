angular.module('myBenefit')
        .controller('dipCtrl', function ($modal, $scope, dataServices, dialogServices, $location) {
            var callbacknuovodipendente = function (risposta) {
                $scope.dipendenti = risposta.oggetto;
                toastr.success('Aggiunto nuovo dipendente', 'Beneficium');
            };
            
            var callbackmodificadipendente = function (risposta) {
                $scope.dipendenti = risposta.oggetto;
                toastr.success('Modificato il dipendente', 'Beneficium');
            };

            var callbacklistadipendenti = function (risposta) {
                $scope.dipendenti = risposta.oggetto;
                $location.path("/listadipendentijson");
            };

            var callbacknuovocontratto = function (risposta) {
                toastr.success('Contratto telefonico inserito', 'Beneficium');
            };

            var callbacknuovocontrattoAuto = function (risposta) {
               toastr.success('Contratto leasing inserito', 'Beneficium');
            };

            var error = function (risposta) {
                // TOAST di errore
                // risposta.oggetto
                // risposta.messaggio
                alert("errore lato server");
            };


            dataServices.listadipendentijson(callbacklistadipendenti);


            $scope.AggiungiContrattoTelefonico = function (codiceFiscale) {
                var modalInstance = $modal.open({
                    templateUrl: 'partials/nuovoContrattoTelefonico.html',
                    controller: 'dialogoNuovoContrattoTelefonicoController',
                    resolve: {
                        data: function () {
                            return {
                                codiceFiscale: codiceFiscale,
                                titolo: 'Nuovo contratto telefonico',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });

                modalInstance.result.then(function (contratto) {

                    // salvataggio del contratto telefonico
                    dataServices.aggiungiContrattoTelefonico(contratto, callbacknuovocontratto, error);

                }, function () {
                    toastr.error('Annullato inserimento contratto telefonico', 'Beneficium');
                });
            };



            $scope.AggiungiContrattoAuto = function (codiceFiscale) {

                var modalInstance = $modal.open({
                    templateUrl: 'partials/nuovoContrattoAuto.html',
                    controller: 'dialogoNuovoContrattoAutoController',
                    resolve: {
                        data: function () {
                            return {
                                codiceFiscale: codiceFiscale,
                                titolo: 'Nuovo contratto leasing',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });

                modalInstance.result.then(function (contrattoAuto) {

                    // salvataggio del contratto auto
                    dataServices.aggiungiContrattoAuto(contrattoAuto, callbacknuovocontrattoAuto, error);
                    
                }, function () {
                    toastr.error('Annullato inserimento contratto leasing', 'Beneficium');
                });
            };

            $scope.aggiungiDipendente = function () {
                var modalInstance = $modal.open({
                    templateUrl: 'partials/nuovo-dipendente.html',
                    controller: 'dialogoNuovoDipendenteController',
                    resolve: {
                        data: function () {
                            return {
                                titolo: 'Nuovo dipendente',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });
                modalInstance.result.then(function (dipendente) {
                    dataServices.salva(dipendente, callbacknuovodipendente, error);
                    

                }, function () {
                    toastr.error('Annullato inserimento dipendente ', 'Beneficium');
                });
            };

            $scope.modificaDipendente = function (dipendente) {

                var modalInstance = $modal.open({
                    templateUrl: 'partials/modificadipendente.html',
                    controller: 'dialogoNuovoDipendenteController',
                    resolve: {
                        data: function () {
                            return {
                                dipendente: dipendente,
                                titolo: 'Modifica dipendente',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });


                modalInstance.result.then(function (dipendente) {
                    dataServices.salva(dipendente, callbackmodificadipendente, error);
                        

                }, function () {
                    toastr.error('Annullata modifica dipendente', 'Beneficium');
                    console.log("Annullato modifica dipendente");
                });

            };

            $scope.visualizzaAuto = function (codiceFiscale) {
                $location.path('/listaauto/' + codiceFiscale);
            };

            $scope.VisualizzaCellulari = function (codiceFiscale) {
                $location.path('/listacellulari/' + codiceFiscale);
            };


        });