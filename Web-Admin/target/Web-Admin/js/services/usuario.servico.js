angular.module('starter.usuario.servico', [])

.factory('UsuarioService', ['AjaxService',
    function(AjaxService) {

    	dadosLogin = {};

        return {
            criarConta : function(dados) {
                return AjaxService.executaPost("autenticacao/novoUsuario");
            }
        };
    }
]);
