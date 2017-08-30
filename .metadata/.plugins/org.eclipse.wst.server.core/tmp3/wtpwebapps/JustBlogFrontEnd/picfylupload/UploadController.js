console.log("loaded upload controller");
myapp.controller('UploadController',function($scope,$http){

	var self=this;
	
self.continueFileUpload=function (){
                                var uploadUrl='http://localhost:8036/RestServices/uploadfile';
                                var formData=new FormData();
                                //formData.append("eventData",JSON.stringify(self.event));
                                formData.append("file",file.files[0]);
                               // console.log(formData.get('eventData'));
                                $http({
                                                method: 'POST',
                                                url: uploadUrl,
                                                headers: {'Content-Type': undefined},
                                                data: formData,
                                                transformRequest: function(data, headersGetterFunction) {
                                                                return data;
                                                }
                                })
                                .then(function(response) {  
                                                alert("success");
                                },function(error){
                                                alert('error');
                                });
 
                }
})