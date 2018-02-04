console.log('cntl');
app.controller('employeeCntl', function($scope, $http, empoyeeService) {
	/*$http.get(
		"http://localhost:8080/SpringRest/employees"
	).success(function(data) {
		$scope.empData = data;
	}).error(function(error) {
		console.log(error);
	});*/
	empoyeeService.employees({}, function(data) {
		$scope.employees = data;
	});
	$scope.test = "test data";
	$scope.test1 = function() {
		alert('test1');
	};
});
