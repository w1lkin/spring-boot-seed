package com.welkin.springbootseed.model.dto.file;

import java.io.Serializable;

/**
 * Created by zengzonghou on 25/09/2017.
 */
public class FileDTO implements Serializable {
    private static final long serialVersionUID = 6987982611784557882L;

    private String url;

    public FileDTO(){
    }

    public FileDTO(String url){
        this.url = url;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
