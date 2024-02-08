package com.practice.pdf;

public class Header {

    private String headerName;
    private int width;

    public Header(String headerName, int width) {
        this.headerName = headerName;
        this.width = width;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
