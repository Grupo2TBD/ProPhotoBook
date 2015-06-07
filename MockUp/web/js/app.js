(function(){
    // Se carga un nuevo módulo para configuraciones y controladores
	var app = angular.module('formApp', ['ngRoute']);

    // Configuración de rutas a través de $routeProvider
    app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.
            when('/index', {templateUrl: 'index',   controller: 'MainCtrl'}).
            when('/home', {templateUrl: 'home',   controller: 'HomeCtrl'}).
            // Si se accede a una ruta no especificada, se redirige a la ruta '/inicio' 
            otherwise({redirectTo:'/home'});
	}]);

	app.controller('MainCtrl', function ($scope) {
		$scope.formData = {};

		$scope.submitForm = function (formData) {
			alert('Form submitted with' + JSON.stringify(formData));
		};
	});

})();
