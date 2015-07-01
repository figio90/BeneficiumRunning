angular.module('myBenefit')
        .controller('listaContrattiAutoController', function ($scope, dataServices, $routeParams,$modal) {
            var callback = function (contrattiauto) {
                $scope.contrattiauto = contrattiauto;
//                var i=0;
//while($scope.contrattiauto[i]!==undefined){
//    var somma = new BigNumber($scope.contrattiauto[i].costoNoleggio).add($scope.contrattiauto[i].costoServizi);
//    $scope.contrattiauto[i].costoTotale= somma;
//    i++;
//}

            };

            var error = function (risposta) {
                alert("errore lato server");
            };


            dataServices.ListaContrattiAuto($routeParams.id, callback);
            
            $scope.modificaContratto = function (contrattoAuto) {

                var modalInstance = $modal.open({
                    templateUrl: 'partials/modificacontrattoauto.html',
                    controller: 'dialogoNuovoContrattoAutoController',
                    resolve: {
                        data: function () {
                            return {
                                contrattoAuto: contrattoAuto,
                                titolo: 'Modifica contratto leasing',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });


                modalInstance.result.then(function (contrattiauto) {
                    
                    dataServices.modificaContrattoAuto(contrattiauto, callback, error);
                    toastr.success('Contratto leasing modificato', 'Beneficium');

                }, function () {
                    toastr.error('Annullata modifica contratto leasing', 'Beneficium');
                    console.log("Annullata modifica contratto ");
                });

            };

        });

