// Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
var app = angular.module('starter', 
    [
        'starter.usuario.controlador',
        'starter.usuario.servico',
        'starter.routes',
    ]
);

app.config(['$stateProvider', '$httpProvider',
    function($stateProvider, $httpProvider) {

        $httpProvider.defaults.timeout = 5 * 60 * 1000;
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];

        var interceptor = function($injector, $q, $rootScope) {
            return {
                request : function(config) {
                    config.timeout = 60000;
                    config.headers = config.headers || {};
                    config.headers.authorization = localStorage.token;

                    $rootScope.$broadcast('loading:show');

                    return config;
                },
                response : function(response) {

                    var headers = response.headers();

                    if (response.data && response.data.status === 403) {
                        $q.reject(response.config);
                    }

                    if (headers) {
                        var token =  headers.tokenauthorization || headers.refreshedauthorization;
                    }

                    return response || $q.when(response);
                },
                responseError : function(rejection) {

                    if (rejection.config) {

                        $rootScope.$broadcast('loading:hide');

                        if (rejection.status === 403) {
                            //TODO
                        }
                    }
                    return $q.reject(rejection);
                }
            };
        };

        interceptor.$inject = ["$injector", "$q", "$rootScope"];

        $httpProvider.interceptors.push(interceptor);
    }
]);

app.factory('AjaxService',[ '$http', '$q',
    function($http, $q) {

        var chamaPost = function(endpoint, dados) {
            var urlPost = 'https://localhost:8443/powerpet/' + 'rest/api/' + endpoint;

            if (dados === null) {
                dados = {};
            }

            var deferred = $q.defer();
            var promisse = $http.post(urlPost, dados);

            promisse.then(function(data) {
                deferred.resolve(data);
            }, function(err) {
                deferred.reject(err);
            });
            return deferred.promise;
        };

        var chamaGet = function(endpoint, dados) {
            var urlGet = 'http://www.w3schools.com/angular/customers.php';

            if (dados === null) {
                dados = {};
            }

            var deferred = $q.defer();
            var promisse = $http.get(urlGet);

            promisse.then(function(data) {
                deferred.resolve(data);
            }, function(err) {
                deferred.reject(err);
            });
            return deferred.promise;
        };

        return {
            executaPost : function(endpoint) {
                return chamaPost(endpoint, null);
            },
            executaPostComDados : function(endpoint, dados) {
                return chamaPost(endpoint, dados);
            },
            executaGet : function(endpoint) {
                return chamaGet(endpoint);
            },
            executaGetComDados : function(endpoint, dados) {
                return chamaGet(endpoint);
            }
        };
    }
]);

app.constant('ListaMensagens', {
    /** Tipos de Mensagens */
    ALERTA: 'ALERTA',
    INFO : 'INFO',
    ERRO : 'ERRO',

    /** Mensagens Gerais - Sistema */
    falhaComunicacao : 'Falha de comunicação com o sistema.',
    erroInterno : 'Erro interno.',
    semConexao : 'Dispositivo sem conexão de internet.',
    sessaoExpirada : 'Sua sessão expirou. Realize novo Login.',
    dadosNaoEncontrados : 'Dados não encontrados.',
    contaNaoExistente : 'Conta não existente.',
    clienteNaoCadastrado : 'Cliente não cadastrado.',
    campoLoginVazio : 'O campo login deve ser informado',
    campoSenhaVazio : 'O campo senha deve ser informado',
    campoNomeVazio : 'Um nome de usuário deve ser informado',

    sucessoNovaConta : 'Conta criada com sucesso!'
});