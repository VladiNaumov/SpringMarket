angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/v1';

    // console.log(123);

 $scope.loadProduct = function (pageIndex = 1){
   $http({
           url: contextPath + '/products',
            method: 'GET',
                params: {
                        name_part: $scope.filter ? $scope.filter.name_part : null,
                        min_price: $scope.filter ? $scope.filter.min_price : null,
                        max_price: $scope.filter ? $scope.filter.max_price : null
                }
                }).then(function (response) {
                       // console.log(response.data)
                        $scope.ProductList = response.data.content;
           });
    };


    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
            console.log(response.data)
               $scope.loadProduct();
            });
    }

     $scope.createProductJson = function () {
            console.log($scope.newProductJson);
            $http.post(contextPath + '/products', $scope.newProductJson)
                .then(function (response) {
                    //console.log($scope.newProductJson);
                    $scope.loadProduct();
                });
     }

    $scope.loadProduct();
});