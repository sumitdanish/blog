/**
 * 
 */

var moduleList = [ ];
var loginApp = angular
		.module('loginApp', ['ngMaterial', 'ngMessages', 'ngRoute', 'homeApp','ngCookies',
		             		'userAction','ui.router'])
		.config(['$stateProvider','$httpProvider',
				function($stateProvider,$httpProvider) {
					$stateProvider.state('/home', {
						url : '/home',
						templateUrl : 'home.html',
						controller : 'homeAppController',
						controllerAs : 'homeAC'
					}).state('login', {
						url : '/login',
						templateUrl : 'login.html',
						controller : 'loginController',
						controllerAs : 'controller'
					}).state('useraction', {
						url : '/useraction',
						templateUrl : 'useraction.html',
						controller : 'userActionController',
						controllerAs : 'userAC'
					});

					$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
				}]);
loginApp.service('sharedProperties', function() {
	var username = '';
	return {
		getUsername : function() {
			return username;
		},
		setUsername : function(user) {
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
                '$window',
                '$cookies',
				'sharedProperties',
				function($scope, $http, $location, $rootScope, $route,$window,$cookies,
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
								$window.location.href = 'home.html';
                                console.log("Login Name : "+sharedProperties.getUsername());
                                 $cookies.put('username',sharedProperties.getUsername());
								$rootScope.error = false; 
							} else {
								console.log("IsAuth");
								$location.path('/login');
								$rootScope.error = true;
							}
						});
					};

				} ]);