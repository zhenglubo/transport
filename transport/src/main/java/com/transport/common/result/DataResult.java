package com.transport.common.result;

import lombok.EqualsAndHashCode;

/**
 * @description: 结果集
 * @author: zhenglubo
 * @create: 2019-03-30 09:56
 **/

@EqualsAndHashCode
public class DataResult<T> {

    private Integer status;
    private String info;
    private String message;
    private T data;

    public DataResult<T> success() {
        this.status = ErrorCode.SUCCESS_CODE.getCode();
        this.info = ErrorCode.SUCCESS_CODE.getMsg();
        this.message = this.info;
        return this;
    }

    public DataResult<T> success(T data) {
        this.status = ErrorCode.SUCCESS_CODE.getCode();
        this.info = ErrorCode.SUCCESS_CODE.getMsg();
        this.message = this.info;
        this.data = data;
        return this;
    }

    public DataResult<T> fail(String message) {
        this.status = ErrorCode.FAIL_CODE.getCode();
        this.info = ErrorCode.FAIL_CODE.getMsg();
        this.message = message;
        return this;
    }

    public DataResult<T> fail(int status, String info, String message) {
        this.status = status;
        this.info = info;
        this.message = message;
        return this;
    }

    public static <T> DataResult.DataResultBuilder<T> builder() {
        return new DataResult.DataResultBuilder();
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getInfo() {
        return this.info;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public void setInfo(final String info) {
        this.info = info;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setData(final T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataResult(status=" + this.getStatus() + ", info=" + this.getInfo() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }

    public DataResult() {
    }

    public DataResult(final Integer status, final String info, final String message, final T data) {
        this.status = status;
        this.info = info;
        this.message = message;
        this.data = data;
    }

    public static class DataResultBuilder<T> {
        private Integer status;
        private String info;
        private String message;
        private T data;

        DataResultBuilder() {
        }

        public DataResult.DataResultBuilder<T> status(final Integer status) {
            this.status = status;
            return this;
        }

        public DataResult.DataResultBuilder<T> info(final String info) {
            this.info = info;
            return this;
        }

        public DataResult.DataResultBuilder<T> message(final String message) {
            this.message = message;
            return this;
        }

        public DataResult.DataResultBuilder<T> data(final T data) {
            this.data = data;
            return this;
        }

        public DataResult<T> build() {
            return new DataResult(this.status, this.info, this.message, this.data);
        }

        @Override
        public String toString() {
            return "DataResult.DataResultBuilder(status=" + this.status + ", info=" + this.info + ", message=" + this.message + ", data=" + this.data + ")";
        }
    }
}
