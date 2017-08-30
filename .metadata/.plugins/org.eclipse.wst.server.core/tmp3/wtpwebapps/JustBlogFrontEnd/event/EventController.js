myapp.controller('EventController', [
		'$scope',
		'$http',
		'$location',
		'EventService',
		function($scope, $http,$location,EventService) {

			var self = this;
			self.uploadEvent = function() {
								var uploadUrl = 'http://localhost:8036/RestServices/uploadfile';
								var formData = new FormData();
								formData.append("event", JSON
										.stringify(self.event));
								formData.append("file", file.files[0]);
								console.log(formData.get('event'));
								$http(
										{
											method : 'POST',
											url : uploadUrl,
											headers : {
												'Content-Type' : undefined
											},
											data : formData,
											transformRequest : function(data,
													headersGetterFunction) {
												return data;
											}
										}).then(function(response) {
									alert("success");
								}, function(error) {
									alert('error');
								})

							
			}
			
			self.getAllEvent=function()
			{
				console.log("all event controller method called");
				EventService.getAllEvent().
				then(function(data){
					self.EventList=data;
					console.log(self.EventList);
					$location.path("/evntlist");
				},function(error){
					alert("try after technical issue");
				});
			}
			//self.getAllEvent();


			
		} ])