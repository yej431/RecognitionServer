package com.web.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.web.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {		
	@Query(value="select userid from user where userid=?1", nativeQuery=true)
	String idCheck(String userid);
	
	@Modifying
	@Query(value="update upload set content=?1, files=?2, title=?3 where id=?4", nativeQuery=true)
	int boardUpdate(String content,String files,String title,int id);
	
	@Query(value="select content, files, title from upload", nativeQuery=true)
	List<Map<String, Object>> androidList();	
	
	@Query(value="select * from upload where title like %?1%", nativeQuery=true)
	List<Map<String, Object>> androidSearch(String keyword);	
	
	@Query(value="select * from article order by id desc", nativeQuery=true)
	List<Map<String, Object>> androidArticleList();	
	
	@Modifying
	@Query(value="delete from article where userid=?1", nativeQuery=true)
	int deleteArticleFromBlockUser(String userid);
	
	@Modifying
	@Query(value="insert into article(content, title, userid, writeDate) values(?1,?2,?3,now())", nativeQuery=true)
	int androidArticleSave(String content, String title, String userid);
	
	@Modifying
	@Query(value="update article set content=?2, title=?3 where id=?1", nativeQuery=true)
	int androidArticleUpdate(int id, String content, String title);
	
	@Modifying
	@Query(value="delete from article where id=?1 and userid=?2", nativeQuery=true)
	int androidArticleDelete(int id, String userid);

	@Query(value="select * from article where content like %?1% or title like %?1%", nativeQuery=true)
	List<Article> androidArticleSearch(String searchtxt);	
}