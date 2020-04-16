package org.example.controller;

import io.swagger.annotations.Api;
import org.example.model.RespBody;
import org.example.service.FileHandleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

/**
 * @Author Adam_Guo
 * @Date 2020/4/11
 * @Version 1.0
 **/
@RestController
@Api
public class UploadFileController {

    @Autowired
    private FileHandleServiceImpl fileHandleService;

    @PostMapping(value = "/uploadFile",headers = "content-type=multipart/from-data",consumes = "multipart/*")
    public RespBody uploadFile(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            throw new RuntimeException("文件为空");
        }
        try {
            String originalFilename = file.getOriginalFilename();
            String name = null;
            if(originalFilename.contains("\\")){
                String[] split = originalFilename.split("\\\\");
                name = split[split.length-1];
                System.err.println(name);
            }
            String filePath = "D:\\filepath\\" + name;
            File dest = new File(filePath);
            if(!dest.getParentFile().exists()){
                dest.mkdirs();
            }
            file.transferTo(dest);
            fileHandleService.uploadFileHandle(filePath);
        } catch (IOException e) {
            throw new RuntimeException("处理异常");
        }
        return new RespBody();
    }


    private static void fileChannelOperation() throws IOException {
        FileChannel in = FileChannel.open(Paths.get("src.txt"), StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get("dest.txt"), CREATE, WRITE);
        in.transferTo(0, in.size(), out);
    }

    public static void main(String[] args) throws Exception{
        String path = "";
        final List<String> collect = Files.lines(Paths.get(path)).limit(20000).collect(Collectors.toList());
    }
}
