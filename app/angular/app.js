/**
 * Created by Ludo on 27/10/2016.
 */
(function(){
    'use strict';
    var app = angular.module('projet', ['ngMaterial']);

    app.controller('MainCtrl', function($scope, $mdDialog) {
        $scope.status = '  ';
        $scope.customFullscreen = false;
        $scope.categories = ['Education', 'Sante', 'Securite', 'Mission', 'All'];
        $scope.showAdvanced = function(ev) {
            $mdDialog.show({
                controller: DialogController,
                templateUrl: './views/view1.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
            })
                .then(function(answer) {
                    $scope.status = 'You said the information was "' + answer + '".';
                }, function() {
                    $scope.status = 'You cancelled the dialog.';
                });
        };
        function DialogController($scope, $mdDialog) {
            $scope.hide = function() {
                $mdDialog.hide();
            };

            $scope.cancel = function() {
                $mdDialog.cancel();
            };

            $scope.answer = function(answer) {
                $mdDialog.hide(answer);
            };
        }
    });
})();
