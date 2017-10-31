package com.welkin.springbootseed.web.api.redis.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CreateOrModifyOrderRedisResponse implements Serializable {
  @ApiModelProperty("id")
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
