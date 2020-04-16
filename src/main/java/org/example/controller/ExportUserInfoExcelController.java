package org.example.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
        List<String> nameList = Arrays.asList("id", "用户名", "性别", "地址", "生日");
        List<User> users = userService.selectAll();
        ArrayList<Map<String, Object>> rows = new ArrayList<>();
        for (User user : users) {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put(nameList.get(0), user.getId());
            row.put(nameList.get(1), user.getUsername());
            row.put(nameList.get(2), user.getSex());
            row.put(nameList.get(3), user.getAddress());
            rows.add(row);
        }
        Map<String, Object> row = new LinkedHashMap<>();
        row.put(nameList.get(0), "平均值");
        row.put(nameList.get(1), "1");
        row.put(nameList.get(2), "2");
        row.put(nameList.get(3), "3");
        rows.add(row);
        ExcelWriter writer = ExcelUtil.getWriter(true);
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
}
