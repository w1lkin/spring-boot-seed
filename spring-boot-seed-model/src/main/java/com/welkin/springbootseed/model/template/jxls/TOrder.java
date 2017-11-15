package com.welkin.springbootseed.model.template.jxls;

import java.util.Date;

/** 订单详情 模板模型 */
public class TOrder {
  /** 订单ID */
  private Integer id;
  /** 城市ID */
  private Integer cityId;
  /** 订单中心编号 */
  private Long orderCenterNo;
  /** 状态：0-未知 */
  private Integer status;
  /** 申请时间 */
  private Date createTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  public Long getOrderCenterNo() {
    return orderCenterNo;
  }

  public void setOrderCenterNo(Long orderCenterNo) {
    this.orderCenterNo = orderCenterNo;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
