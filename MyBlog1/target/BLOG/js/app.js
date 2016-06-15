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
		controllerAs:'login'
	}).otherwise('/');
	
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});
loginApp.controller('homeController',['$scope','$http',function($scope,$http){
	
}]);
loginApp.controller('loginController',['$scope','$http','$location','$rootScope',function($scope,$http,$location,$rootScope){
	var self = this;
	var auth = function(credentials,callback){
		//alert("Hello !");
		var header = credentials ? {authorization:"Basic : "+btoa(credentials.username + ":" +credentials.password)} : "";
		$http.get('user',{headers : header}).then(function(responce){
			if(respoce.data.name){
				$rootScope.isAuth = true;
			}else{
				$rootScope.isAuth = false;
			}
			callback && callback();
		},function(responce){
			$rootScope.isAuth = false;
			callback && callback();
		});
	}
	//auth();
	self.credentials = {};
	self.login = function(){
		auth(self.credentials,function(){
			if($rootScope.isAuth){
				$location.path('/home');
				$rootScope.error = false;
			}else{
				$location.path('/login');
				$rootScope.error = true;
			}
		});
	};
	
}]);