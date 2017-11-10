package com.welkin.springbootseed.web.api.mysql.model;

import com.welkin.springbootseed.web.api.PageResponse;

import java.util.List;

public class SearchOrderResponse extends PageResponse<OrderVO> {
  public SearchOrderResponse(Long totalCount, List<OrderVO> results) {
    super(totalCount, results);
  }
}
