package com.transport.common.exception;

/**
 * @description: 全局异常
 * @author: zhenglubo
 * @create: 2019-04-11 15:57
 **/

public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int code = 1;
    private String error = "业务异常";

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(int code, String error, String msg) {
        super(msg);
        this.code = code;
        this.error = error;
    }

    public GlobalException(int code, String error, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.error = error;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof GlobalException)) {
            return false;
        } else {
            GlobalException other = (GlobalException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$error = this.getError();
                Object other$error = other.getError();
                if (this$error == null) {
                    if (other$error == null) {
                        return true;
                    }
                } else if (this$error.equals(other$error)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GlobalException;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = super.hashCode();
        result = result * 59 + this.getCode();
        Object $error = this.getError();
        result = result * 59 + ($error == null ? 43 : $error.hashCode());
        return result;
    }

    public int getCode() {
        return this.code;
    }

    public String getError() {
        return this.error;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setError(final String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "GlobalException(code=" + this.getCode() + ", error=" + this.getError() + ")";
    }
}
