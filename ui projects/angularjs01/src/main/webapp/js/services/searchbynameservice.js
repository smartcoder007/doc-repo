/**
 * Home Service
 */

function SearchByNameService(R) {
	console.log("searchbynameservice");
	this.searchByAreaName=function(callback){ 			
	    R.searchByAreaName.get(function(response){    
	    	console.log('response:' + response.RestResponse);
            callback(response);
        });
   };
   
};

angular.module('homeCareApp').service('searchbynameservice', ['resourceservice',SearchByNameService]);
