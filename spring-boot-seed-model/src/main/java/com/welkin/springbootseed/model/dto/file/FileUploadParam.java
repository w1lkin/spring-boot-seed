package com.welkin.springbootseed.model.dto.file;

import java.io.Serializable;

/** Created by zengzonghou on 09/10/2017. */
public class FileUploadParam implements Serializable {
  private static final long serialVersionUID = -17987775994110158L;

  /** 文件名 */
  private String fileName;

  /** 数据 */
  private byte[] data;

  public FileUploadParam() {}

    public FileUploadParam(String fileName, byte[] data) {
        this.fileName = fileName;
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }
}
