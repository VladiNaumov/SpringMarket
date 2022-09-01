angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    // console.log(123);

    $scope.loadProduct = function () {
        $http.get(contextPath + '/market/')
            .then(function (response) {
            // console.log(response.data)
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
            url: contextPath + '/market/change_discount/',
            method: 'POST',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProduct();
        });
    }

    $scope.createProductJson() = function () {
        console.log($scope.newProductJson);
        $http.post(contextPath + '/market', $scope.newProductJson)
                .then(function (response) {
                    $scope.loadProduct();
                });
        }


    $scope.sumTwoNumbers = function () {
        console.log($scope.calcAdd);
        $http({
                url: contextPath + '/calc/add',
                method: 'get',
                params: {
                    a: $scope.calcAdd.a,
                    b: $scope.calcAdd.b
                }
        }).then(function (response) {
                alert('Сумма равна ' + response.data.value);
                $scope.calcAdd.a = null;
                $scope.calcAdd.b = null;
           });
        }

    $scope.loadProduct();
});