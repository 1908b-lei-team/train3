package com.fh.common;

public enum ServerEnum {

    SUCCESS(1000, "操作成功"),
    ERROR(2000, "操作失败"),
    LOGINERROR(500, "登录失败"),
    ;

    private Integer code;

    private String msg;

    ServerEnum() {
    }

    ServerEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
