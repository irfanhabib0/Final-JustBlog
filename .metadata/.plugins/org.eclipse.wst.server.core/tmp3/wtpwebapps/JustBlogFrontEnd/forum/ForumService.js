myapp.service('ForumService', [
		'$http',
		'$rootScope',
		'$q',
		'RESTURL',
		function($http, $rootScope, $q, RESTURL) {
			
			this.savetheforum = function(forum) {
				console.log("forum service called");
				var deferred = $q.defer();
				$http.post(RESTURL + '/showtheforumpost', forum).then(
						function(response) {
							console.log(response.data);
							deferred.resolve();
						}, function(error) {
							deferred.reject();
						});
				return deferred.promise;
			}
			
			/*this.getAllForum=function(){
				console.log("allforums called");
				var deferred=$q.defer();
				$http.get(RESTURL+'/getallforum').then(
						function(response){
							console.log(response.data);
					deferred.resolve(response.data);
					},function(error){
						deferred.reject();
					});
				return deferred.promise;
			}
*/			
			
			this.getAllForum=function(){
				console.log('All forum list service called');
				var d = $q.defer();
				$http.get(RESTURL+ '/getallforum')
				.then(function(response){
					d.resolve(response.data);
				},function(error){
					d.reject(error);
				});
				
				return d.promise;
				
				}
			
			
			this.addtheForumcomment=function(frmcomment){
				console.log('Add forum comment service called');
				var d = $q.defer();
				$http.post(RESTURL + '/insertForumcomment',frmcomment)
				.then(function(success){
					d.resolve(success);
				},function(error){
					d.reject(error);
				});
				return d.promise;
			}
			
			

		}])