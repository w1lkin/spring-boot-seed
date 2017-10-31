package com.welkin.springbootseed.model.entity.elasticsearch.order;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Order<br>
 *
 * @author welkin
 */
@Document(
  indexName = "elasticsearch_order_index",
  type = "growth.fund.order",
  refreshInterval = "-1"
)
public class Order {

  @Id private String id;

  /** 订单id */
  private int orderId;

  /** 城市id */
  private Integer cityId;

  /** 城市名 */
  private String cityName;

  /** 订单中心编号 */
  private Long orderCenterNo;

  /** 客户id */
  private Integer customerId;

  /** 产品id */
  private Integer productId;

  /** 流程实例id */
  private String processInstanceId;

  /** 订单阶段 */
  private int phase = 0;

  /** 订单阶段 */
  private String phaseName = "";

  /** 订单状态 */
  private int status = 0;

  /** 订单状态 */
  private String statusName = "";

  /** 订单是否删除：0未删除 1已删除 */
  private int isOrderDeleted;

  /** 订单创建时间 */
  private Date orderCreateTime;

  /** 订单更新时间 */
  private Date orderUpdateTime;

  /** 订单删除时间 */
  private Date orderDeleteTime;

  /** 客户姓名 */
  private String customerName;

  /** 客户联系电话 */
  private String customerPhone;

  /** 客户类型：0个人 1公司 */
  private int customerType;

  /** 个人id */
  private Integer personId;

  /** 公司id */
  private Integer companyId;

  /** 客户状态（1-失效 2-生效） */
  private int customerStatus;

  /** 客户是否删除(0-未删除 1-已删除) */
  private int customerIsDeleted;

  /** 母公司id */
  private Integer companyPid;

  /** 公司所在城市id */
  private Integer companyCityId;

  /** 公司所在城市名 */
  private String companyCityName;

  /** 公司名 */
  private String companyName;

  /** 公司联系电话 */
  private String companyPhone;

  /** 公司法人 */
  private String companyLegalPerson;

  /** 公司地址 */
  private String companyAddress;

  /** 公司是否删除：0未删除 1已删除 */
  private int isCompanyDeleted;

  /** 资方id */
  private Integer capitalId;

  /** 资方名 */
  private String capitalName;

  /** 资方电话 */
  private String capitalPhone;

  /** 资方地址 */
  private String capitalAddress;

  /** 资方联系人 */
  private String capitalLinkman;

  /** 经纪公司id */
  private Integer brokerCompanyId;

  /** 经纪公司名 */
  private String brokerCompanyName;

  /** 关闭时间 */
  private Date closeTime;

  /** 操作时间 */
  private Date operateTime;

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

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public Long getOrderCenterNo() {
    return orderCenterNo;
  }

  public void setOrderCenterNo(Long orderCenterNo) {
    this.orderCenterNo = orderCenterNo;
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

  public int getPhase() {
    return phase;
  }

  public void setPhase(int phase) {
    this.phase = phase;
  }

  public String getPhaseName() {
    return phaseName;
  }

  public void setPhaseName(String phaseName) {
    this.phaseName = phaseName;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }

  public int getIsOrderDeleted() {
    return isOrderDeleted;
  }

  public void setIsOrderDeleted(int isOrderDeleted) {
    this.isOrderDeleted = isOrderDeleted;
  }

  public Date getOrderCreateTime() {
    return orderCreateTime;
  }

  public void setOrderCreateTime(Date orderCreateTime) {
    this.orderCreateTime = orderCreateTime;
  }

  public Date getOrderUpdateTime() {
    return orderUpdateTime;
  }

  public void setOrderUpdateTime(Date orderUpdateTime) {
    this.orderUpdateTime = orderUpdateTime;
  }

  public Date getOrderDeleteTime() {
    return orderDeleteTime;
  }

  public void setOrderDeleteTime(Date orderDeleteTime) {
    this.orderDeleteTime = orderDeleteTime;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerPhone() {
    return customerPhone;
  }

  public void setCustomerPhone(String customerPhone) {
    this.customerPhone = customerPhone;
  }

  public int getCustomerType() {
    return customerType;
  }

  public void setCustomerType(int customerType) {
    this.customerType = customerType;
  }

  public Integer getPersonId() {
    return personId;
  }

  public void setPersonId(Integer personId) {
    this.personId = personId;
  }

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }

  public int getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(int customerStatus) {
    this.customerStatus = customerStatus;
  }

  public int getCustomerIsDeleted() {
    return customerIsDeleted;
  }

  public void setCustomerIsDeleted(int customerIsDeleted) {
    this.customerIsDeleted = customerIsDeleted;
  }

  public Integer getCompanyPid() {
    return companyPid;
  }

  public void setCompanyPid(Integer companyPid) {
    this.companyPid = companyPid;
  }

  public Integer getCompanyCityId() {
    return companyCityId;
  }

  public void setCompanyCityId(Integer companyCityId) {
    this.companyCityId = companyCityId;
  }

  public String getCompanyCityName() {
    return companyCityName;
  }

  public void setCompanyCityName(String companyCityName) {
    this.companyCityName = companyCityName;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getCompanyPhone() {
    return companyPhone;
  }

  public void setCompanyPhone(String companyPhone) {
    this.companyPhone = companyPhone;
  }

  public String getCompanyLegalPerson() {
    return companyLegalPerson;
  }

  public void setCompanyLegalPerson(String companyLegalPerson) {
    this.companyLegalPerson = companyLegalPerson;
  }

  public String getCompanyAddress() {
    return companyAddress;
  }

  public void setCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress;
  }

  public int getIsCompanyDeleted() {
    return isCompanyDeleted;
  }

  public void setIsCompanyDeleted(int isCompanyDeleted) {
    this.isCompanyDeleted = isCompanyDeleted;
  }

  public Integer getCapitalId() {
    return capitalId;
  }

  public void setCapitalId(Integer capitalId) {
    this.capitalId = capitalId;
  }

  public String getCapitalName() {
    return capitalName;
  }

  public void setCapitalName(String capitalName) {
    this.capitalName = capitalName;
  }

  public String getCapitalPhone() {
    return capitalPhone;
  }

  public void setCapitalPhone(String capitalPhone) {
    this.capitalPhone = capitalPhone;
  }

  public String getCapitalAddress() {
    return capitalAddress;
  }

  public void setCapitalAddress(String capitalAddress) {
    this.capitalAddress = capitalAddress;
  }

  public String getCapitalLinkman() {
    return capitalLinkman;
  }

  public void setCapitalLinkman(String capitalLinkman) {
    this.capitalLinkman = capitalLinkman;
  }

  public Integer getBrokerCompanyId() {
    return brokerCompanyId;
  }

  public void setBrokerCompanyId(Integer brokerCompanyId) {
    this.brokerCompanyId = brokerCompanyId;
  }

  public String getBrokerCompanyName() {
    return brokerCompanyName;
  }

  public void setBrokerCompanyName(String brokerCompanyName) {
    this.brokerCompanyName = brokerCompanyName;
  }

  public Date getCloseTime() {
    return closeTime;
  }

  public void setCloseTime(Date closeTime) {
    this.closeTime = closeTime;
  }

  public Date getOperateTime() {
    return operateTime;
  }

  public void setOperateTime(Date operateTime) {
    this.operateTime = operateTime;
  }
}
