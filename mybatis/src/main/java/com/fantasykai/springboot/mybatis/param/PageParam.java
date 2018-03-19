package com.fantasykai.springboot.mybatis.param;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/19 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class PageParam {

    /**
     * 起始行
     */
    private int beginLine;

    /**
     *
     */
    private Integer pageSize = 5;

    private Integer currentPage = 0;


    public int getBeginLine() {
        return beginLine;
    }

    public void setBeginLine(int beginLine) {
        this.beginLine = beginLine;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }
}
