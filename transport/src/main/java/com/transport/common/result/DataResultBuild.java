package com.transport.common.result;

/**
 * @description: 结果集封装
 * @author: zhenglubo
 * @create: 2019-03-30 09:55
 **/

public class DataResultBuild<T> {
    public DataResultBuild() {
    }

    public static <T> DataResult<T> success() {
        return (new DataResult()).success();
    }

    public static <T> DataResult<T> success(T data) {
        return (new DataResult()).success(data);
    }

    public static <T> DataResult<T> fail(String message) {
        return (new DataResult()).fail(message);
    }

    public static <T> DataResult<T> fail(int status, String info, String message) {
        return (new DataResult()).fail(status, info, message);
    }
}
