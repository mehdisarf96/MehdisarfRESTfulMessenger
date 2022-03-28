package com.mehdisarf.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {

    @QueryParam("year")
    private int yrs;

    @QueryParam("start")
    private int strt;

    @QueryParam("size")
    private int sz;

    public int getYrs() {
        return yrs;
    }

    public void setYrs(int yrs) {
        this.yrs = yrs;
    }

    public int getStrt() {
        return strt;
    }

    public void setStrt(int strt) {
        this.strt = strt;
    }

    public int getSz() {
        return sz;
    }

    public void setSz(int sz) {
        this.sz = sz;
    }
}
