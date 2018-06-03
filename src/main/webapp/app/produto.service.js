(function(){
    'use strict'

    angular.module('app')
      .service('ProdutoService', ProdutoService);

    ProdutoService.$inject = ['$http'];

    function ProdutoService($http) {

        function findAll() {
            return $http.get('https://carrinhodecompra10.herokuapp.com/api/produtos')
              .then(function(response) {
                return response.data;
              });
        }

        function insert(registro) {
            return $http.post('https://carrinhodecompra10.herokuapp.com/api/produtos', registro)
              .then(function (response) {
                  return response.data;
              });
        }

        function update(registro) {
            return $http.put('https://carrinhodecompra10.herokuapp.com/api/produtos/' + registro.id, registro)
            .then(function (response) {
                return response.data;
            });
        }
            
        function remove(id) {
            return $http.delete('https://carrinhodecompra10.herokuapp.com/api/produtos/' + id)
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