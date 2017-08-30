myapp.controller('BlogController',['$scope','$rootScope','BlogService',function($scope,$rootScope,BlogService){
	var self=this;
	
	self.addBlog=function(){
		self.blog.status='N';
		console.log("inside the controller");
		console.log("self.blog");
		BlogService.addBlog(self.blog).then(function(){
			console.log("successfully created and waiting for admins approval");
		},function(){
			console.log("there is some error");
		});
	}
}])