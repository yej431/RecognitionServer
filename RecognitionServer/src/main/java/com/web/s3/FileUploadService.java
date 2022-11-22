package com.web.s3;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.web.model.Upload;
import com.web.model.User;
import com.web.repository.FlowerListRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileUploadService {
	private final UploadService s3Service;
	private final FlowerListRepository repository;	
	
	@Transactional
	public void uploadImage(MultipartFile file, Upload upload, User user) {
		String fileName=createFileName(file.getOriginalFilename());
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentLength(file.getSize());
		objectMetadata.setContentType(file.getContentType());
		try(InputStream inputStream = file.getInputStream()){
			s3Service.uploadFile(inputStream, objectMetadata, fileName);
		}catch(IOException e) {
			throw new IllegalArgumentException(String.format("파일 변환 중 에러가 발생하였습니다. (%s)",
					file.getOriginalFilename()));
		}
		
		upload.setFiles(s3Service.getFileUrl(fileName));
		upload.setUserid(user.getUserid());		
		repository.flowerListUpload(upload.getContent(), upload.getFiles(), upload.getTitle(),
				upload.getUserid());
	}
	
	@Transactional
	public void updateImage(MultipartFile file, Upload upload) {
		String fileName=createFileName(file.getOriginalFilename());
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentLength(file.getSize());
		objectMetadata.setContentType(file.getContentType());
		try(InputStream inputStream = file.getInputStream()){
			s3Service.uploadFile(inputStream, objectMetadata, fileName);
		}catch(IOException e) {
			throw new IllegalArgumentException(String.format("파일 변환 중 에러가 발생하였습니다. (%s)",
					file.getOriginalFilename()));
		}
		
		upload.setFiles(s3Service.getFileUrl(fileName));
		repository.flowerListUpdate(upload.getId(), upload.getContent(), 
				upload.getFiles(), upload.getTitle());
	}
	
	private String createFileName(String originalFileName) {
		return UUID.randomUUID().toString().concat(getFileExtension(originalFileName));
	}
	
	private String getFileExtension(String fileName) {
		try {
			return fileName.substring(fileName.lastIndexOf("."));
		}catch(StringIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(String.format("잘못된 형식의 파일 (%s) 입니다", fileName));
		}
	}
}
