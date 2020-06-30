package org.example.model;

import org.example.exception.GlobaInfoException;

public class RespBody<T> {
    private String message;
    private String code;
    private transient T param;

    public RespBody(){
        this.code = EventErrorEnum.SUCCESS.getCode();
        this.message = EventErrorEnum.SUCCESS.getMessage();
    }

    public RespBody(T param){
        this.code = EventErrorEnum.SUCCESS.getCode();
        this.message = EventErrorEnum.SUCCESS.getMessage();
        this.param = param;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public RespBody(ErrorInfoInterface errorInfoInterface){
        this.code = errorInfoInterface.getCode();
        this.message = errorInfoInterface.getMessage();
    }

    public RespBody(GlobaInfoException exception){
        this.code = exception.getCode();
        this.message = exception.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }
}
