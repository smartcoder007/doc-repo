function ResourceService($resource) {

	var AppUrl = 'services.groupkt.com';
	this.countryCodes = $resource('http://' + AppUrl + '/country/get/all');
}

angular.module('homeCareApp').service('resourceservice',['$resource', ResourceService]);