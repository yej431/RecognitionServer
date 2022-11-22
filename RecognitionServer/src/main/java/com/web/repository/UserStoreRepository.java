package com.web.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.web.model.Upload;

public interface UserStoreRepository extends JpaRepository<Upload,Integer> {		
	
	@Query(value="select * from upload where title like ?1", nativeQuery=true)
	Upload androidFindFlower(String flowername);	
	
	@Modifying
	@Query(value="insert into userstore(content, files, title, userid, saveDate) values(?1, ?2, ?3, ?4, now())",
		nativeQuery=true)
	int androidStoreSave(String content, String files, String title, String userid);
	
	@Query(value="select title from userstore where title=?1 and userid=?2", nativeQuery=true)
	String androidUserStoreCheck(String flowername, String userid);	
	
	@Query(value="select * from userstore where userid=?1", nativeQuery=true)
	List<Map<String, Object>> androidStoreList(String userid);	
}