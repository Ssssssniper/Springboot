package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class UploadFileController {

    @RequestMapping("/Upload/configfile")
    public void receiveFile(@RequestParam MultipartFile file) throws IOException {
        InputStreamReader isr = new InputStreamReader(file.getInputStream(),"utf-8");
        BufferedReader bfRead = new BufferedReader(isr);
        while(bfRead.readLine()!= null){
            System.out.println(bfRead.readLine());
        }
        System.out.println(file);
    }
}
