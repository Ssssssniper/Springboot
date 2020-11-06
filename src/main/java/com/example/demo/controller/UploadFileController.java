package com.example.demo.controller;

import com.example.demo.analysisfile.AnalysisConfigFile;
import com.example.demo.analysisfile.AnalysisResult;
import com.example.demo.bean.TkNetNodeFile;
import com.example.demo.common.Msg;
import com.example.demo.dao.TkNetNodeFileMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Date;

/**
 *  文件上传
 */
@RestController
public class UploadFileController {

    @Autowired
    TkNetNodeFileMapping fileMapping;

    // 上传文件   保存库表
    @PostMapping("/Upload/configfile")
    public Msg receiveFile(@RequestParam MultipartFile file) throws IOException {
//        InputStreamReader isr = new InputStreamReader(file.getInputStream(),"utf-8");
//        BufferedReader bfRead = new BufferedReader(isr);
//        while(bfRead.readLine()!= null){
//            System.out.println(bfRead.readLine());
//        }
//        System.out.println(file);
        //解析回送
        AnalysisResult tkFile = AnalysisConfigFile.analysisInputStreamType(file.getInputStream());

        // 文件存储
        TkNetNodeFile Tk = new TkNetNodeFile();
        String[] substr = file.getOriginalFilename().replace(".tk", "").split("v");
        Tk.setFname(substr[0]);
        Tk.setFuploadtime(new Date());
        Tk.setFcontent(file.getBytes());
        Tk.setFisNew(1);
        Tk.setFversion(substr[1]);
        fileMapping.saveFile(Tk);

        return Msg.success().add("data", tkFile.getNetNodeList());
    }

}
