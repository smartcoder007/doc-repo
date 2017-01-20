/**
 * Home Service
 */

function HomeService($http) {
	//var homeDetails = [];
	this.getHomeDetails = function(callback) {

		$http.get("http://184.72.34.109/DataHub/building").then(
				function(response) {
					console.log('response:' + response.data);					
				//	this.homeDetails = response.data.object;
					callback(response);
				});
	};
};

angular.module('homeCareApp').service('homeservice', [ '$http', HomeService ]);
