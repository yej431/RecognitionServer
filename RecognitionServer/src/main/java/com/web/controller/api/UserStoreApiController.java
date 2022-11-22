package com.web.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Message;
import com.web.service.UserStoreService;

@RestController
public class UserStoreApiController {
	
	@Autowired
	private UserStoreService service;	
	
	private Message msg;
	
	@GetMapping("/android/storeSave")
	public Message androidStoreSave(@RequestParam(value="flowername") String flowername,
			@RequestParam(value="userid") String userid){
		int result=service.androidStoreSave(flowername, userid);	
		msg=new Message(result,"");
		return msg;
	}
	
	@GetMapping("/android/storeList")
	public List<Map<String,Object>> androidStoreList(@RequestParam(value="userid") String userid){
		return service.androidStoreList(userid);
	}
}