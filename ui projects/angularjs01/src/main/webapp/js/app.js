var app = angular.module('homeCareApp', [ 'ngRoute', 'ngResource' ]);
app.config([ '$routeProvider', '$locationProvider',
		function($routeProvider, $locationProvider) {
	        console.log('url' + JSON.stringify($locationProvider));
			$routeProvider.when('/HomeDetails', {
				templateUrl : 'view/HomeDetails.html',
				controller : 'HomeCtrl',
				controllerAs : 'HomeCtrl'
			}).when('/SearchByName', {
				templateUrl : 'view/SearchByName.html',
				controller : 'searchbynamectl',
				controllerAs : 'searchbynamectl'
			}).when('/HomeInfoDetails', {
				templateUrl : 'view/HomeInfoDetails.html',
				controller : 'HomeInfoCtrl',
				controllerAs : 'HomeInfoCtrl'
			}).when('/HomeNew', {
				templateUrl : 'view/HomeNew.html',
				controller : 'HomeInfoCtrl',
				controllerAs : 'HomeInfoCtrl'
			}).when('/HomeUpdate', {
				templateUrl : 'view/HomeUpdate.html',
				controller : 'HomeInfoCtrl',
				controllerAs : 'HomeInfoCtrl'
			}).otherwise({
				redirectTo : 'HomeDetails'
			});
		} ]);

app.run([ '$rootScope', function($rootScope) {
	// see what's going on when the route tries to change
	$rootScope.$on('$routeChangeStart', function(event, next, current) {
		// next is an object that is the route that we are starting to go to
		// current is an object that is the route where we are currently
		var currentPath = current.originalPath;
		var nextPath = next.originalPath;

		console.log('Starting to leave %s to go to %s', currentPath, nextPath);
	});
} ]);
