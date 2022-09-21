angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/v1';

    if ($localStorage.springWebUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.springWebUser.token;
        }

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

$scope.tryToAuth = function () {
        $http.post('http://localhost:8189/app/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.springWebUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(response) {
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        if ($scope.user.username) {
            $scope.user.username = null;
        }
        if ($scope.user.password) {
            $scope.user.password = null;
        }
    };

    $scope.clearUser = function () {
        delete $localStorage.springWebUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $rootScope.isUserLoggedIn = function () {
        if ($localStorage.springWebUser) {
            return true;
        } else {
            return false;
        }
    };

    $scope.showCurrentUserInfo = function () {
        $http.get('http://localhost:8189/app/v1/profile')
            .then(function successCallback(response) {
                alert('MY NAME IS: ' + response.data.username);
            }, function errorCallback(response) {
                alert('UNAUTHORIZED');
            });
    }

/*
     $scope.createProductJson = function () {
            console.log($scope.newProductJson);
            $http.post(contextPath + '/products', $scope.newProductJson)
                .then(function (response) {
                    //console.log($scope.newProductJson);
                    $scope.loadProduct();
                });
     }

*/

    $scope.loadProduct();
});