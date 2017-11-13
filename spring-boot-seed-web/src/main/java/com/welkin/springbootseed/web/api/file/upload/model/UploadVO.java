package com.welkin.springbootseed.web.api.file.upload.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UploadVO implements Serializable {

  /** 域名 */
  @ApiModelProperty(value = "域名前缀")
  private String domain;

  /** 路径 */
  @ApiModelProperty(value = "相对路径")
  private String path;

  /** 可用url */
  @ApiModelProperty(value = "可用url")
  private String url;

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
