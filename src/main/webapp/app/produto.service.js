(function(){
    'use strict'

    angular.module('app')
      .service('ProdutoService', ProdutoService);

    ProdutoService.$inject = ['$http'];

    function ProdutoService($http) {

        function findAll() {
            return $http.get('http://localhost:8090/api/produtos')
              .then(function(response) {
                return response.data;
              });
        }

        function insert(registro) {
            return $http.post('http://localhost:8090/api/produtos', registro)
              .then(function (response) {
                  return response.data;
              });
        }

        function update(registro) {
            return $http.put('http://localhost:8090/api/produtos/' + registro.id, registro)
            .then(function (response) {
                return response.data;
            });
        }
            
        function remove(id) {
            return $http.delete('http://localhost:8090/api/produtos/' + id)
            .then(function (response) {
                return response.data;
            });
        }

        return {
            findAll: findAll,
            insert: insert,
            update: update,
            remove: remove
        }

    }

})();