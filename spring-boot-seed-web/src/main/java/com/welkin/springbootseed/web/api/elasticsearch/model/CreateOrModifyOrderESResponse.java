package com.welkin.springbootseed.web.api.elasticsearch.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CreateOrModifyOrderESResponse implements Serializable{
    @ApiModelProperty("orderId")
    private Integer orderId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
