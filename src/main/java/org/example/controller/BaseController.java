package org.example.controller;

import org.example.model.RespBody;

public class BaseController<T> {

    public RespBody<T> successData(){
        RespBody<Object> respBody = new RespBody<>();
        return new RespBody<>();
    }

    public RespBody successData(T param){
        RespBody respBody = new RespBody<>();
        respBody.setParam(param);
        return respBody;
    }
}
