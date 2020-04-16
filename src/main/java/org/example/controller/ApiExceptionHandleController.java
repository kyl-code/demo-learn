package org.example.controller;

import org.example.exception.GlobaInfoException;
import org.example.model.RespBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ApiExceptionHandleController {

    @ExceptionHandler(GlobaInfoException.class)
    @ResponseBody
    public RespBody<String> handle(GlobaInfoException globaInfoException){
        RespBody<String> respBody = new RespBody();
        if (globaInfoException instanceof RuntimeException) {
            respBody = new RespBody<>(globaInfoException);
            return  respBody;
        }
        return  respBody;
    }
}
