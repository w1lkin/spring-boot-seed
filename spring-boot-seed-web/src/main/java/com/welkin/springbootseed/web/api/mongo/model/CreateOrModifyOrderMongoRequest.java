package com.welkin.springbootseed.web.api.mongo.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import java.io.Serializable;

public class CreateOrModifyOrderMongoRequest implements Serializable {
  @ApiModelProperty("订单id")
  private Integer orderId = 0;

  @ApiModelProperty("是否通过")
  private Boolean passed;

  @ApiModelProperty("不通过说明")
  private String noPassedComment;

  @ApiModelProperty("合同金额")
  @Min(value = 0, message = "合同金额不能小于0")
  private Double contractAmount;

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Boolean getPassed() {
    return passed;
  }

  public void setPassed(Boolean passed) {
    this.passed = passed;
  }

  public String getNoPassedComment() {
    return noPassedComment;
  }

  public void setNoPassedComment(String noPassedComment) {
    this.noPassedComment = noPassedComment;
  }

  public Double getContractAmount() {
    return contractAmount;
  }

  public void setContractAmount(Double contractAmount) {
    this.contractAmount = contractAmount;
  }
}
