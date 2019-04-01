package com.transport.common;

import java.util.List;



public class ListResponse<T> {
    private List<T> data;
    private Pagination pagination;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public ListResponse(List<T> data, int total, BasePagination basePagination){
        this.data = data;
        pagination = new Pagination(total, basePagination);
    }
}
