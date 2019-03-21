package com.transport.common;

public class Pagination extends BasePagination {

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Pagination(int total, BasePagination basePagination) {
        super(basePagination.getCurrent(), basePagination.getSize());
        this.total = total;
    }
}
