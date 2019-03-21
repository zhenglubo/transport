package com.transport.common;

public class BasePagination {

    private int current = 1;
    private int size = 10;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BasePagination(int current, int size) {
        this.current = current;
        this.size = size;
    }
}
