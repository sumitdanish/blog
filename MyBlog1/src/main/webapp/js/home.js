/**
 * 
 */

var homeApp = angular.module('homeApp',['ngMaterial','ngMessages','ngRoute','ngCookies','loginApp','userAction']);
homeApp.controller('homeAppController',['$scope','$http','$cookies','sharedProperties','$window',function($scope,$http,$cookies,sharedProperties,$window){
	console.log($cookies.get('username'));
    $scope.userDetails = {
			username : $cookies.get('username')
	};
    var self = this;
	$scope.logout = function(){
                      $http.get('logout',{}).then(function(data){
                    	  $window.location.href = 'login.html';
                      },function(error){
                    	  
                      });
                    };
}]);