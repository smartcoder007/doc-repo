/**
 * Home controller
 */
function SearchByNameController($scope, searchbynameservice) {
	console.log("searchbynamectl");
	$scope.searchByAreaName = [];
	searchbynameservice.searchByAreaName(function(response) {
		console.log('controller res' + response)
		$scope.searchByAreaName = response.RestResponse.result;
	});

}

angular.module('homeCareApp').controller('searchbynamectl', [ '$scope', 'searchbynameservice', SearchByNameController ]);