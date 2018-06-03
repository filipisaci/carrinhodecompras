(function() {

    angular.module('app')
      .controller('ProdutoController', ProdutoController);

    ProdutoController.$inject = ['ProdutoService'];

    function ProdutoController(ProdutoService) {

        var vm = this;
        vm.registro = {}
        vm.total = 0;
        vm.salvar = salvar;

        function salvar() {
            vm.registro.total = vm.registro.quantidade * vm.registro.preco;
            if (!vm.registro.id) {
              ProdutoService.insert(vm.registro)
                .then(function(dado){
                  vm.registro = {};
                  load();
                })
            } else {
              ProdutoService.update(vm.registro)
                .then(function(dado){
                    vm.registro = {};
                    load();
                })
            }
        }
        
        vm.editar = function editar(item) {
            vm.registro = angular.copy(item); 
        };

        vm.excluir = function(item) {
            ProdutoService.remove(item.id)
            .then(function () {
                load();
            });
            
        };

        function load() {
            vm.total = 0;
            ProdutoService.findAll()
            .then(function (dados) {
                vm.registros = dados;
                vm.registros.forEach(elemento => {
                    vm.total += elemento.total;
                });
            });
        }

        load();

    }

})();