package com.welkin.springbootseed.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Base implements Serializable {

    public static Date DEFAULT_DATE;

    static {
        try {
            DEFAULT_DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2000-01-01 00:00:00");
        } catch (ParseException e) {
        }
    }

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Date sysTime;

    private Long createUserid;

    private Long updateUserid;

    private Long deleteUserid;

    private String createUsername;

    private String updateUsername;

    private String deleteUsername;

    private Long ownerId;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public String getUpdateUsername() {
        return updateUsername;
    }

    public void setUpdateUsername(String updateUsername) {
        this.updateUsername = updateUsername;
    }

    public String getDeleteUsername() {
        return deleteUsername;
    }

    public void setDeleteUsername(String deleteUsername) {
        this.deleteUsername = deleteUsername;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
    }

    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Long getDeleteUserid() {
        return deleteUserid;
    }

    public void setDeleteUserid(Long deleteUserid) {
        this.deleteUserid = deleteUserid;
    }

    public Date getSysTime() {
        return sysTime;
    }

    public void setSysTime(Date sysTime) {
        this.sysTime = sysTime;
    }
}
