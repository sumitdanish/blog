/**
 * 
 */

var loginApp = angular.module('loginApp',['ngMaterial','ngMessages','ngRoute'])
.config(function($routeProvider,$httpProvider){
	$routeProvider.when('/home',{
		templateUrl:'home.html',
		controller:'homeController',
		controllerAs:'controller'
	}).when('/login',{
		templateUrl:'login.html',
		controller:'loginController',
		controllerAs:'controller'
	}).otherwise('/');
	
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});
loginApp.service('sharedProperties',function(){
	var username='';
	return{
		getUsername:function(){
			return username;
		},
		setUsername:function(user){
			username = user;
		}
	};
});
loginApp.controller('homeController',['$scope','$http',function($scope,$http){
	
}]);
loginApp.controller('loginController',['$scope','$http','$location','$rootScope','$route',function($scope,$http,$location,$rootScope,$route){
	var self = this;
    self.tab = function(route) {
				return $route.current && route === $route.current.controller;
			};
	var auth = function(credentials,callback){
		//alert("Hello !");
        console.log("calling !");
		var header = credentials ? {authorization:"Basic "+btoa(credentials.username + ":" +credentials.password)} : {};
		$http.get('user',{headers : header}).then(function(responce){
			if(responce.data){
                sharedProperties.setUsername(responce.data.name);
				$rootScope.isAuth = true;
			}else{
				$rootScope.isAuth = false;
			}
			callback && callback($rootScope.isAuth);
		},function(responce){
            console.log("GOing into false");
			$rootScope.isAuth = false;
			callback && callback(false);
		});
	}
	auth();
	self.credentials = {};
	self.login = function(){
		auth(self.credentials,function(){
			if($rootScope.isAuth){
				$location.path('/home');
				$rootScope.error = false;
			}else{
                console.log("IsAuth");
				$location.path('/login');
				$rootScope.error = true;
			}
		});
	};
	
}]);