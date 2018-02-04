console.log('service');
app.service("empoyeeService", function($resource) {
	return $resource("http://localhost:8080/SpringRest/:dest", {}, {
		employees : {
			method : "GET",
			isArray : true,
			params : {
				dest : "employees"
			}
		}
	});
});