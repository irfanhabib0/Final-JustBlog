myapp.service('JobService', [
		'$http',
		'$rootScope',
		'$q',
		'RESTURL',
		function($http, $rootScope, $q, RESTURL) {
			this.save = function(job) {
				console.log("job service called");
				var deferred = $q.defer();
				$http.post(RESTURL + '/addjob',job).then(
						function(response) {
							console.log(response.data);
							deferred.resolve(response.data);
						}, function(error) {
							deferred.reject(error);
						});
				return deferred.promise;
			}
			
			this.getAllOftheJobs = function(jobarray) {
				console.log("joblist service called");
				var deferred = $q.defer();
				$http.get(RESTURL + '/getalljob',jobarray).then(
						function(response) {
							console.log(response.data);
							deferred.resolve(response.data);
						}, function(error) {
							deferred.reject(error);
						});
				return deferred.promise;
			}	
			
			this.applied = function(data) {
				console.log("job service called");
				var deferred = $q.defer();
				$http.post(RESTURL + '/addjobapplied',data).then(
						function(response) {
							console.log(response.data);
							deferred.resolve(response.data);
						}, function(error) {
							deferred.reject(error);
						});
				return deferred.promise;
			}
			
			
			
			
			
		
		
		
		
		
		
		}
		

])