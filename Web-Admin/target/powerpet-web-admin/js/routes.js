angular.module('starter.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider
    .state('principal', {
    url: '/principal',
    templateUrl: '/views/Principal.html',
    controller: 'UsuarioController'
  })

  .state('login', {
    url: '/login',
    templateUrl: '/views/Login.html',
    controller: 'UsuarioController'
  })

  .state('criarConta', {
    url: '/novoUsuario',
    templateUrl: '/views/ViewUsuario.html',
    controller: 'UsuarioController'
  })

$urlRouterProvider.otherwise('/principal')

});