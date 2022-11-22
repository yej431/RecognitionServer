package com.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.Upload;
import com.web.repository.FlowerListRepository;
import com.web.repository.SearchRankRepository;

@Service
public class FlowerListService {
	@Autowired
	private FlowerListRepository repository;		
	@Autowired
	private SearchRankRepository rankRepository;
	
//	@Transactional
//	public void flowerListSave(Upload upload, User user, MultipartFile file) 
//			throws IllegalStateException, IOException{	
//		String projectPath=System.getProperty("user.dir")+"\\src\\main\\webapp\\resources\\images";				
//		UUID uuid=UUID.randomUUID();
//		
//		String fileName=uuid+"_"+file.getOriginalFilename();		
//		File saveFile=new File(projectPath, fileName);		
//		file.transferTo(saveFile);
//		
//		upload.setFiles(fileName);
//		upload.setUserid(user.getUserid());		
//		repository.save(upload);				
//	}

//	@Transactional
//	public void flowerListUpdate(Upload upload, MultipartFile file) throws IllegalStateException, IOException{	
//		String projectPath=System.getProperty("user.dir")+"\\src\\main\\webapp\\resources\\images";		
//		UUID uuid=UUID.randomUUID();
//		
//		String fileName=uuid+"_"+file.getOriginalFilename();		
//		File saveFile=new File(projectPath, fileName);		
//		file.transferTo(saveFile);	
//		
//		upload.setFiles(fileName);
//		repository.flowerListUpdate(upload.getId(), upload.getContent(), upload.getFiles(), upload.getTitle());	
//	}

	public Page<Upload> flowerList(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public Upload flowerListDetail(int id) {
		return repository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
		});
	}
	
	@Transactional
	public int flowerListDelate(int id) {
		return repository.flowerListDelate(id);
	}		
	
	/* 안드로이드 */	
	
	public List<Map<String, Object>> androidList(String keyword){
		if(keyword !="" & keyword !=null) {
			return repository.androidSearch(keyword);
		}else {
			return repository.androidList();
		}	
	}
	
	@Transactional
	public List<Upload> androidFlowerSearch(String searchtxt) {
		String searchRankCheck = rankRepository.searchRankCheck(searchtxt);
		if(searchRankCheck == null) {			
			rankRepository.searchRankAdd(1, searchtxt);			
		}else {
			rankRepository.searchRankUpdate(searchtxt);
		}
		return repository.androidFlowerSearch(searchtxt);
	}	 
	
	public List<Map<String, Object>> searchRank() {
		return rankRepository.searchRank();
	}
}
