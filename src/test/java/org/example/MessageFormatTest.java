package org.example;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @Author Adam_Guo
 * @Date 2020/5/3
 * @Version 1.0
 **/
public class MessageFormatTest {
    public static void main(String[] args) {
        String result = MessageFormat.format("ATt{0,time}", new Date());
        System.err.println(result);
    }
}
