angular.module('myBenefit')
        .controller('listaCellulariController', function ($scope, dataServices, $routeParams, $location,$modal) {
            var callback = function (cellulari) {
                $scope.cellulari = cellulari;

            };

            var error = function (risposta) {
                alert("errore lato server");
            };


            dataServices.ListaCellulari($routeParams.codiceFiscale, callback);

            $scope.VisualizzaContrattiCellulare = function (id) {
                $location.path('/listaContrattiCellulare/' + id);
            };

            $scope.modificaCellulare = function (cellulare) {

                var modalInstance = $modal.open({
                    templateUrl: 'partials/modificacellulare.html',
                    controller: 'dialogoNuovoContrattoTelefonicoController',
                    resolve: {
                        data: function () {
                            return {
                                cellulare: cellulare,
                                titolo: 'Modifica cellulare',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });


                modalInstance.result.then(function (cellulare) {
                    dataServices.modificaCellulare(cellulare, callback, error);
                    toastr.success('Cellulare modificato', 'Beneficium');

                }, function () {
                    toastr.error('Annullata modifica cellulare', 'Beneficium');
                    console.log("Annullata modifica cellulare ");
                });

            };


        });

