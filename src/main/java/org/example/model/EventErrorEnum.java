package org.example.model;

public enum  EventErrorEnum implements ErrorInfoInterface{
    SUCCESS("000","success"),
    DATABASE_ERROR("50","query database exception"),
    ERROR("100","error")
    ;

    private String code;
    private String message;

    EventErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code = code;
    }

    @Override
    public String getMessage() {
        return this.message = message;
    }
}
