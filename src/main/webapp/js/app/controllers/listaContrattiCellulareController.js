angular.module('myBenefit')

        .controller('listaContrattiCellulareController', function ($modal,$scope, dataServices, $routeParams) {
            var callback = function (risposta) {
                if (risposta.status)
                    $scope.contratticellulare = risposta.oggetto;
                else
                    toastr.error(risposta.messaggio);


            };
            
            var callbackmodificaContrattoCellulare = function (risposta) {
             toastr.success('Modificato contratto telefonico', 'Beneficium');
            };


            var error = function (risposta) {
                toastr.error("Non verrò mai eseguito!");
            };


           dataServices.ListaContrattiCellulare($routeParams.id, callback);
            
           
           $scope.modificaContrattoCellulare = function (contrattocellulare) {


                var modalInstance = $modal.open({
                    templateUrl: 'partials/modificacontrattocellulare.html',
                    controller: 'dialogoNuovoContrattoTelefonicoController',
                    resolve: {
                        data: function () {
                            return {
                                contrattocellulare: contrattocellulare,
                                titolo: 'Modifica contratto telefonico',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });


                modalInstance.result.then(function (contrattocellulare) {
                    
                    dataServices.aggiungiContrattoTelefonico(contrattocellulare, callbackmodificaContrattoCellulare, error);
                  
                }, function () {
                    toastr.error('Annullata modifica contratto telefonico', 'Beneficium');
                    console.log("Annullata modifica contratto ");
                });

            };
        });

 
