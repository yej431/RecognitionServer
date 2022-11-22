package com.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.Upload;
import com.web.repository.UserStoreRepository;

@Service
public class UserStoreService {
	@Autowired
	private UserStoreRepository repository;	
	
	@Transactional
	public int androidStoreSave(String flowername, String userid){
		String check = repository.androidUserStoreCheck(flowername, userid);
		System.out.println(check);
		if(check != null) {
			return 2;
		}else {
			Upload upload = repository.androidFindFlower(flowername);
			return repository.androidStoreSave(upload.getContent(), upload.getFiles(), upload.getTitle(), userid);
		}
	}
	
	public List<Map<String, Object>> androidStoreList(String userid){
		return repository.androidStoreList(userid);
	}
}
