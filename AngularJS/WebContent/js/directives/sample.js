app.directive('myFirstDirective', function() {
	return {
		// template: "This is Sample Directive",
		//template : "test data {{data}} <span ng-click='click()'>click</span>",
		template : "<button ng-click=btnClick()>Click</button>",
		restrict : "E",
		link : linkFunction,
		scope: true
	};
	function linkFunction(scope, element, attributes) {
		scope.data = "Sample data";
		scope.click = function() {
			scope.data = scope.test;
		};
		
		scope.btnClick = function() {
			console.log(scope);
			console.log(element);
			console.log(attributes.attr1);
			var event = attributes.attr1;
			alert('clicked');
		};
	}
});
