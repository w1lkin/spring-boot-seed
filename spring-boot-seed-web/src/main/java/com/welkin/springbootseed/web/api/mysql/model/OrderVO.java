package com.welkin.springbootseed.web.api.mysql.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class OrderVO implements Serializable {
  @ApiModelProperty("id")
  private Integer id;

  @ApiModelProperty("城市ID")
  private Integer cityId;

  @ApiModelProperty("订单中心编号")
  private Long orderCenterNo;

  @ApiModelProperty("订单编号")
  private String orderNo;

  @ApiModelProperty("tfs_customer.id")
  private Integer customerId;

  @ApiModelProperty("tfs_product.id")
  private Integer productId;

  @ApiModelProperty("流程实例id")
  private String processInstanceId;

  @ApiModelProperty("状态：0-未知")
  private Integer status;

  @ApiModelProperty("关闭时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date closeTime;

  @ApiModelProperty("进件时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date entryTime;

  @ApiModelProperty("导入数据标志 0-否 1-是")
  private Byte importFlag;

  @ApiModelProperty("导入数据的自有编号")
  private String importNo;

  @ApiModelProperty("资金类型：0-正常融资 1-自有资金 2-临时垫资")
  private Byte fundType;

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

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public String getProcessInstanceId() {
    return processInstanceId;
  }

  public void setProcessInstanceId(String processInstanceId) {
    this.processInstanceId = processInstanceId;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getCloseTime() {
    return closeTime;
  }

  public void setCloseTime(Date closeTime) {
    this.closeTime = closeTime;
  }

  public Date getEntryTime() {
    return entryTime;
  }

  public void setEntryTime(Date entryTime) {
    this.entryTime = entryTime;
  }

  public Byte getImportFlag() {
    return importFlag;
  }

  public void setImportFlag(Byte importFlag) {
    this.importFlag = importFlag;
  }

  public String getImportNo() {
    return importNo;
  }

  public void setImportNo(String importNo) {
    this.importNo = importNo;
  }

  public Byte getFundType() {
    return fundType;
  }

  public void setFundType(Byte fundType) {
    this.fundType = fundType;
  }
}
