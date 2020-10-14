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
        // 上传文件并返回访问路径  参考地址：https://blog.csdn.net/RuanBigShuai/article/details/105244630?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param
        /* String filePath = ""; // 文件保存的位置
        String urlPath = "";// 文件web浏览路径
        // 原始名 以 a.jpg为例
        String originalFilename = file.getOriginalFilename();
        // 加上时间戳生成新的文件名,防止重复 newFileName = "1595511980146a.jpg"
        String newFileName = System.currentTimeMillis() + originalFilename;
        filePath = fileRootPath +  newFileName;
        System.out.println(filePath);
        try {
            File file1 = new File(filePath);
            if (!file1.exists()) file1.mkdirs(); // 要是目录不存在,创建一个
            file.transferTo(file1);              // 保存起来
            urlPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/archive/" + newFileName;
        } catch (Exception e) {
            e.printStackTrace();
        }*/

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
