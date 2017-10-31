package com.welkin.springbootseed.model.dto.order;

import com.welkin.springbootseed.model.Page;

import java.util.Date;

public class SearchOrderCondition extends Page {
  /** 订单ID */
  private Integer id;

  /** 订单编号 */
  private String orderNo;

  /** 进件开始时间 */
  private Date entryBeginTime;

  /** 进件结束时间 */
  private Date entryEndTime;

  /** 资金类型：0-正常融资 1-自有资金 2-临时垫资 */
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

  public Date getEntryBeginTime() {
    return entryBeginTime;
  }

  public void setEntryBeginTime(Date entryBeginTime) {
    this.entryBeginTime = entryBeginTime;
  }

  public Date getEntryEndTime() {
    return entryEndTime;
  }

  public void setEntryEndTime(Date entryEndTime) {
    this.entryEndTime = entryEndTime;
  }

  public Byte getFundType() {
    return fundType;
  }

  public void setFundType(Byte fundType) {
    this.fundType = fundType;
  }
}
