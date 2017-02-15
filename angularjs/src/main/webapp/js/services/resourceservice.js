function ResourceService($resource) {
	console.log("resourceservice");
	var AppUrl = 'services.groupkt.com';
	var portno = '9000'
	this.countryCodes = $resource('http://' + AppUrl + '/country/get/all');
	this.searchByAreaName = $resource('http://' + 'services.groupkt.com/state/search/IND?text=pradesh');
	this.getHomeInfo = $resource('http://' + 'localhost:'+ portno+'/home');
	this.updateHomeInfo=$resource('http://' + 'localhost:'+ portno +'/home',null, {'update': { method:'PUT' } });
	this.deleteHome=$resource('http://' + 'localhost:'+ portno +'/home?:query');
}

angular.module('homeCareApp').service('resourceservice',[ '$resource', ResourceService ]);