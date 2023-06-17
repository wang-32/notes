package com.hspedu.furns.entity;

import java.util.List;

/**
 * 分页数据模型
 * @param <T>
 */
public class Page<T> {

    public static final Integer PAGE_SIZE = 3;

    //显示第几页
    private Integer pageNo;
    //每页显示几条记录
    private Integer pageSize = PAGE_SIZE;
    //表示共多少页
    private Integer pageTotalCount;
    //多少条记录
    private Integer totalRow;
    //当前页的数据
    private List<T> items;
    //分页导航的字符串
    private String url;



    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
