angular.module('myBenefit')
        .controller('cellulareController', function ($modal, $scope, dataServices, dialogServices, $location) {
            var callback = function (cellulari) {
                $scope.cellulari = cellulari;
            };

             var error = function (risposta) {
                alert("errore lato server");
            };
            

            dataServices.listatutticellularijson(callback);
            

            
           
        });
