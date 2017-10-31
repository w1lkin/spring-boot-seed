package com.welkin.springbootseed.web.api;

import com.welkin.springbootseed.model.Page;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.QueryParam;
import java.io.Serializable;

/**
 * 分页请求
 *
 * @author welkin
 * @version 2.0.0
 */
public class PageRequest extends BaseRequest implements Serializable {

  @QueryParam(value = "pageNo")
  @ApiParam(value = "分页参数：当前分页页数")
  private Integer pageNo;

  @QueryParam(value = "pageSize")
  @ApiParam(value = "分页参数：每页条数")
  private Integer pageSize;

  private Boolean autoCount = Boolean.TRUE;

  public Integer getPageNo() {
    return pageNo != null ? pageNo : Page.DEFAULT_PAGE_NO;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  public Integer getPageSize() {
    return pageSize != null ? pageSize : Page.DEFAULT_PAGE_SIZE;
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

  public Page newPage() {
    return new Page(pageNo, pageSize, autoCount);
  }
}
