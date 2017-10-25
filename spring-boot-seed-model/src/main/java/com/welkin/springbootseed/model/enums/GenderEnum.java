package com.welkin.springbootseed.model.enums;

/**
 * GenderEnum
 * @author welkin
 */
public enum GenderEnum {
    DEFAULT(0,"未知"),
    MALE(1,"男"),
    FEMALE(2,"女")
    ;

    public  static GenderEnum valueOf(int itemId){
        for(GenderEnum item : values()){
            if(item.getCode()==itemId){
                return item;
            }
        }
        return null;
    }

    GenderEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int code;
    private String name;
}
