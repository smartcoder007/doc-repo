function ResourceService($resource) {
	console.log("resourceservice");
	var AppUrl = 'services.groupkt.com';
	this.countryCodes = $resource('http://' + AppUrl + '/country/get/all');
	this.searchByAreaName = $resource('http://' + 'services.groupkt.com/state/search/IND?text=pradesh');
}

angular.module('homeCareApp').service('resourceservice',['$resource', ResourceService]);