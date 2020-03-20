package com.tianhy.datastructures.compare;

/**
 * @Author: thy
 * @Date: 2020/2/24 17:59
 * @Desc: 自定义的方式排序, 实现Comparable的方式
 */
public class SearchResult implements Comparable<SearchResult> {

    //相关度
    int relativeRatio;
    //浏览数
    long count;
    //最近订单数
    int recentOrders;

    public SearchResult(int relativeRatio, long count) {
        this.relativeRatio = relativeRatio;
        this.count = count;
    }


    public void setRecentOrders(int recentOrders) {
        this.recentOrders = recentOrders;
    }


    @Override
    public int compareTo(SearchResult o) {
        //先比较相关度
        if (this.relativeRatio != o.relativeRatio) {
            return this.relativeRatio > o.relativeRatio ? 1 : -1;
        }
        //相关度相等时再比较浏览数
        if (this.count != o.count) {
            return this.count > o.count ? 1 : -1;
        }
        return 0;
    }

}
