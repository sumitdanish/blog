/**
 * 
 */

var moduleList = [ 'ngMaterial', 'ngMessages', 'ngRoute','homeApp','userAction' ];
var loginApp = angular.module('loginApp', moduleList).config(function($routeProvider, $httpProvider) {
			$routeProvider.when('/home', {
				templateUrl : 'home.html',
				controller : 'homeAppController',
				controllerAs : 'homeAC'
			}).when('/login', {
				templateUrl : 'login.html',
				controller : 'loginController',
				controllerAs : 'controller'
			}).when('/useraction', {
				templateUrl : 'useraction.html',
				controller : 'userActionController',
				controllerAs : 'userAC'
			}).otherwise('/useraciotn');

			$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
		});
loginApp.service('sharedProperties',function(){
	var username = '';
	return{
		getUsername:function(){
			return username;
		},
		setUsername:function(user){
			username = user;
		}
	};
});
loginApp.controller('loginController',
		[
				'$scope',
				'$http',
				'$location',
				'$rootScope',
				'$route',
				'sharedProperties',
				function($scope, $http, $location, $rootScope, $route,
						sharedProperties) {
					var self = this;
					self.tab = function(route) {
						return $route.current
								&& route === $route.current.controller;
					};
					var username = 'Anonymous';
					var auth = function(credentials, callback) {
						// alert("Hello !");
						var header = credentials ? {
							authorization : "Basic "
									+ btoa(credentials.username + ":"
											+ credentials.password)
						} : {};
						$http.get('user', {
							headers : header
						}).then(function(responce) {
							if (responce.data) {
								username = responce.data.name;
								sharedProperties.setUsername(username);
								$rootScope.isAuth = true;
							} else {
								username = 'Anonymous';
								$rootScope.isAuth = false;
							}
							callback && callback($rootScope.isAuth);
						}, function(responce) {
							console.log("GOing into false");
							$rootScope.isAuth = false;
							callback && callback(false);
						});
					}
					auth();
					self.credentials = {};
					self.login = function() {
						auth(self.credentials, function() {
							if ($rootScope.isAuth) {
								$location.path('/home');
								$rootScope.error = false;
							} else {
								console.log("IsAuth");
								$location.path('/login');
								$rootScope.error = true;
							}
						});
					};

				} ]);