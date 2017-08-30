myapp.service('BlogService',['$http','$q','RESTURL',function($http,$q,RESTURL){
	this.addBlog=function(b){
		console.log("addblog is called");
		var d=$q.defer();
		console.log(b);
		$http.post(RESTURL+'/addblog',b).then(function(response){
			d.resolve(response);
			},function(error){
				d.reject();
			});
		return d.promise;
	}
}])