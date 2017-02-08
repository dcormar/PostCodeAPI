/**
 * 
 */
var app = angular.module('postCodeModule', []);

var resourceUrl = 'http://localhost:8080';

app.controller('restController', function($scope, $http) {

	 $scope.form = {
			 country : "",
			 postCode : ""
         };
	$scope.myTxt = "please write the post code to search."
	$scope.consumeAPI = function() {
		$http.get(resourceUrl + '/findByPostCode/'+$scope.form.country +'/'+$scope.form.postCode).
        then(function(response) {
            $scope.addresses = response.data;
            $scope.results = $scope.addresses.length;
        },function(data) {
        	$scope.results = 0;
            /*if (status === 400) {
                alert("Error - " + status + ", No results found.");
            }
            else if (status === 408) {
            	alert("Error - " + status + ", Response Timeout.");
            }*/
      });
	};
});