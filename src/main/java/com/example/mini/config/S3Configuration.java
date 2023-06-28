package com.example.mini.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Configuration {

    @Value("${s3.region.name}")
    private String s3RegionName;

    @Getter
    @Value("${s3.bucket.name}")
    private String s3BucketName;

    @Bean
    public S3Client getS3Client() {
        return  S3Client.builder()
                .region(Region.of(s3RegionName))
                .build();
    }

}
