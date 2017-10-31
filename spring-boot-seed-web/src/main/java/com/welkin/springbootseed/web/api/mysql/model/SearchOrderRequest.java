package com.welkin.springbootseed.web.api.mysql.model;

import com.welkin.springbootseed.web.api.DateParameter;
import com.welkin.springbootseed.web.api.PageRequest;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.QueryParam;

public class SearchOrderRequest extends PageRequest {
  @QueryParam("id")
  @ApiParam("订单ID")
  private Integer id;

  @QueryParam("orderNo")
  @ApiParam("订单编号")
  private String orderNo;

  @QueryParam("entryBeginTime")
  @ApiParam("进件开始时间")
  private DateParameter entryBeginTime;

  @QueryParam("entryEndTime")
  @ApiParam("进件结束时间")
  private DateParameter entryEndTime;

  @QueryParam("fundType")
  @ApiParam("资金类型：0-正常融资 1-自有资金 2-临时垫资")
  private Byte fundType;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public DateParameter getEntryBeginTime() {
    return entryBeginTime;
  }

  public void setEntryBeginTime(DateParameter entryBeginTime) {
    this.entryBeginTime = entryBeginTime;
  }

  public DateParameter getEntryEndTime() {
    return entryEndTime;
  }

  public void setEntryEndTime(DateParameter entryEndTime) {
    this.entryEndTime = entryEndTime;
  }

  public Byte getFundType() {
    return fundType;
  }

  public void setFundType(Byte fundType) {
    this.fundType = fundType;
  }
}
