/**
 * Home controller
 */
function HomeController($scope, homeservice) {
	$scope.homeDetails = [];
	homeservice.getHomeDetails(function(response) {
		$scope.homeDetails = response.data.object;
	});

}

angular.module('homeCareApp').controller('HomeCtrl', [ '$scope', 'homeservice', HomeController ]);