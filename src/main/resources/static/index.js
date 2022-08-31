angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/';

    $scope.loadProduct = function () {
        $http.get(contextPath + '/market')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/market/delete/' + productId)
            .then(function (response) {
               $scope.loadProduct();
            });
    }

    $scope.changeScore = function (productId, delta) {
        $http({
            url: contextPath + '/market/change_discount',
            method: 'POST',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProduct();
        });
    }

    $scope.loadProduct();
});