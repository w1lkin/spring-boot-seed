package com.welkin.springbootseed.model.entity.mysql.order;

import com.welkin.springbootseed.model.Base;

import java.io.Serializable;
import java.util.Date;

/** @author welkin Order */
public class Order extends Base implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer id;
  /** 城市ID */
  private Integer cityId;
  /** 订单中心编号 */
  private Long orderCenterNo;
  /** 订单编号 */
  private String orderNo;
  /** tfs_customer.id */
  private Integer customerId;
  /** tfs_product.id */
  private Integer productId;
  /** 流程实例id */
  private String processInstanceId;
  /** 状态：0-未知 */
  private Integer status;
  /** 关闭时间 */
  private Date closeTime;
  /** 进件时间 */
  private Date entryTime;
  /** 导入数据标志 0-否 1-是 */
  private Byte importFlag;
  /** 导入数据的自有编号 */
  private String importNo;
  /** 资金类型：0-正常融资 1-自有资金 2-临时垫资 */
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
