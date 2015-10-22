var app = angular.module("userApp",[]);
	app.controller("display",  ["$scope", "$http", function($scope, $http) {
		$http.get('rest/user').success(function(data) {
			$scope.listperson = data.person;            
		});
	}]);
		
	
	app.controller('searchPerson',["$scope", "$http", function($scope, $http){
		
	    $scope.firstName= "John";
	    $scope.lastName= "Chasteen";
	    //var u = "rest/user/search/" + $scope.lastName;
	    $scope.complete = function(){	    	
	    	  
	    	$http.get("rest/user/search/" + $scope.lastName).success(function(data) {
	   			$scope.result = data;            
	   		});	    
	   
	    	}
	    
	  
	}]);