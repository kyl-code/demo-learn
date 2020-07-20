package org.example.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.apache.commons.compress.utils.Lists;
import org.example.model.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static org.springframework.context.ConfigurableApplicationContext.ENVIRONMENT_BEAN_NAME;

/**
 * @Author Adam_Guo
 * @Date 2020/4/14
 * @Version 1.0
 **/
@Controller
@RequestMapping("/export")
@Api
public class ExportUserInfoExcelController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/exportUserInfo", method = RequestMethod.GET,headers = "Accept=application/octet-stream")
    @ResponseBody
    @ApiOperation(value = "用户表导出", notes = "用户表导出",produces = "application/octet-stream")
    public void outputUserInfo(HttpServletResponse response) throws Exception {
        List<String> nameList = Arrays.asList("id", "用户名", "密码");
        List<User> users = Lists.newArrayList();
        for(int i = 0;i<2000000;i++){
            User user = new User();
            user.setId(Long.valueOf(i));
            user.setName("xiaoming");
            user.setPassword("123");
            users.add(user);
        }
        ArrayList<Map<String, Object>> rows = new ArrayList<>();
        for (User user : users) {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put(nameList.get(0), user.getId());
            row.put(nameList.get(1), user.getName());
            row.put(nameList.get(2), user.getPassword());
            rows.add(row);
        }
        Map<String, Object> row = new LinkedHashMap<>();
        row.put(nameList.get(0), "平均值");
        row.put(nameList.get(1), "1");
        row.put(nameList.get(2), "2");
        rows.add(row);
        long objectSize = ObjectSizeCalculator.getObjectSize(rows);
        System.err.println(objectSize/(1 << 10 * 1<< 10));
        ExcelWriter writer = ExcelUtil.getBigWriter();
        //跳过当前行，既第一行，非必须，在此演示用
        // writer.passCurrentRow();
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(rows.get(0).size() - 1, "用户表");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition", "attachment;filename=user.xlsx");
        ServletOutputStream out = response.getOutputStream();

        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }

    @RequestMapping(value = "/exportBigUserInfo", method = RequestMethod.GET,headers = "Accept=application/octet-stream")
    @ResponseBody
    @ApiOperation(value = "用户表导出", notes = "用户表导出",produces = "application/octet-stream")
    public void outputBigUserInfo(HttpServletResponse response) throws Exception {
        List<String> nameList = Arrays.asList("id", "用户名", "密码");
        List<User> users = Lists.newArrayList();
        for(int i = 0;i<1000000;i++){
            User user = new User();
            user.setId(Long.valueOf(i));
            user.setName("xiaoming");
            user.setPassword("123");
            users.add(user);
        }
        ArrayList<Map<String, Object>> rows = new ArrayList<>();
        for (User user : users) {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put(nameList.get(0), user.getId());
            row.put(nameList.get(1), user.getName());
            row.put(nameList.get(2), user.getPassword());
            rows.add(row);
        }
        Map<String, Object> row = new LinkedHashMap<>();
        row.put(nameList.get(0), "平均值");
        row.put(nameList.get(1), "1");
        row.put(nameList.get(2), "2");
        rows.add(row);
        ExcelWriter writer = ExcelUtil.getBigWriter();
        //跳过当前行，既第一行，非必须，在此演示用
        // writer.passCurrentRow();
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(rows.get(0).size() - 1, "用户表");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition", "attachment;filename=user.xlsx");
        ServletOutputStream out = response.getOutputStream();

        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }

    @RequestMapping(value = "/exportInfo", method = RequestMethod.GET,headers = "Accept=application/octet-stream")
    @ResponseBody
    @ApiOperation(value = "用户表导出", notes = "用户表导出",produces = "application/octet-stream")
    public void output(HttpServletResponse response) throws Exception {
        List<User> users = Lists.newArrayList();
        for(int i = 0;i<100;i++){
            User user = new User();
            user.setId(Long.valueOf(i));
            user.setName("xiaoming");
            user.setPassword("123");
            users.add(user);
        }
        //ExcelWriter writer = ExcelUtil.getBigWriter();
        ExcelWriter writer = ExcelUtil.getWriter(true);
        List<String> list = Arrays.asList("序号","姓名","密码");
        writer.writeHeadRow(list);
        writer.write(users, false);
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition", "attachment;filename=user.xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }

    @RequestMapping(value = "/exportObject", method = RequestMethod.GET,headers = "Accept=application/octet-stream")
    @ResponseBody
    @ApiOperation(value = "用户表导出", notes = "用户表导出",produces = "application/octet-stream")
    public void output2(HttpServletResponse response) throws Exception {
        List<List<Object>> rows = Lists.newArrayList();
        List<Object> row = Arrays.asList("序号","性别","学习");
        rows.add(row);
        //ExcelWriter writer = ExcelUtil.getBigWriter();
        ExcelWriter writer = ExcelUtil.getWriter(true);
        List<String> list = Arrays.asList("序号","姓名","密码");
        writer.writeHeadRow(list);
        writer.write(rows, false);
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition", "attachment;filename=object.xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
        String environmentBeanName = ENVIRONMENT_BEAN_NAME;
    }
}
