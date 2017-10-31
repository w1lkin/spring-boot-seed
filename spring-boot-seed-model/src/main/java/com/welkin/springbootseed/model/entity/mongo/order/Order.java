package com.welkin.springbootseed.model.entity.mongo.order;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Order<br>
 *
 * @author welkin
 */
@Document(collection = "growth_fund_interview_info")
public class Order {

  @Id private String id;

  /** 订单id */
  @Indexed private int orderId = 0;

  /** 是否通过 */
  private boolean passed = true;

  /** 不通过说明 */
  private String noPassedComment = "";

  /** 合同金额 */
  private double contractAmount = 0;

  /** 服务费利率 */
  private double interestRate = 0;

  /** 批核金额 */
  private double approvedAmount = 0;

  /** 开户银行 */
  private String depositBank = "";

  /** 开户支行 */
  private String depositSubbranchBank = "";

  /** 开户名 */
  private String accountName = "";

  /** 帐号 */
  private String accountNo = "";

  /** 回款方案 */
  private int returnMoneyPlan = 0;

  /** 面签照片 */
  private List<String> interviewPhotos = new ArrayList<>();

  /** 面签协议 */
  private List<String> interviewAgreements = new ArrayList<>();

  /** 面签补充材料 */
  private List<String> interviewSupplementaryMaterials = new ArrayList<>();

  /** 添加时间 */
  private Date createTime = new Date();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
