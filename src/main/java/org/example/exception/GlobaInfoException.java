package org.example.exception;

import org.example.model.ErrorInfoInterface;

public class GlobaInfoException extends  RuntimeException{
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    private String code;
    private String message;

    public GlobaInfoException(ErrorInfoInterface errorInfoInterface) {
        this.code = errorInfoInterface.getCode();
        this.message = errorInfoInterface.getMessage();
    }

    public GlobaInfoException(String message, String code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public GlobaInfoException(String message, Throwable cause, String code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public GlobaInfoException(Throwable cause, String code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public GlobaInfoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
    }
}
