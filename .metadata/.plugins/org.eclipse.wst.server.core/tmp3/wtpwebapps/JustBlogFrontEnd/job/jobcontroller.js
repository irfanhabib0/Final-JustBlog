console.log("loaded job controller");
myapp.controller('JobController', [
		'JobService',
		'$http',
		'$scope',
		'$location',
		'$rootScope',
		function(JobService, $http, $scope, $location, $rootScope) {
			var self = this;
			// self.user = {};
			self.job = {};
			self.applyjob={};
			self.jobarray = [];
			self.applyForm = true;
			self.joblist = false;
			self.afterapply=false;
				

			self.createtheJob = function() {
				console.log('create the job');
				// console.log('self.guset');
				console.log(self.job);
				
				JobService.save(self.job).then(function(data) {
					// console.log(response.data);
					self.job = data;
					console.log(self.job);
				}, function(error) {
					console.log(error);
				});
			}

			self.createlistOfJob = function() {
				console.log('create the list of job');
				// console.log('self.guset');
				console.log(self.jobarray);
				JobService.getAllOftheJobs().then(function(data) {
					self.jobarray = data;
					console.log(self.jobarray);
					// $location.path('/showinglist');
					self.joblist = true;
					self.applyForm = false;
					
					
				}, function(error) {
					console.log(error);
				});
			}
			
			self.applytheJob = function(jobb) {
				console.log('apply the job');
				// console.log('self.guset');
				//console.log(self.applyjob);
				
				var data1={
						user:$rootScope.currentUser,
						job:jobb
				}
				console.log(data1);
				JobService.applied(data1).then(function(data) {
					// console.log(response.data);
					//self.applyjob = data;
					//console.log(self.applyjob);
					self.applyForm = false;
					self.joblist = true;
					self.afterapply=true;
				}, function(error) {
					console.log(error);
				});
			}
			


			
		} ])