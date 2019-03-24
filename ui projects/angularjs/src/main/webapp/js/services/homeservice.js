/**
 * Home Service
 */

function HomeService(R) {
	console.log("homeservice");
	this.getHomeDetails=function(callback){ 		
	    R.countryCodes.get(function(response){    
	    	console.log('response:' + response.data);
            callback(response);
        });
   };
   
};

angular.module('homeCareApp').service('homeservice', ['resourceservice',HomeService]);
