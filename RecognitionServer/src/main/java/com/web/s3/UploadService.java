package com.web.s3;

import java.io.InputStream;

import com.amazonaws.services.s3.model.ObjectMetadata;

public interface UploadService {
	void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName);
	String getFileUrl(String fileName);
}
