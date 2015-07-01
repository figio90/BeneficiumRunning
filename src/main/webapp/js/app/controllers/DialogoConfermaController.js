angular.module('myBenefit')
        .controller('dialogoConfermaController',function($modalInstance, $scope, data){
           $scope.properties = data;
           
           $scope.confermaAzione = function() {
               $modalInstance.close();
           };
           
           $scope.annullaAzione = function() {
               $modalInstance.dismiss();
           };
            
        });

