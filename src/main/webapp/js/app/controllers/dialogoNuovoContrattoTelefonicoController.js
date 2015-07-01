angular.module('myBenefit')
        .controller('dialogoNuovoContrattoTelefonicoController', function ($modalInstance, $scope, dataServices, data) {

         


            $scope.data = data;

            $scope.opened = false;

            $scope.open = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();
                $scope.opened = true;
            };


            $scope.opened2 = false;

            $scope.open2 = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();
                $scope.opened2 = true;
            };

            $scope.cancel = function () {
                $modalInstance.dismiss();
            };


            $scope.aggiungiContratto = function () {
                $scope.nuovoContratto.cellulare.dipendente = {};
                $scope.nuovoContratto.cellulare.dipendente.codiceFiscale = data.codiceFiscale;
                
                $modalInstance.close($scope.nuovoContratto);

            };
            

            $scope.modificaDatiCellulare = function () {

                $modalInstance.close($scope.data.cellulare);

            };
            
            
            $scope.modificaContrattoTelefonico = function () {
                
                $modalInstance.close($scope.data.contrattocellulare);

            };
            
        });



