package com.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dto.ResponseDto;
import com.web.model.Message;
import com.web.model.User;
import com.web.service.UserService;

@RestController
public class UserApiController {		
	
	@Autowired
	private UserService userService;	
	
	private Message msg;
	
	@RequestMapping("/auth/join")
	public ResponseDto<Integer> join(@RequestBody User user){		
		int result=userService.join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
	}
	@RequestMapping("/api/blockUser/{userid}")
	public Message blockUser(@PathVariable String userid){
		int result = userService.blockUser(userid);
		msg=new Message(result,"");
		return msg;
	}
	
	/* android*/
	@RequestMapping("/android/signup")
	public Message androidSignup(@RequestBody User user){
		int result = userService.androidSignup(user);
		msg=new Message(result,"");
		return msg;
	}	
	@RequestMapping("/android/login")
	public Message androidLogin(@RequestBody User user){
		String userid=user.getUserid();
		String password=user.getPassword();
		int result = userService.androidLogin(userid, password);
		if(result==1) {
			msg=new Message(result,userid);
		}else {
			msg=new Message(result, "");
		}
		return msg;
	}
}