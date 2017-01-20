var app =angular.module('homeCareApp', ['ngRoute']);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "view/HomeDetails.html"
    });
});
