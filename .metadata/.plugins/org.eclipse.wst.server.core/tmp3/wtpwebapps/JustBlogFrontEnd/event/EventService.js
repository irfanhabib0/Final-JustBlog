myapp.service('EventService',['$http','$q','RESTURL',function($http,$q,RESTURL){

	
	this.getAllEvent=function()
	{
		console.log("all event service method called");
		var d=$q.defer();
		$http.get(RESTURL + '/getallevent')
		.then(function(response){
			d.resolve(response.data);
		},function(error){
			d.reject(error);
		});
		return d.promise;
	}

	
}])