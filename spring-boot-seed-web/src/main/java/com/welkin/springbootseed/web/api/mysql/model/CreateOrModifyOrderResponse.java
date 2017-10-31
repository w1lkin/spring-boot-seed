package com.welkin.springbootseed.web.api.mysql.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CreateOrModifyOrderResponse implements Serializable {
  @ApiModelProperty("id")
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
