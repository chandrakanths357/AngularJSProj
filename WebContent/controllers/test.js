		var app = angular.module("myApp", []);
		
		app.controller("myController",function($scope){
			
			$scope.amount = function(){
				return $scope.quantity * $scope.cost;
			}
			
		});		



