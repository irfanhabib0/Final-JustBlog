myapp.service('FriendService', [
		'$http',
		'$rootScope',
		'$q',
		'RESTURL',
		function($http, $rootScope, $q, RESTURL) {
			this.searchFriend =function(){
				console.log('All friend list service called');
				var d = $q.defer();
				$http.get(RESTURL+ '/allusers')
				.then(function(response){
					d.resolve(response.data);
				},function(error){
					d.reject(error);
				});
				
				return d.promise;
				
				}
			
			this.sendfrndRqst = function(data) {
				console.log("friend service called");
				var deferred = $q.defer();
				$http.post(RESTURL + '/send/request/addthefriend',data).then(
						function(response) {
							console.log(response.data);
							deferred.resolve(response.data);
						}, function(error) {
							deferred.reject(error);
						});
				return deferred.promise;
			}
			
			
			this.getreqestedFriend =function(id){
				console.log('All friend list who received service called');
				var d = $q.defer();
				$http.get(RESTURL+ '/getthesendfrndz/'+id)
				.then(function(response){
					d.resolve(response);
				},function(error){
					d.reject(error);
				});
				
				return d.promise;
				
				}
			
			
			this.getFriendswhoRequestedyou =function(id){
				console.log('All friend list who sends me the friend request when im login ');
				var d = $q.defer();
				$http.get(RESTURL+ '/gettherequestedFrnds/'+id)
				.then(function(response){
					d.resolve(response);
				},function(error){
					d.reject(error);
				});
				
				return d.promise;
				
				}
			
			this.getAcceptThefriend =function(frrnds){
				console.log('All friend list who sends me the friend request when im login ');
				var d = $q.defer();
				
				$http.post(RESTURL+ '/acceptFrnd/',frrnds)
				.then(function(response){
					d.resolve(response);
				},function(error){
					d.reject(error);
				});
				
				return d.promise;
				
				}
			
			
			this.getRejectThefriend =function(frrnds){
				console.log('All friend list who sends me the friend request when im login ');
				var d = $q.defer();
				
				$http.post(RESTURL+ '/acceptFrnd/',frrnds)
				.then(function(response){
					d.resolve(response);
				},function(error){
					d.reject(error);
				});
				
				return d.promise;
				
				}
			
			
			
			
			this.getAllmyConfirmedfriend =function(id){
				console.log('All friend list who confirmed my friend request when im login ');
				var d = $q.defer();
				$http.get(RESTURL+ '/getfrnduserid/'+id)
				.then(function(response){
					d.resolve(response);
				},function(error){
					d.reject(error);
				});
				
				return d.promise;
				
				}
			
			
			
			
			
			
		}])