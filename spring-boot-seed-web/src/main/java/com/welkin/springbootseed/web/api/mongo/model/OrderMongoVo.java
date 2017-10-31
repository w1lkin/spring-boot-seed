package com.welkin.springbootseed.web.api.mongo.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Order<br>
 *
 * @author welkin
 */
public class OrderMongoVo {

  @ApiModelProperty("订单id")
  private Integer orderId = 0;

  @ApiModelProperty("是否通过")
  private Boolean passed;

  @ApiModelProperty("不通过说明")
  private String noPassedComment;

  @ApiModelProperty("合同金额")
  private Double contractAmount;

  @ApiModelProperty("服务费利率")
  private Double interestRate;

  @ApiModelProperty("批核金额")
  private Double approvedAmount;

  @ApiModelProperty("开户银行")
  private String depositBank;

  @ApiModelProperty("开户支行")
  private String depositSubbranchBank;

  @ApiModelProperty("开户名")
  private String accountName;

  @ApiModelProperty("帐号")
  private String accountNo;

  @ApiModelProperty("回款方案")
  private int returnMoneyPlan;

  @ApiModelProperty("面签照片")
  private List<String> interviewPhotos;

  @ApiModelProperty("面签协议")
  private List<String> interviewAgreements;

  @ApiModelProperty("面签补充材料")
  private List<String> interviewSupplementaryMaterials;

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public boolean isPassed() {
    return passed;
  }

  public void setPassed(boolean passed) {
    this.passed = passed;
  }

  public String getNoPassedComment() {
    return noPassedComment;
  }

  public void setNoPassedComment(String noPassedComment) {
    this.noPassedComment = noPassedComment;
  }

  public double getContractAmount() {
    return contractAmount;
  }

  public void setContractAmount(double contractAmount) {
    this.contractAmount = contractAmount;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  public double getApprovedAmount() {
    return approvedAmount;
  }

  public void setApprovedAmount(double approvedAmount) {
    this.approvedAmount = approvedAmount;
  }

  public String getDepositBank() {
    return depositBank;
  }

  public void setDepositBank(String depositBank) {
    this.depositBank = depositBank;
  }

  public String getDepositSubbranchBank() {
    return depositSubbranchBank;
  }

  public void setDepositSubbranchBank(String depositSubbranchBank) {
    this.depositSubbranchBank = depositSubbranchBank;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }

  public int getReturnMoneyPlan() {
    return returnMoneyPlan;
  }

  public void setReturnMoneyPlan(int returnMoneyPlan) {
    this.returnMoneyPlan = returnMoneyPlan;
  }

  public List<String> getInterviewPhotos() {
    return interviewPhotos;
  }

  public void setInterviewPhotos(List<String> interviewPhotos) {
    this.interviewPhotos = interviewPhotos;
  }

  public List<String> getInterviewAgreements() {
    return interviewAgreements;
  }

  public void setInterviewAgreements(List<String> interviewAgreements) {
    this.interviewAgreements = interviewAgreements;
  }

  public List<String> getInterviewSupplementaryMaterials() {
    return interviewSupplementaryMaterials;
  }

  public void setInterviewSupplementaryMaterials(List<String> interviewSupplementaryMaterials) {
    this.interviewSupplementaryMaterials = interviewSupplementaryMaterials;
  }
}
