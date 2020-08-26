package com.fh.common.model;


import java.util.Date;

public class User {

    private int id;

    private String userphone;//手机号

    private String userpwd;//密码

    private String usersex;//性别

    private String userage;//年龄

    private String usereducation;//学历

    private String usermarriage;//婚姻

    private Date foundtime;//`` datetime DEFAULT NULL COMMENT '注册时间',

    private Date logintime;//   login_time` datetime DEFAULT NULL COMMENT '最后登录时间',

    private String userworktime;//`` varchar(255) DEFAULT NULL COMMENT '工作时间',

    private String userhouse;//` varchar(255) DEFAULT NULL COMMENT '房产',

    private String userincome;//` varchar(255) DEFAULT NULL COMMENT  '年收入',

    private String userproperty;//` varchar(255) DEFAULT NULL COMMENT  '总资产',

    private String uservehicle;//` varchar(255) DEFAULT NULL COMMENT  '车产',

    private int logincount;//` int(11) DEFAULT NULL COMMENT '登录次数',

    private String loginstatus;//` varchar(255) DEFAULT NULL COMMENT '是否锁定',

    private String username;//` varchar(255) DEFAULT NULL COMMENT '用户名',

    private String idnumber;//` varchar(255) DEFAULT NULL COMMENT '身份证号码',

    private String userstatus;//` varchar(255) DEFAULT NULL COMMENT '是否绑定',

    private String userrole;//` varchar(255) DEFAULT NULL COMMENT '',

    private String pwdsaly;//` varchar(255) DEFAULT NULL COMMENT '',

    private Date updatetime;//` varchar(255) DEFAULT NULL COMMENT '修改时间',

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getPwdsaly() {
        return pwdsaly;
    }

    public void setPwdsaly(String pwdsaly) {
        this.pwdsaly = pwdsaly;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    public String getUsereducation() {
        return usereducation;
    }

    public void setUsereducation(String usereducation) {
        this.usereducation = usereducation;
    }

    public String getUsermarriage() {
        return usermarriage;
    }

    public void setUsermarriage(String usermarriage) {
        this.usermarriage = usermarriage;
    }

    public Date getFoundtime() {
        return foundtime;
    }

    public void setFoundtime(Date foundtime) {
        this.foundtime = foundtime;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getUserworktime() {
        return userworktime;
    }

    public void setUserworktime(String userworktime) {
        this.userworktime = userworktime;
    }

    public String getUserhouse() {
        return userhouse;
    }

    public void setUserhouse(String userhouse) {
        this.userhouse = userhouse;
    }

    public String getUserincome() {
        return userincome;
    }

    public void setUserincome(String userincome) {
        this.userincome = userincome;
    }

    public String getUserproperty() {
        return userproperty;
    }

    public void setUserproperty(String userproperty) {
        this.userproperty = userproperty;
    }

    public String getUservehicle() {
        return uservehicle;
    }

    public void setUservehicle(String uservehicle) {
        this.uservehicle = uservehicle;
    }

    public int getLogincount() {
        return logincount;
    }

    public void setLogincount(int logincount) {
        this.logincount = logincount;
    }

    public String getLoginstatus() {
        return loginstatus;
    }

    public void setLoginstatus(String loginstatus) {
        this.loginstatus = loginstatus;
    }
}
