/**
 * 
 */

var userAction = angular.module('userAction',['ngMaterial','ngMessage','ngRoute']);
userAction.config(function($routeProvider,$httpProvider){
	$routeProvider.when('/useraction',{
		templateUrl : 'useraction.html',
		controller:'userActionController',
		controllerAs:'UserAC'
	}).when('/home',{
		templateUrl : 'home.html',
		controller:'homeController',
		controllerAs:'homeC'
	}).otherwise('/useraction');
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});