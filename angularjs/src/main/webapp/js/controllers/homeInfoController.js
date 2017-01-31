/**
 * Home controller
 */
function HomeInfoController($scope, homeinfoservice) {
	console.log("HomeInfoController");
	$scope.homeDetails = [];
	homeinfoservice.getHomeDetails(function(response) {
		console.log('controller res' + response)
		$scope.homeDetails = response.object;
	});

}

angular.module('homeCareApp').controller('HomeInfoCtrl', [ '$scope', 'homeinfoservice', HomeInfoController ]);