package com.welkin.springbootseed.web.api.stream.model;

import com.welkin.springbootseed.model.order.Order;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamResponse implements Serializable {
    @ApiModelProperty("orderIdsList")
    List<Integer> orderIdsList=new ArrayList<>();

    @ApiModelProperty("orderMap")
    Map<Integer,Order> orderMap=new HashMap<>();

    @ApiModelProperty("orderIdsArray")
    Integer[] orderIdsArray;

    @ApiModelProperty("orderIdsString")
    String orderIdsString;

    @ApiModelProperty("orderIdsString2")
    String orderIdsString2;

    @ApiModelProperty("amount")
    Long amount;

    @ApiModelProperty("amount2")
    Long amount2;

    @ApiModelProperty("amount3")
    Long amount3;

    @ApiModelProperty("amount4")
    Long amount4;

    public List<Integer> getOrderIdsList() {
        return orderIdsList;
    }

    public void setOrderIdsList(List<Integer> orderIdsList) {
        this.orderIdsList = orderIdsList;
    }

    public Map<Integer, Order> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<Integer, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public Integer[] getOrderIdsArray() {
        return orderIdsArray;
    }

    public void setOrderIdsArray(Integer[] orderIdsArray) {
        this.orderIdsArray = orderIdsArray;
    }

    public String getOrderIdsString() {
        return orderIdsString;
    }

    public void setOrderIdsString(String orderIdsString) {
        this.orderIdsString = orderIdsString;
    }

    public String getOrderIdsString2() {
        return orderIdsString2;
    }

    public void setOrderIdsString2(String orderIdsString2) {
        this.orderIdsString2 = orderIdsString2;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount2() {
        return amount2;
    }

    public void setAmount2(Long amount2) {
        this.amount2 = amount2;
    }

    public Long getAmount3() {
        return amount3;
    }

    public void setAmount3(Long amount3) {
        this.amount3 = amount3;
    }

    public Long getAmount4() {
        return amount4;
    }

    public void setAmount4(Long amount4) {
        this.amount4 = amount4;
    }
}
