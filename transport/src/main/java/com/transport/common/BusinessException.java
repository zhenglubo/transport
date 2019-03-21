package com.transport.common;

public class BusinessException extends RuntimeException {

    private String errorMsg;
    private String errorCode;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public BusinessException(String errorMsg, String errorCode){
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public BusinessException(Exception e){
        this.errorMsg = e.getMessage();
        this.errorCode = ReturnCode.SYSTEM_ERROR.getCode();
    }

    public BusinessException(ReturnCode returnCode){
        this.errorCode = returnCode.getCode();
        this.errorMsg = returnCode.getMessage();
    }
}
