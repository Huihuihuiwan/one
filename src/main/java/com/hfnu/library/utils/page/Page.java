package com.hfnu.library.utils.page;

import java.util.List;

/**
 * Author : wendy_wan
 * Created : 2020/2/4 13:01
 */
public class Page<T> {

    private List<T> list;//T类型的对象

    private int pageNum; //当前页码

    private int pageSize;//每页数量

    private int pageCount;//总页数


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
