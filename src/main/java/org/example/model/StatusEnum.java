package org.example.model;

/**
 * @Author Adam_Guo
 * @Date 2020/4/17
 * @Version 1.0
 **/
public enum StatusEnum {
    Success(000,"成功"),
    Failed(200,"失败");

    private int code;
    private String message;

    StatusEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
