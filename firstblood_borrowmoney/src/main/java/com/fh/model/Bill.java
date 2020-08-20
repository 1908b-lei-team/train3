package com.fh.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@TableName("t_p2p_bill")
public class Bill {
    @TableId(type = IdType.INPUT)
    private Integer id;
    @TableField("bill_num")
    private String billNum;//账单编号
    @TableField("periods_num")
    private String periodsNum;//期数
    @TableField("prin_and_interest")
    private Double prinAndInterest;//本息
    @TableField("prin")
    private Double prin;//本金
    @TableField("interest")
    private Double interest;//利息
    @TableField("expire_time")
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expireTime;//每月还款时间
    @TableField("true_time")
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    private Date trueTime;//真正还款时间
    @TableField("status")
    private String status;//还款状态
    @TableField("sign_id")
    private Integer signId;//标id
    @TableField("user_id")
    private Integer userId;//借款人id


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getPeriodsNum() {
        return periodsNum;
    }

    public void setPeriodsNum(String periodsNum) {
        this.periodsNum = periodsNum;
    }

    public Double getPrinAndInterest() {
        return prinAndInterest;
    }

    public void setPrinAndInterest(Double prinAndInterest) {
        this.prinAndInterest = prinAndInterest;
    }

    public Double getPrin() {
        return prin;
    }

    public void setPrin(Double prin) {
        this.prin = prin;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getTrueTime() {
        return trueTime;
    }

    public void setTrueTime(Date trueTime) {
        this.trueTime = trueTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSignId() {
        return signId;
    }

    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
