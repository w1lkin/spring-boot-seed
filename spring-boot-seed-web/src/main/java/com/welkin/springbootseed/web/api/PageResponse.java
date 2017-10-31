package com.welkin.springbootseed.web.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.welkin.springbootseed.model.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页响应
 *
 * @author welkin
 * @version 2.0.0
 */
public class PageResponse<T> implements Serializable {

  @JsonProperty("Count")
  private Long totalCount;

  @JsonProperty("Items")
  private List<T> results = new ArrayList<>();

  public PageResponse() {}

  public PageResponse(Long totalCount, List<T> results) {
    this.totalCount = totalCount;
    this.results = results;
  }

  public PageResponse(Page page) {
    this.totalCount = page.getTotalCount();
    this.results = page.getResults();
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

  public void setResults(List<T> results) {
    this.results = results;
  }
}
