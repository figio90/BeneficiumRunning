angular.module('myBenefit')
        .controller('dialogoNuovoContrattoAutoController', function ($modalInstance, $scope, dataServices, data) {

//            var callback = function (contrattiauto) {
//                $scope.contrattiauto = contrattiauto;
//            };
//
//            var error = function (risposta) {
//                alert("errore lato server");
//            };
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
                $scope.contrattoAuto.automobile.dipendente = {};
                $scope.contrattoAuto.automobile.dipendente.codiceFiscale = data.codiceFiscale;
                
                $modalInstance.close($scope.contrattoAuto);

            };


            $scope.modificaAuto = function () {

                $modalInstance.close($scope.data.automobile);

            };
            $scope.modificaContrattoAuto = function () {
                $modalInstance.close($scope.data.contrattoAuto);

            };
        });



