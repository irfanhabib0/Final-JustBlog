package com.niit.restservice.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.niit.JustBlogBackEnd.Dao.EventDao;
import com.niit.JustBlogBackEnd.model.Event;
import com.niit.JustBlogBackEnd.model.Forum;


@RestController
public class EventController {
	 @Autowired
     EventDao evntDao;
	 @PostMapping("/uploadfile")
		public @ResponseBody String uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("event") String event){
			
			String fileName=null;
			
			if(!file.isEmpty()){
				try {
				 fileName=file.getOriginalFilename();

				System.out.println(fileName);
				Gson gs=new Gson();
				Event events=gs.fromJson(event, Event.class);
				events.setImageUrl(fileName);
				events.setEventDate(new Date());
				evntDao.saveEvent(events);
					byte [] bytes=file.getBytes();
					BufferedOutputStream buffer= new BufferedOutputStream(new FileOutputStream(new File("D:/Collaboration/" +fileName)));
				
					buffer.write(bytes);
					buffer.close();
					 return "You have successfully uploaded " + fileName;
				} catch (IOException e) {
					
					e.printStackTrace();
					 return "You failed to upload " + fileName + ": " + e.getMessage();
				}
			
			}		
			return "Unable to upload. File is empty.";
			
		}
	 
	 
	 @GetMapping("/getallevent")
	 	public ResponseEntity <List<Event>> getAllforum(){
	 		List<Event> getallevents=evntDao.getAllevents();
//	 		blog.setErrorCode("200");
//	 		blog.setErrorMessage("All blogs retrieved");
	 		return new ResponseEntity<List<Event>>(getallevents,HttpStatus.OK);
	 	}
	 
	 
			
		}


