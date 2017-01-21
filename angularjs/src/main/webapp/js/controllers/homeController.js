/**
 * Home controller
 */
function HomeController($scope, homeservice) {
	$scope.homeDetails = [];
	homeservice.getHomeDetails(function(response) {
		console.log('controller res' + response)
		$scope.homeDetails = response.RestResponse.result;
	});

}

angular.module('homeCareApp').controller('HomeCtrl', [ '$scope', 'homeservice', HomeController ]);