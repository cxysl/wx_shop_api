package com.cxysl.comm;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {

    private int pageSize = 10;      //每页页面个数
    private int totalCount;     //数据总数
    private int totalpage;      //总页数
    private int curenPage = 1;
    private int nextpage;
    private int prePage;
    private int firstpage;
    private int lastpage;

    private List<T> arrys; //数据

    //页码
    public List<Integer> getIndexs() {
        for (int i = 1; i <= this.getTotalpage(); i++) {
            indexs.add(i);
        }
        return indexs;
    }

    public void setIndexs(List<Integer> indexs) {
        this.indexs = indexs;
    }

    private List<Integer> indexs = new ArrayList<>();


    public List<T> getArrys() {
        return arrys;
    }

    public void setArrys(List<T> arrys) {
        this.arrys = arrys;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 计算总页数
     * @return
     */
    public int getTotalpage() {
        if(totalCount%pageSize==0)
            return totalCount/pageSize;
        else
            return totalCount/pageSize+1;
    }

    public int getCurenPage() {
        return curenPage;
    }

    public void setCurenPage(int curenPage) {
        this.curenPage = curenPage;
    }

    /**
     * 计算下一页
     * @return
     */
    public int getNextpage() {
        if(curenPage<this.getTotalpage())
            return curenPage+1;
        else
            return this.getTotalpage();
    }

    /***
     * 计算上一页
     * @param
     */
    public int getPrePage() {
        if(curenPage>1)
            return curenPage-1;
        else
            return this.getFirstpage();
    }

    /**
     * 首页
     * @return
     */
    public int getFirstpage() {
        return 1;
    }

    /**
     * 尾页
     * @return
     */
    public int getLastpage() {
        return this.getTotalpage();
    }

}