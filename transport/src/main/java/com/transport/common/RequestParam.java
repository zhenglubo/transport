package com.transport.common;

public class RequestParam<T> {

    private T data;
    private BasePagination basePagination;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BasePagination getBasePagination() {
        return basePagination;
    }

    public void setBasePagination(BasePagination basePagination) {
        this.basePagination = basePagination;
    }

    public RequestParam() {
    }

    public RequestParam(T data, BasePagination basePagination) {
        this.data = data;
        this.basePagination = basePagination;
    }
}
