package com.transport.common;

public enum ReturnCode {

    SUCCESS("200","ok"),
    SYSTEM_ERROR("500","system inner error"),
    EMPTY_PARAMS("600","params is empty");

    private String message;
    private String code;

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    ReturnCode(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
