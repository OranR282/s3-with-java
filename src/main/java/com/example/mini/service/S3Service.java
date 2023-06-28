package com.example.mini.service;

import com.example.mini.config.S3Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class S3Service {

    @Autowired
    private S3Client s3Client;

    @Autowired
    private S3Configuration s3Configuration;

    public void upload(){
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(s3Configuration.getS3BucketName())
                .key("hello.txt")
                .build();

        s3Client.putObject(request,
                RequestBody.fromFile(new File("/Users/5360550/Documents/hello.txt"))
        );
    }

    public void list(){
        ListObjectsRequest request = ListObjectsRequest.builder()
                .bucket(s3Configuration.getS3BucketName())
                .build();

        ListObjectsResponse listObjectsResponse = s3Client.listObjects(request);
        for(S3Object object : listObjectsResponse.contents()) {
            System.out.println("file : " + object.key());
        }
    }

    public void download(){
        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(s3Configuration.getS3BucketName())
                .key("hello.txt")
                .build();
        ResponseInputStream<GetObjectResponse> object = s3Client.getObject(request);

        File outputFile = new File("/Users/XXX/Documents/S3/hello2.txt");
        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            outputStream.write(object.readAllBytes());
        }catch (Exception e){

        }
    }

    public void delete(){
        DeleteObjectRequest request = DeleteObjectRequest.builder()
                .bucket(s3Configuration.getS3BucketName())
                .key("hello.txt")
                .build();
        s3Client.deleteObject(request);

    }
}
