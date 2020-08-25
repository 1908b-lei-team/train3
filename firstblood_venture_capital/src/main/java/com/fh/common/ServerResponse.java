package com.fh.common;

public class ServerResponse {

    private Integer code;

    private String msg;

    private Object data;


    /**
     * 成功返回信息
     *
     * @param data
     * @return
     */
    public static ServerResponse successMethod(Object data) {
        return new ServerResponse(ServerEnum.SUCCESS.getCode(), ServerEnum.SUCCESS.getMsg(), data);
    }

    public static ServerResponse successMethod() {
        return new ServerResponse(ServerEnum.SUCCESS.getCode(), ServerEnum.SUCCESS.getMsg());
    }

    /**
     * 失败返回信息
     *
     * @return
     */
    public static ServerResponse errorMethod() {
        return new ServerResponse(ServerEnum.ERROR.getCode(), ServerEnum.ERROR.getMsg());
    }

    public static ServerResponse errorMethod(Object data) {
        return new ServerResponse(ServerEnum.ERROR.getCode(), ServerEnum.ERROR.getMsg(), data);
    }


    /**
     * 登录失败跳转的页面
     *
     * @param data
     * @return
     */
    public static ServerResponse loginErrorMethod(Object data) {
        return new ServerResponse(ServerEnum.LOGINERROR.getCode(), ServerEnum.LOGINERROR.getMsg(), data);
    }

    public static ServerResponse loginErrorMethod() {
        return new ServerResponse(ServerEnum.LOGINERROR.getCode(), ServerEnum.LOGINERROR.getMsg());
    }


    public ServerResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServerResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ServerResponse() {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
