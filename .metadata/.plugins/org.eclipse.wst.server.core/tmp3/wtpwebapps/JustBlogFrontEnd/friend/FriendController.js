console.log("loaded friend controller");
myapp.controller('FriendController', [
		'FriendService',
		'$http',
		'$scope',
		'$location',
		'$rootScope',
		function(FriendService, $http, $scope, $location, $rootScope) {
			var self=this;
			self.searchFriend = function() {
				console.log('get all the friends');
				FriendService.searchFriend ().then(function(data) {
					self.FriendList = data;
					console.log(self.FriendList);
					
				}, function(error) {
					alert('error occured');
				});

			}
			
		self.sendfrndRqst = function(ofrnd) {	
			console.log(ofrnd);
			var data1= {

					user : $rootScope.currentUser,
					friend : ofrnd,
                    status:"new",
                    initiater:1
				}
            
			console.log("Frnd Rqst Send controller called");
            
			FriendService.sendfrndRqst(data1).then(function(data) {
				
				alert("Friend Request Send Successfully..:)");
				

			}, function(error) {
				console.log(error);
			});
		}
		
		
		
		self.getreqestedFriend = function() {
			console.log('get all the friends whom i requested friends');
			FriendService.getreqestedFriend($rootScope.currentUser.id).then(function(response) {
				self.RequestedFriendList = response.data;
				console.log(self.RequestedFriendList);
				$location.path('/toshowfrnds');
				
			}, function(error) {
				alert('error occured');
			});

		}
		
		self.getFriendswhoRequestedyou = function() {
			console.log('get all the friends whom i requested friends');
			FriendService.getFriendswhoRequestedyou($rootScope.currentUser.id).then(function(response) {
				self.FriendsListshow = response.data;
				console.log(self.FriendsListshow);
				$location.path('/toshowfrndswhosendReqst');
				
			}, function(error) {
				alert('error occured');
			});

		}
		
		
		self.getAcceptThefriend= function(frrnds) {
			console.log('get all the friends whom i requested friends');
			console.log(frrnds);
			frrnds.status="confirm";
			
			FriendService.getAcceptThefriend(frrnds).then(function(response) {
				
				
				$location.path('/toconfirmRequests');
				
			}, function(error) {
				alert('error occured');
			});

		}
		
		
		self.getRejectThefriend= function(frrnds) {
			console.log('get all the friends whom i requested friends');
			console.log(frrnds);
			frrnds.status="reject";
			
			FriendService.getAcceptThefriend(frrnds).then(function(response) {
				
				
				$location.path('/toconfirmRequests');
				
			}, function(error) {
				alert('error occured');
			});

		}
		
		
		
		
		
		
		self.getAllmyConfirmedfriend= function() {
			console.log('wanna show all the confirmed friends..');

			FriendService.getAllmyConfirmedfriend($rootScope.currentUser.id).then(function(response) {
				self.confirmedfriendsListshow = response.data;
				
				$location.path('/toseeallmyconfirmedfrnds');
				
			}, function(error) {
				alert('error occured');
			});

		}
		
		
		
		
		
			
			
		} ])