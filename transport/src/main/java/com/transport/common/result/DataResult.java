package com.transport.common.result;

/**
 * @description: 结果集
 * @author: zhenglubo
 * @create: 2019-03-30 09:56
 **/

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
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DataResult)) {
            return false;
        } else {
            DataResult<?> other = (DataResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$status = this.getStatus();
                    Object other$status = other.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label59;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label59;
                    }

                    return false;
                }

                Object this$info = this.getInfo();
                Object other$info = other.getInfo();
                if (this$info == null) {
                    if (other$info != null) {
                        return false;
                    }
                } else if (!this$info.equals(other$info)) {
                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DataResult;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $info = this.getInfo();
        result = result * 59 + ($info == null ? 43 : $info.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
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
