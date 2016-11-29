angular.module('app.directives', [])

.directive('blankDirective', [function(){

}]);

app.directive('ngMensagens', ['$rootScope', '$timeout', 'MensagensService' ,
    function($rootScope, $timeout, MensagensService) {

        var timeoutLimparMensagem = 6 * 1000; //6"

        var recuperaClasseMensagem = function(tipo) {
            var classes = 'item item-text-wrap mensagem ';
            switch (tipo) {
            case 'ERRO':
                classes += 'fa fa-times erro form-error';
                break;
            case 'INFO':
                classes += 'sucesso fa fa-check';
                break;
            case 'ALERTA':
                classes += 'alerta fa fa-exclamation-triangle';
                break;
            default:
                classes += 'sucesso fa fa-check';
            }
            return classes;
        };

        var recuperaNomeTipoMensagem = function(tipo) {
            return tipo == 'ERRO' ? 'Erro!' : (tipo == 'INFO' ? 'Sucesso.' : 'Alerta!');
        };

        var somenteValoresUnicos = function(valores) {
            var unico = {};
            var distinto = [];
            valores.forEach(function(obj) {
                if (!unico[obj.texto] || !unico[obj.tipo]) {
                    distinto.push(obj);
                    unico[obj.texto] = true;
                    unico[obj.tipo] = true;
                }
            });
            return  distinto;
        };

        var linkFn = function($scope, element, attrs) {
            var carregaDiretiva = function () {
                $scope.classesCssMensagem = recuperaClasseMensagem;
                $scope.labelMensagem = recuperaNomeTipoMensagem;
                $scope.mostraMensagem = true;

                //Faz um clone para desassociar o model retornado do servico com o apresentado na view, para nao refletir a limpeza na view.
                $scope.mensagens = angular.copy(MensagensService.recuperaMensagens());

                //Tira mensagens repetidas
                $scope.mensagens = somenteValoresUnicos($scope.mensagens);
            };

            carregaDiretiva();

            //Valor default e falso
            var autoEsconde = attrs.autoesconder === undefined ? false : JSON.parse(attrs.autoesconder);

            if (autoEsconde) {
                $timeout(function() {
                    $scope.mostraMensagem = false;
                }, timeoutLimparMensagem);
            }

            $rootScope.$on('$notificaEscondeMensagens', function() {
                $scope.mostraMensagem = false;
            });

            $rootScope.$on('$notificaMostraMensagens', function() {
                carregaDiretiva();
            });
        };

        return {
            restrict: 'EA',
            template: '<div class="mensagens" ng-show="mostraMensagem">' +
                        '<div class="form-errors">'+
                            '<div ng-repeat="mensagem in mensagens" class="mensagem-tipo">' +
                                '<div class="{{classesCssMensagem(mensagem.tipo)}}">' + //TODO Designer ajustar esse ponto
                                    '<span>{{labelMensagem(mensagem.tipo)}} </span>{{mensagem.texto}}'+
                                '</div>' +
                            '</div>' +
                        '</div>' +
                    '</div>',
            link : linkFn
        };
    }
]);

	