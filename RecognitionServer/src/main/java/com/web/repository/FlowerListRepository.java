package com.web.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.web.model.Upload;

public interface FlowerListRepository extends JpaRepository<Upload,Integer> {			
	@Modifying
	@Query(value="insert into upload(content, createDate, files, title, userid) "
			+ "values(?1, now(), ?2, ?3, ?4)",
		nativeQuery=true)
	int flowerListUpload(String content, String files, String title, String userid);		
	
	@Modifying
	@Query(value="update upload set content=?2, files=?3, title=?4, createDate=now() where id=?1",
		nativeQuery=true)
	int flowerListUpdate(int id, String content, String files, String title);
	
	@Modifying
	@Query(value="delete from upload where id=?1", nativeQuery=true)
	int flowerListDelate(int id);
	
	/* 안드로이드 */	
	
	@Query(value="select content, files, title from upload", nativeQuery=true)
	List<Map<String, Object>> androidList();	
	
	@Query(value="select * from upload where title like %?1%", nativeQuery=true)
	List<Map<String, Object>> androidSearch(String keyword);	
	
	@Query(value="select * from upload where title like ?1", nativeQuery=true)
	Upload androidFindFlower(String flowername);	
	
	@Modifying
	@Query(value="insert into userstore(content, files, title, userid, saveDate) values(?1, ?2, ?3, ?4, now())",
		nativeQuery=true)
	void androidStoreSave(String content, String files, String title, String userid);
	
	@Query(value="select * from userstore", nativeQuery=true)
	Map<String, Object> androidUserStoreList();		
	
	@Query(value="select * from upload where title like %?1%", nativeQuery=true)
	List<Upload> androidFlowerSearch(String searchtx);
}