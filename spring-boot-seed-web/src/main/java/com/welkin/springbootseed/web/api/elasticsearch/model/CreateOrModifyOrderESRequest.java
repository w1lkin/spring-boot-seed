package com.welkin.springbootseed.web.api.elasticsearch.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CreateOrModifyOrderESRequest implements Serializable{
    @ApiModelProperty("订单id")
    private Integer orderId;

    @ApiModelProperty("城市id")
    private Integer cityId;

    @ApiModelProperty("城市名")
    private String cityName;

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
}
