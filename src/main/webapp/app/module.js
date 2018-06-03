(function(){

    angular.module('app', [
        'ui.router'
    ]);

    angular.module('app').config(AppConfig);

    AppConfig.$inject = ['$stateProvider'];

    function AppConfig($stateProvider) {

        $stateProvider
            .state({
                name: 'produtos',
                templateUrl: 'index.html',
                controller: 'ProdutoController',
                controllerAs: 'vm'
            });

    }

})();
