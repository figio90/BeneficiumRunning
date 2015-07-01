angular.module('myBenefit').factory('dialogServices', function($modal){
    var attivaDialog = function(messaggio, titolo, bottoni) {
        var modalInstance = $modal.open({
                templateUrl: 'partials/dialogo-conferma.html',
                controller: 'dialogoConfermaController',
             
                resolve: {
                    data: function() {
                        return {
                            messaggio: messaggio,
                            titolo: titolo,
                            buttons: bottoni
                        };
                    }
                },
                size: 'sm'
            });
            return modalInstance.result;
    };
    
    
    
    return {
        attivaDialog : attivaDialog
    };
});