package com.example.mini.controller;

import com.example.mini.service.S3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class S3ManagementController {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<Object> upload() {
        s3Service.upload();
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getList() {
        s3Service.list();
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/list-folder")
    public ResponseEntity<Object> getListFolder() {
        s3Service.listFolder();
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/download")
    public ResponseEntity<Object> download() {
        s3Service.download();
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete() {
        s3Service.delete();
        return new ResponseEntity<>("success", HttpStatus.OK);
    }


}
