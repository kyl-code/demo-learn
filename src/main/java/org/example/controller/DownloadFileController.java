package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * @Author Adam_Guo
 * @Date 2020/4/17
 * @Version 1.0
 **/
@RestController
@RequestMapping("/")
@Api
public class DownloadFileController {

    private Logger logger = LoggerFactory.getLogger(DownloadFileController.class);

    @PostMapping("/springDownload")
    @ApiOperation(value = "使用spring的api进行模板下载")
    public void spirngDownload(HttpServletResponse response) {
    }

    @PostMapping("/download")
    @ApiOperation(value = "模板下载")
    public void download(HttpServletResponse response) {
        try {
            //获取要下载的模板名称
            String fileName = "moudle.xlsx";
            //设置要下载的文件的名称
            response.setHeader("Content-disposition", "attachment;fileName=" + fileName);
            //通知客服文件的MIME类型
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            //获取文件的路径
            String filePath = getClass().getResource("/template/" + fileName).getPath();
            FileInputStream input = new FileInputStream(filePath);
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[2048];
            int len;
            while ((len = input.read(b)) != -1) {
                out.write(b, 0, len);
            }
            //修正 Excel在“xxx.xlsx”中发现不可读取的内容。是否恢复此工作薄的内容？如果信任此工作簿的来源，请点击"是"
            response.setHeader("Content-Length", String.valueOf(input.getChannel().size()));
            out.close();
            input.close();
            //return Response.ok("应用导入模板下载完成");
        } catch (Exception ex) {
            logger.error("download :{}", ex);
            //return Response.ok("应用导入模板下载失败！");
        }
    }
}