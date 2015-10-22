// route.js

    // create the module and name it routApp
    // also include ngRoute for all our routing needs
    var routeApp = angular.module('routeApp', ['ui.bootstrap','ngRoute','datatables','ngResource']);
    //var routeApp = angular.module('routeApp', ['ui.bootstrap','ngRoute','smart-table']);
    
    // configure our routes
    //routeApp.config(["$routeProvider", "$locationProvider", function($routeProvider, $locationProvider) {
	routeApp.config(["$routeProvider", function($routeProvider) {
		//$locationProvider.html5Mode(true);
        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : './././pages/home.html'
            /*})
			
			// route for the resume page
            .when('/resume', {
                templateUrl : './pages/resume.html'
                
            })

            // route for the portfolio page
            .when('/portfolio', {
                templateUrl : './pages/portfolio.html'  
            })
			
			 // route for the portfolio page
            .when('/portfolio/:params', {
				templateUrl : './pages/portfolio.php',
				controller: 'PortfolioController'
                
            })

            // route for the contact page
            .when('/contact', {
                templateUrl : './pages/contact.html'
			//})
			
			//.otherwise({
			//	redirectTo: '/portfolio/'
            */    
			});
			
			// use the HTML5 History API
			//$locationProvider.html5Mode(true);
			
    }]);
	
	
	routeApp.controller("display",  ["$scope", "$http", function($scope, $http) {
		$http.get('rest/user').success(function(data) {
			$scope.listperson = data.person;            
		});
	}]);
		
	
	
	routeApp.controller('searchPerson',["$scope", "$http", function($scope, $http){
		
	    $scope.firstName= "John";
	    $scope.lastName= "Chasteen";
	    //var u = "rest/user/search/" + $scope.lastName;
	    $scope.complete = function(){	    	
	    	  
	    	$http.get("rest/user/search/" + $scope.lastName).success(function(data) {
	   			$scope.result = data;            
	   		});	    
	   
	    	}
	    
	  
	}]);
	
	// Table Controller
	routeApp.controller('WithAjaxCtrl', function ($http, DTOptionsBuilder, DTColumnDefBuilder) {
	    var vm = this;
		vm.results = [];
	    vm.dtOptions = DTOptionsBuilder.newOptions().withPaginationType('full_numbers').withDisplayLength(10);
	    vm.dtColumnDefs = [
	                       DTColumnDefBuilder.newColumnDef(0),
	                       DTColumnDefBuilder.newColumnDef(1),
	                       DTColumnDefBuilder.newColumnDef(2)
       ];
	                       
       $http.get('rest/asset/meters').success(function(data) {
    	   vm.results = data.metering_units;            
	   });
	    
	 });
	
	
	routeApp.controller("asset",  ["$scope", "$http", function($scope, $http) {
		
		$scope.itemsByPage=20;	
		
		$http.get('rest/asset/meters').success(function(data) {
			
			$scope.result = data.metering_units;            
		});
	}]);
	
	
	
	
	

    // create the controller and inject Angular's $scope
    routeApp.controller('MainController', function($scope) {			
    });
	
	// create the controller and inject Angular's $scope
    routeApp.controller('PortfolioController', function($scope) {			
    });
	
	/*routApp.controller('ModalDemoCtrl', function ($scope, $modal, $log) {

		$scope.items = ['item1', 'item2', 'item3'];

		$scope.animationsEnabled = true;

	  $scope.open = function (size) {

			var modalInstance = $modal.open({
			  animation: $scope.animationsEnabled,
			  templateUrl: 'myModalContent.html',
			  controller: 'ModalInstanceCtrl',
			  size: size,
			  resolve: {
				items: function () {
				  return $scope.items;
				}
			  }
			});
	
	routApp.controller('contactController', function($scope) {
		$scope.master = {firstName: "John", lastName: "Doe"};
		$scope.reset = function() {
			$scope.user = angular.copy($scope.master);
		};
    $scope.reset();
});*/
	
	