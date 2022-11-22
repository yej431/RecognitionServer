package com.web.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.web.model.SearchRank;

public interface SearchRankRepository extends JpaRepository<SearchRank, Integer> {		
	
	@Query(value="select cnt from searchrank where keyword=?1", nativeQuery=true)
	String searchRankCheck(String keyword);	
	
	@Modifying
	@Query(value="insert into searchrank(cnt, keyword) values(?1, ?2)", nativeQuery=true)
	void searchRankAdd(int cnt, String keyword);
	
	@Modifying
	@Query(value="update searchrank set cnt = cnt+1 where keyword=?1", nativeQuery=true)
	void searchRankUpdate(String keyword);
	
	@Query(value="select keyword from searchrank order by cnt desc limit 7", nativeQuery=true)
	List<Map<String, Object>> searchRank();	
	
	@Query(value="select cnt, keyword from searchrank limit 6", nativeQuery=true)
	List<Map<String, Object>> searchChart();
}