var myapp = angular.module("myprojct", [ 'ngRoute' ]);
myapp.config(function($routeProvider,$locationProvider) {

	$routeProvider	
	.when('/',{
		templateUrl : 'user/registration.html',

});
});	