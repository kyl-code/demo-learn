package org.example;

import cn.hutool.core.math.MathUtil;
import com.alibaba.fastjson.JSONObject;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author Adam_Guo
 * @Date 2020/5/3
 * @Version 1.0
 **/
public class MessageFormatTest {
    public static void main(String[] args) {
        String result = MessageFormat.format("ATt{0,time}", new Date());
        System.err.println(result);
        String[] strings = {"3","12","45"};
        List<String[]> strings1 = MathUtil.arrangementSelect(strings);
        for(String[] s : strings1){
            System.err.println(JSONObject.toJSON(s));
        }
    }
}
