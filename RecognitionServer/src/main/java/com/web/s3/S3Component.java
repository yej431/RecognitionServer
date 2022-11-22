package com.web.s3;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="cloud.aws.s3")
@Component
public class S3Component {
	private String bucket;
}
