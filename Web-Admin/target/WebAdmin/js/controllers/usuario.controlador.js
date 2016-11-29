angular.module('starter.usuario.controlador', [])

.controller('UsuarioController', ['$scope', 'UsuarioService', 'ListaMensagens',
    function($scope, UsuarioService, ListaMensagens) {

    	$scope.init = function() {

    		$scope.dadosConta = {};
            $scope.nomeUsuario = '';
            $scope.email = '';
            $scope.senha = '';

    	};

    	$scope.criarNovaConta = function() {

           // if(validarCamposConta()) {

                defineDadosConta();

                var solicitacao = UsuarioService.criarConta($scope.dadosConta);

                solicitacao.then(
                    function(resposta) {

                        if(resposta.status === 200) {
                            MensagensService.adicionaMensagem(ListaMensagens.INFO, ListaMensagens.sucessoNovaConta);
                            RedirecionamentosService.redirecionaLogin();
                        }

                    }, function() {
                        $scope.mostraTelaCarregada = true;
                        MensagensService.adicionaMensagem(ListaMensagens.ERRO, ListaMensagens.falhaComunicacao);
                    }

                );

            //} else {
             //   $scope.mostraTelaCarregada = true;
            //}

    	};

        function validarCamposConta() {

            var camposValidos = true;

            if($scope.nomeUsuario === null || $scope.nomeUsuario === undefined || $scope.nomeUsuario.length === 0) {
                MensagensService.adicionaMensagem(ListaMensagens.ERRO, ListaMensagens.campoNomeVazio);
                camposValidos = false;
            }

            if($scope.email === null || $scope.email === undefined || $scope.email.length === 0) {
                MensagensService.adicionaMensagem(ListaMensagens.ERRO, ListaMensagens.campoLoginVazio);
                camposValidos = false;
            }

            if($scope.senha === null || $scope.senha === undefined || $scope.senha.length === 0) {
                MensagensService.adicionaMensagem(ListaMensagens.ERRO, ListaMensagens.campoSenhaVazio);
                camposValidos = false;
            }

            return camposValidos;

        }

    	function defineDadosConta() {
    		$scope.dadosConta = {
    			'nomeUsuario' : $scope.nomeUsuario,
    			'email' : $scope.email,
    			'senha' : $scope.senha
    		};
    	}

    }
]);