package com.fantasykai.springboot.mybatis.result;

import com.fantasykai.springboot.mybatis.param.PageParam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/19 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class Page<E> implements Serializable {
    private static final long serialVersionUID = -7116297438702511877L;

    /**
     * 当前页数
     */
    private int currentPage = 1;

    /**
     * 总页数
     */
    private long totalPage;

    /**
     * 总记录数
     */
    private long totalNumber;

    /**
     * 结果集
     */
    private List<E> list;

    public static Page NULL = new Page(0, 0, 20, new ArrayList<>());

    public Page() {
        super();
    }

    public Page(int beginLine, long totalNumber, int pageSize, List<E> list) {
        this.currentPage = beginLine / pageSize + 1;
        this.totalNumber = totalNumber;
        this.totalPage = totalNumber % pageSize == 0 ? totalNumber / pageSize : totalNumber / pageSize + 1;
        this.list = list;
    }

    public Page(PageParam pageParam, long totalNumber, List<E> list) {
        super();
        this.currentPage = pageParam.getCurrentPage();
        this.totalNumber = totalNumber;
        this.list = list;
        this.totalPage = totalNumber % pageParam.getPageSize() == 0 ? totalNumber / pageParam.getPageSize() : totalNumber / pageParam.getPageSize() + 1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }
}
