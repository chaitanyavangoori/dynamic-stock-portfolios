/**
 * Created by Chaitanya on 12/7/16.
 */
angular.module('portfolio', ['ui.router', 'dashboardModule'])
    .config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/dashboard');

    $stateProvider

    //states and views
        .state('dashboard', {
            url: '/dashboard',
            templateUrl: 'webapp/dashboard/partials/dashboard.html',
            controller:'dashboardController'
        })
       /* .state('dashboard.search', {
            url: '/search',
            templateUrl: 'webapp/dashboard/partials/search-results.html'
        })*/


        //saved portfolio
        .state('saved-portfolios', {
            url: '/saved-portfolios',
            templateUrl: 'webapp/dashboard/partials/saved-portfolios.html',
            controller:'dashboardController'
        });

    })