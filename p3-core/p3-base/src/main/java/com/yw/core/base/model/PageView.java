package com.yw.core.base.model;


import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @author Administrator
 */
public class PageView<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_PAGE_NUM = 1;

    private static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 每页的数量
     */
    private int pageSize;
    /**
     * 当前页的数量
     */
    private int size;

    /**
     * 总记录数
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 结果集
     */
    private List<T> list;

    public PageView() {
        this(Collections.emptyList());
    }

    /**
     * 包装Page对象
     *
     * @param list page结果
     */
    public PageView(List<T> list) {
        this(list, DEFAULT_PAGE_NUM, DEFAULT_PAGE_SIZE);
    }

    /**
     * 包装Page对象
     *
     * @param pageParam page结果
     */
    public PageView(PageParam pageParam) {
        this(Collections.emptyList(), pageParam.getPageNum(), pageParam.getPageSize());
    }

    /**
     * 包装Page对象
     *
     * @param list page结果
     */
    public PageView(List<T> list, PageParam pageParam) {
        this(list, pageParam.getPageNum(), pageParam.getPageSize());
    }

    /**
     * 包装Page对象
     *
     * @param list     所有记录列表
     * @param pageNum  第几页
     * @param pageSize 每页记录数
     */
    public PageView(List<T> list, int pageNum, int pageSize) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.pages = page.getPages();
            this.list = list;
            this.size = page.size();
            this.total = page.getTotal();
        } else if (list != null) {
            pageSize = (pageSize <= 0) ? Math.max(list.size(), DEFAULT_PAGE_SIZE) : pageSize;
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.total = list.size();
            this.pages = list.size() / pageSize + (list.size() % pageSize == 0 ? 0 : 1);
            int start = pageNum <= 1 ? 0 : (pageNum - 1) * pageSize;
            if (list.isEmpty() || start >= list.size()) {
                this.list = Collections.emptyList();
            } else {
                if (start + pageSize < list.size()) {
                    this.list = list.subList(start, start + pageSize);
                } else {
                    if (start > 0) {
                        this.list = list.subList(start, list.size());
                    } else {
                        this.list = list;
                    }
                }
            }
            this.size = this.list.size();
        }
    }

    /**
     * 应用分页结果
     *
     * @param list  当前页记录
     * @param total 总记录数
     */
    public <E> PageView<E> apply(List<E> list, long total) {
        PageView<E> result = (PageView<E>) this;
        result.total = total;
        result.pages = (int) (total / pageSize + (total % pageSize == 0 ? 0 : 1));
        result.list = list;
        result.size = list.size();
        return result;
    }


//    /**
//     * T对象映射
//     *
//     * @author guocp
//     * @date 2017年12月20日
//     */
//    public <E> PageView<E> listMap(Class<E> classs) {
//        @SuppressWarnings("unchecked")
//        PageView<E> map = (PageView<E>) this;
//        map.setList(BeanMapper.mapList(this.getList(), classs));
//        return map;
//    }

    /**
     * 对象映射
     */
    public <E> PageView<E> listMap(List<E> list) {
        PageView<E> pageView = (PageView<E>) this;
        pageView.setList(list);
        return pageView;
    }

    /**
     * 自定义转换器
     */
    public <R> PageView<R> listMap(Function<T, R> function) {
        PageView<R> map = (PageView<R>) this;
        if (getList() != null && getList().size() > 0) {
            map.setList(getList().stream().map(function).collect(Collectors.toList()));
        }
        return map;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageView [pageNum=" + pageNum + ", pageSize=" + pageSize + ", size=" + size
                + ", total=" + total
                + ", pages=" + pages + ", list=" + list + "]";
    }

}
