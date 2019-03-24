/**
 * 
 */

angular.module('homeCareApp')
  .directive('temp', function () {
	  console.log("home directive");
    return {
          templateUrl: 'views/temp.html',
      restrict: 'E',
      link: function postLink(scope, element, attrs) {
       
      }
    };
  });