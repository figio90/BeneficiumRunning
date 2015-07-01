angular.module('myBenefit')
        .controller('logoutController', function ($scope, dataServices, $location) {
            
//            
//            var callback = function (risposta) {
//                if (risposta.status === true) {
//                    toastr.success('Logout eseguito');
//                    $location.path('/login');
//                }
//                else {
//                    // ToASTR 
//                    toastr.error('attenzione! La sessione non si è chiusa correttamente, riprovare')
//
//                    $location.path('/listadipendentijson');
//                }
//            };

            $scope.logout = function () {
                dataServices.logout($scope.user);
                $location.path('/login');
             
                toastr.success('Logout eseguito', 'Beneficium');
            };
        });