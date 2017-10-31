package com.welkin.springbootseed.web.api.redis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class CreateOrModifyOrderRedisRequest implements Serializable {
  @ApiModelProperty("id")
  private Integer id;

  @ApiModelProperty("城市ID")
  @NotNull(message = "城市ID 不能为空")
  private Integer cityId;

  @ApiModelProperty("进件时间")
  @NotNull(message = "进件时间 不能为空")
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date entryTime;

  @ApiModelProperty("资金类型：0-正常融资 1-自有资金 2-临时垫资")
  @NotNull(message = "资金类型 不能为空")
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

  public Date getEntryTime() {
    return entryTime;
  }

  public void setEntryTime(Date entryTime) {
    this.entryTime = entryTime;
  }

  public Byte getFundType() {
    return fundType;
  }

  public void setFundType(Byte fundType) {
    this.fundType = fundType;
  }
}
