/**
 * Home Service
 */

function HomeInfoService(R) {
	console.log("homeinfoservice");
	this.getHomeDetails=function(callback){ 		
	    R.getHomeInfo.get(function(response){    
	    	console.log('response:' + response.data);
            callback(response);
        });
   };
   
};

angular.module('homeCareApp').service('homeinfoservice', ['resourceservice',HomeInfoService]);
