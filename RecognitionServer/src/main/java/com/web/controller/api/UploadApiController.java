package com.web.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Message;
import com.web.model.Upload;
import com.web.service.FlowerListService;

@RestController
public class UploadApiController {
	
	@Autowired
	private FlowerListService service;	
	
	private Message msg;
	
	@DeleteMapping("/api/flowerListDel/{id}")
	public Message deleteById(@PathVariable int id){
		int result = service.flowerListDelate(id);
		msg=new Message(result,"");
		return msg;
	}
	
	@GetMapping("/android/boardList")
	public List<Map<String,Object>> androidList(@RequestParam(value="keyword") String keyword){
		return service.androidList(keyword);
	}

	@GetMapping("/android/flowerSearch")
	public List<Upload> flowerSearch(@RequestParam(value="searchtxt") String searchtxt){
		return service.androidFlowerSearch(searchtxt);
	}
	
	@GetMapping("/android/searchRank")
	public List<Map<String,Object>> searchRank(){
		return service.searchRank();
	}
}