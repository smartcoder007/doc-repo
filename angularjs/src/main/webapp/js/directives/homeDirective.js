/**
 * 
 */

angular.module('homeCareApp')
  .directive('temp', function () {
    return {
          templateUrl: 'views/temp.html',
      restrict: 'E',
      link: function postLink(scope, element, attrs) {
       
      }
    };
  });