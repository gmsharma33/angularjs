var app = angular.module("myApp", []);
app.controller("myCntl", function($scope, $http) {
	$scope.employees = [ {
		"id" : 1
	} ];
	$scope.data = "";
	function get() {
		$http.get("http://localhost:8080/SpringRest/employees")
	    .then(function(response) {
	        $scope.employees = response.data;
	    });
		$http.get("http://localhost:8080/SpringRest/image")
	    .then(function(response) {
	    	debugger;
	        $scope.data = response;
	    });
	}
	get();
});