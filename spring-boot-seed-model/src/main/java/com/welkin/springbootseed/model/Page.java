package com.welkin.springbootseed.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable {

  public static final Integer DEFAULT_PAGE_NO = 1;

  public static final Integer DEFAULT_PAGE_SIZE = 20;

  private Integer pageNo;

  private Integer pageSize;

  private Boolean autoCount = Boolean.TRUE;

  private Long totalCount;

  private List<T> results = new ArrayList<T>();

  public Page() {}

  public Page(List<T> list) {
    setResults(list);
  }

  public Page(Long totalCount, List<T> results) {
    this.totalCount = totalCount;
    this.results = results;
  }

  public Page(Integer pageNo, Integer pageSize) {
    this.pageNo = pageNo;
    this.pageSize = pageSize;
  }

  public Page(Integer pageNo, Integer pageSize, Boolean autoCount) {
    this.pageNo = pageNo;
    this.pageSize = pageSize;
    this.autoCount = autoCount;
  }

  public int getPageNo() {
    return pageNo != null ? pageNo : DEFAULT_PAGE_NO;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  public int getPageSize() {
    return pageSize != null ? pageSize : DEFAULT_PAGE_SIZE;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Boolean getAutoCount() {
    return autoCount;
  }

  public void setAutoCount(Boolean autoCount) {
    this.autoCount = autoCount;
  }

  public Long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Long totalCount) {
    this.totalCount = totalCount;
  }

  public List<T> getResults() {
    return results;
  }

  public void setResults(List<T> list) {

    if (list instanceof com.github.pagehelper.Page) {
      com.github.pagehelper.Page page = (com.github.pagehelper.Page) list;
      this.totalCount = page.getTotal();
    }
    this.results = list;
  }
}
