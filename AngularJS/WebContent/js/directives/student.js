app.directive('student', function() {
	// Define the directive object
	var directive = {};

	// restrict = E, signifies that directive is Element directive.
	directive.restrict = 'E';

	// template
	directive.template = "Student <h1>{{student}}</h1>";

	directive.scope = {
		student : "=name"
	};

	// compile is called during application initialization
	directive.compile = function(element, attributes) {
		var fun = function($scope, element, attributes) {
			element.html("Student "+ "<b>" + $scope.student + "</b>");
		};
		return fun;
	};
	return directive;
});