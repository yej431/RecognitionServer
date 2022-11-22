package com.web.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Article;
import com.web.model.Message;
import com.web.service.ArticleService;

@RestController
public class ArticleApiController {
	
	@Autowired
	private ArticleService service;	
	
	private Message msg;
	
	@PostMapping("/android/articleSave")
	public Message androidArticleSave(@RequestBody Article article){
		int result = service.androidArticleSave(article);
		msg=new Message(result,"");
		return msg;
	}
	
	@PostMapping("/android/articleUpdate")
	public Message articleUpdate(@RequestBody Article article){
		int result = service.androidArticleUpdate(article);
		msg=new Message(result, "");
		return msg;
	}
	
	@PostMapping("/android/articleDelete")
	public Message articleDelete(@RequestBody Article article){
		int result = service.androidArticleDelete(article);
		msg=new Message(result, "");
		return msg;
	}
	
	@GetMapping("/android/articleList")
	public List<Map<String,Object>> articleList(){
		return service.androidArticleList();
	}
	
	@GetMapping("/android/articleSearch")
	public List<Article> articleSearch(@RequestParam(value="searchtxt") String searchtxt){
		return service.androidArticleSearch(searchtxt);
	}
}