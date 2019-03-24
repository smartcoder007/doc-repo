/**
 * Home Service
 */

function HomeInfoService(R) {
	console.log("homeinfoservice");
	this.getHomeDetails=function(callback){ 		
	    R.getHomeInfo.get(function(response){    
	    	console.log('response:' + JSON.stringify(response));
            callback(response);
        });
   };
   
  this.savehomeList=function(newHome, callback){ 		
	    R.getHomeInfo.save(newHome, function(response){    
	    	console.log('response:' + response);
            callback(response);
        });
   }; 
   
  this.updateHome=function(homedetails, callback){
	   R.updateHomeInfo.update(homedetails, function(response){
		   console.log('update response:' + response);
		   callback(response);
	   });
   };
   
  this.deleteHome=function(param,callback){	    
		R.deleteHome.delete(param,function(response){
               callback(response);
			});
  };
   
   

  
};

angular.module('homeCareApp').service('homeinfoservice', ['resourceservice',HomeInfoService]);
