package com.fh.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@TableName("t_control1")
public class Control {

    @TableId(type = IdType.INPUT)
    private Integer id;
    @TableField("number")
    private String number;    //编号
    @TableField("loanName")
    private String loanName; //贷款人
    @TableField("userId")
    private Integer userId;   //用户id
    @TableField("product")
    private String product;   //产品
    @TableField("borrowMoney")
    private Double borrowMoney;   //借款金额
    @TableField("isQuota")
    private String isQuota;   //单人限额
    @TableField("annualRate")
    private Double annualRate;//年利率
    @TableField("deadline")
    private String deadline;//期限

    @TableField("repaymentType")
    private String repaymentType;//还款方式

    @TableField("projectName")
    private String projectName;//项目名称

    @TableField("borrowExplain")
    private String borrowExplain;//借款说明

    @TableField("total")
    private Double total;//本息合计

    @TableField("interest")
    private Double interest;//利息金额

    @TableField("status")
    private String status;//审核状态

    @TableField("rateSchedule")
    private Double rateSchedule;//满标进度

    @TableField("oneLimit")
    private String oneLimit;//单人限额百分比

    @TableField("startTime")
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    private Date startTime;//发售时间

    @TableField("signGiveStatus")
    private String signGiveStatus;//借钱状态  借款中，待放款，还款中，已完成，流标

    @TableField("borrDays")
    private Integer borrDays;//筹款天数

    @TableField("suggest")
    private String suggest;//风控建议

    @TableField("isSign")
    private Integer isSign;//是否签约

    @TableField("loanTime")
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    private Date loanTime;//loan_time


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(Double borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public String getIsQuota() {
        return isQuota;
    }

    public void setIsQuota(String isQuota) {
        this.isQuota = isQuota;
    }

    public Double getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(Double annualRate) {
        this.annualRate = annualRate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBorrowExplain() {
        return borrowExplain;
    }

    public void setBorrowExplain(String borrowExplain) {
        this.borrowExplain = borrowExplain;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getRateSchedule() {
        return rateSchedule;
    }

    public void setRateSchedule(Double rateSchedule) {
        this.rateSchedule = rateSchedule;
    }

    public String getOneLimit() {
        return oneLimit;
    }

    public void setOneLimit(String oneLimit) {
        this.oneLimit = oneLimit;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getSignGiveStatus() {
        return signGiveStatus;
    }

    public void setSignGiveStatus(String signGiveStatus) {
        this.signGiveStatus = signGiveStatus;
    }

    public Integer getBorrDays() {
        return borrDays;
    }

    public void setBorrDays(Integer borrDays) {
        this.borrDays = borrDays;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public Integer getIsSign() {
        return isSign;
    }

    public void setIsSign(Integer isSign) {
        this.isSign = isSign;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }
}
