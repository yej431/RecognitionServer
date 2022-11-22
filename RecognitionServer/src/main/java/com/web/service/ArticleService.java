package com.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.Article;
import com.web.model.Upload;
import com.web.repository.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepository repository;	

	public Page<Article> articleList(Pageable pageable) {
		return repository.findAll(pageable);
	}	
	public Article detail(int id) {
		return repository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
		});
	}	
	@Transactional
	public void articleDel(int id) {
		repository.deleteById(id);
	}	
	@Transactional
	public int articleUpdate(Upload board){	
		return 0;
	}
	
	/* 안드로이드 */	
	@Transactional
	public int androidArticleSave(Article article){		
		return repository.androidArticleSave(article.getContent(), article.getTitle(), article.getUserid());	
	}	
	@Transactional
	public int androidArticleUpdate(Article article){	
		return repository.androidArticleUpdate(article.getId(), article.getContent(), article.getTitle());
	}	
	@Transactional
	public int androidArticleDelete(Article article){
		return repository.androidArticleDelete(article.getId(), article.getUserid());	
	}	
	public List<Map<String, Object>> androidArticleList(){
		return repository.androidArticleList();
	}	
	public List<Article> androidArticleSearch(String searchtxt) {
		return repository.androidArticleSearch(searchtxt);
	}
}
