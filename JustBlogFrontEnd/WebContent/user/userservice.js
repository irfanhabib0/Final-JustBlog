//var UserModule=angular.module('UserModule',[]);

myapp.service('UserService', [
		'$http',
		'$rootScope',
		'$cookieStore',
		'$q',
		'RESTURL',
		function($http, $rootScope,$cookieStore, $q, RESTURL) {

			/*
			 * this.addUser=function(newuser){ var deferred=$q.defer();
			 * 
			 * $http.post(RESTURL+'/register',newuser) .then(
			 * function(respopnse){ deferred.resolve(respopnse.data); },
			 * function(error){ deferred.reject(error); }); return
			 * deferred.promise; }
			 */

			this.validates = function(guest) {
				console.log("user service called");
				var deferred = $q.defer();
				$http.post(RESTURL + '/login',guest).then(
						function(response) {
							console.log(response.data);
							deferred.resolve(response.data);
						}, function(error) {
							deferred.reject(error);
						});
				return deferred.promise;
			}
			
			this.register = function(regiscontnt) {
				console.log("user service called");
				var deferred = $q.defer();
				$http.post(RESTURL + '/registerUser',regiscontnt).then(
						function(response) {
							console.log(response.data);
							deferred.resolve(response.data);
						}, function(error) {
							deferred.reject(error);
						});
				return deferred.promise;
			}
			
			
			this.acceptData = function(userproficontent) {
				console.log("userprofile service called");
				var deferred = $q.defer();
				$http.post(RESTURL + '/showtotheprofile',userproficontent).then(
						function(response) {
							console.log(response.data);
							deferred.resolve(response.data);
						}, function(error) {
							deferred.reject(error);
						});
				return deferred.promise;
			}
			
			this.logout = function(data) {
				console.log('logout service called');
				var d = $q.defer();
				$http.post(RESTURL + '/updateOffline', data).then(
						function(success) {
							console.log('Successfully Done')
							$cookieStore.remove('currentUser');

							d.resolve(success);
						}, function(error) {
							d.reject(error);
						});
				return d.promise;
			}
			
			
			
		}

])