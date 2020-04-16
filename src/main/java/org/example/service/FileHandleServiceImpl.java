package org.example.service;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.example.model.form.UploadFileForm;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author Adam_Guo
 * @Date 2020/4/11
 * @Version 1.0
 **/
@Component
public class FileHandleServiceImpl {

    public void uploadFileHandle(String path){
        ExcelReader reader = ExcelUtil.getReader(path, 0);
        List<Map<String, Object>> list = reader.read(1, 2, reader.getRowCount());
        list.stream().forEach(map -> System.err.println(map));
    }

    private UploadFileForm convert(Map<String, Object> map){
        return null;
    }
}
