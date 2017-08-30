console.log("forum controller loaded");
myapp.controller('ForumController', [
		'$scope',
		'$http',
		'$location',
		'$rootScope',
		'$routeParams',
		'ForumService',
		
		function($scope, $http, $location, $rootScope,$routeParams, ForumService) {

			console.log("enter forumcontroller");
			console.log($rootScope.currentUser);
			if ($rootScope.currentUser.role == 'admin')
				this.isAdmin = true;
			else
				this.isAdmin = false;
			this.createtheforum = function() {
				ForumService.savetheforum(this.forum).then(function() {
					console.log("success");
					alert("your forum has been created successfully!!");
				}, function() {
					console.log("error");
				})
			}

			/*
			 * this.getAllForum=function(){ console.log("inside the getall
			 * function"); ForumService.getAllForum() .then(function(data){
			 * this.forumList=data; console.log(this.forumList);
			 * console.log("success"); },function(){ console.log("error"); }); }
			 * 
			 * this.getAllForum();
			 */

			var self = this;
			self.getAllForum = function() {
				console.log('get all forum controller method  called');
				ForumService.getAllForum().then(function(data) {
					self.ForumList = data;
					console.log(self.ForumList);
					self.getTheParams();
				}, function(error) {
					alert('error occured');
				});

			}
			self.getAllForum();

			self.getTheParams = function() {
				if ($routeParams.forumId) {
					self.targetedForumId = $routeParams.forumId;
					console.log(self.targetedForumId);
					console.log(self.ForumList);
					for (var i = 0; i < self.ForumList.length; i++) {
						if (self.ForumList[i].forumId == self.targetedForumId) {
							self.patricularForum = self.ForumList[i];
						}
					}
					console.log('Selected Forum:' + self.patricularForum);
				}
			}

			self.addForumcomment = function() {
				console.log($rootScope.currrentUser);
				console.log(self.targetedForumId);
				console.log(self.frmcomment);
				self.frmcomment.user = $rootScope.currentUser;
				self.frmcomment.forum = self.patricularForum;
				console.log('inside the forum comment method');
				ForumService.addtheForumcomment(self.frmcomment).then(
						function(success) {
							alert("Successfully commented the forum");
							//$location.path('#!/patricularForum/'+self.targetedForumId);
						}, function(error) {
							alert("Some error occured");
						});

			}

		} ])