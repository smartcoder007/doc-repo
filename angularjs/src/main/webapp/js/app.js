var app =angular.module('homeCareApp', ['ngRoute','ngResource']);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "view/HomeDetails.html"
    });
});
