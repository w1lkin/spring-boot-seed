package com.welkin.springbootseed.web.api.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Order<br>
 *
 * @author welkin
 */
public class OrderESVo {

  @ApiModelProperty("id")
  private String id;

  @ApiModelProperty("订单id")
  private Integer orderId;

  @ApiModelProperty("城市id")
  private Integer cityId;

  @ApiModelProperty("城市名")
  private String cityName;

  @ApiModelProperty("订单中心编号")
  private Long orderCenterNo;

  @ApiModelProperty("客户id")
  private Integer customerId;

  @ApiModelProperty("产品id ")
  private Integer productId;

  @ApiModelProperty("流程实例id")
  private String processInstanceId;

  @ApiModelProperty("订单阶段")
  private Integer phase ;

  @ApiModelProperty("订单阶段")
  private String phaseName ;

  @ApiModelProperty("订单状态")
  private Integer status ;

  @ApiModelProperty("订单状态")
  private String statusName ;

  @ApiModelProperty("订单是否删除：0未删除 1已删除")
  private Integer isOrderDeleted;

  @ApiModelProperty("订单创建时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date orderCreateTime;

  @ApiModelProperty("订单更新时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date orderUpdateTime;

  @ApiModelProperty("订单删除时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date orderDeleteTime;

  @ApiModelProperty("客户姓名")
  private String customerName;

  @ApiModelProperty("客户联系电话")
  private String customerPhone;

  @ApiModelProperty("客户类型：0个人 1公司")
  private Integer customerType;

  @ApiModelProperty("个人id")
  private Integer personId;

  @ApiModelProperty("公司id")
  private Integer companyId;

  @ApiModelProperty("客户状态（1-失效 2-生效）")
  private Integer customerStatus;

  @ApiModelProperty("客户是否删除(0-未删除 1-已删除)")
  private Integer customerIsDeleted;

  @ApiModelProperty("母公司id")
  private Integer companyPid;

  @ApiModelProperty("公司所在城市id")
  private Integer companyCityId;

  @ApiModelProperty("公司所在城市名")
  private String companyCityName;

  @ApiModelProperty("公司名")
  private String companyName;

  @ApiModelProperty("公司联系电话")
  private String companyPhone;

  @ApiModelProperty("公司法人")
  private String companyLegalPerson;

  @ApiModelProperty("公司地址")
  private String companyAddress;

  @ApiModelProperty("公司是否删除：0未删除 1已删除")
  private Integer isCompanyDeleted;

  @ApiModelProperty("资方id")
  private Integer capitalId;

  @ApiModelProperty("资方名")
  private String capitalName;

  @ApiModelProperty("资方电话")
  private String capitalPhone;

  @ApiModelProperty("资方地址")
  private String capitalAddress;

  @ApiModelProperty("资方联系人")
  private String capitalLinkman;

  @ApiModelProperty("经纪公司id")
  private Integer brokerCompanyId;

  @ApiModelProperty("经纪公司名")
  private String brokerCompanyName;

  @ApiModelProperty("关闭时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date closeTime;

  @ApiModelProperty("操作时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date operateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
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

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getIsOrderDeleted() {
        return isOrderDeleted;
    }

    public void setIsOrderDeleted(Integer isOrderDeleted) {
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

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
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

    public Integer getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Integer getCustomerIsDeleted() {
        return customerIsDeleted;
    }

    public void setCustomerIsDeleted(Integer customerIsDeleted) {
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

    public Integer getIsCompanyDeleted() {
        return isCompanyDeleted;
    }

    public void setIsCompanyDeleted(Integer isCompanyDeleted) {
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
