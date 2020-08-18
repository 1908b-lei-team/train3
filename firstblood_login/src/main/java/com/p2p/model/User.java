package com.p2p.model;

public class User {

    private int id;

    private String userphone;

    private String userpwd;//

    private String usersex;//

    private String userage;//

    private String usereducation;//

    private String usermarriage;//

    private String foundtime;//`` datetime DEFAULT NULL COMMENT '注册时间',

    private String logintime;//   login_time` datetime DEFAULT NULL COMMENT '最后登录时间',

    private String userworktime;//`` varchar(255) DEFAULT NULL COMMENT '工作时间',

    private String userhouse;//` varchar(255) DEFAULT NULL COMMENT '房产',

    private String userincome;//` varchar(255) DEFAULT NULL COMMENT '房产',

    private String userproperty;//` varchar(255) DEFAULT NULL COMMENT '房产',

    private String uservehicle;//` varchar(255) DEFAULT NULL COMMENT '房产',

    private String idnumber;//` varchar(255) DEFAULT NULL COMMENT '身份证号码',

    private String userstatus;//` varchar(255) DEFAULT NULL COMMENT '是否绑定',

    private String logincount;//` int(11) DEFAULT NULL COMMENT '登录次数',

    private String loginstatus;//` varchar(255) DEFAULT NULL COMMENT '是否锁定',

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

    public String getFoundtime() {
        return foundtime;
    }

    public void setFoundtime(String foundtime) {
        this.foundtime = foundtime;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
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

    public String getLogincount() {
        return logincount;
    }

    public void setLogincount(String logincount) {
        this.logincount = logincount;
    }

    public String getLoginstatus() {
        return loginstatus;
    }

    public void setLoginstatus(String loginstatus) {
        this.loginstatus = loginstatus;
    }
}
