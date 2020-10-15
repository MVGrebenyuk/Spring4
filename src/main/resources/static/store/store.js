angular.module('app').controller('storeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';
    let filter;

    $scope.fillTable = function () {
        $http.get(contextPath + '/api/v1/products')
            .then(function (response) {
                $scope.Products = response.data;
            });
    };

    $scope.applyFilter = function () {
         $http({
             url: contextPath + '/api/v1/products',
             method: "GET",
             params: {  title: $scope.fProd.title != null ? $scope.fProd.title : '',
                        min: $scope.fProd.min != null ? $scope.fProd.min : '',
                        max: $scope.fProd.max != null ? $scope.fProd.max : ''}
         }).then(function (response) {
             $scope.Products = response.data;
         });
     }

    $scope.submitCreateNewProduct = function () {
        $http.post(contextPath + '/api/v1/products', $scope.newProduct)
            .then(function (response) {
                // $scope.Products.push(response.data);
                $scope.newProduct = null;
                $scope.fillTable();
            });
    };

    $scope.fillTable();
});