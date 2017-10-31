package com.welkin.springbootseed.web.api.mysql.model;

import com.welkin.springbootseed.web.api.PageResponse;

import java.util.List;

public class SearchOrderResponse extends PageResponse<OrderVo> {
  public SearchOrderResponse(Long totalCount, List<OrderVo> results) {
    super(totalCount, results);
  }
}
