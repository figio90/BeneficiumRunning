angular.module('myBenefit')
        .controller('loginCtrl', function ($scope, dataServices, $location) {
            var callback = function (risposta) {
                if (risposta.status === false) {

                    toastr.error('Credenziali errate', 'Beneficium');
                    $location.path('/login');
                }
                else {
                    var user = $scope.user;
                    toastr.success('Benvenuto ' + $scope.user.username, 'Beneficium');
                    $location.path('/listadipendentijson');
                }
            };

            var error = function (risposta) {
                alert("errore lato server");
            };

            $scope.login = function () {
                dataServices.login($scope.user, callback, error);

            };

            $scope.azioneEnter = function (event)
            {
                if (event.charCode == 13) //if enter then hit the search button
                    $scope.login();
            };



        });


   