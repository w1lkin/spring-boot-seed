package com.welkin.springbootseed.model.dto.file;

import java.io.Serializable;

/**
 * Created by zengzonghou on 22/09/2017.
 */
public class UploadDTO implements Serializable{
    private static final long serialVersionUID = 891136188288416171L;
    /**
     * 域名
     */
    private String domain;

    /**
     * 路径
     */
    private String path;

    public UploadDTO(){

    }

    public UploadDTO(String domain,String path){
        this.domain = domain;
        this.path = path;
    }


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
}
