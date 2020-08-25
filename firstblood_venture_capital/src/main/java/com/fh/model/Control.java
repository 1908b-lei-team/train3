package com.fh.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@TableName("t_control")
public class Control {
    @TableId(type = IdType.INPUT)
    @TableField("id")
    private Integer id;
    @TableField("number")
    private String number;    //编号
    @TableField("user_id")
    private Integer userId;   //用户id
    @TableField("product")
    private String product;   //产品
    @TableField("is_show_mark")
    private String isShowMark;   //是否显示标的
    @TableField("mark_type")
    private String markType;   //标类型
    @TableField("borrow_money")
    private Double borrowMoney;   //借款金额
    @TableField("is_quota")
    private String isQuota;   //单人限额
    @TableField("annual_rate")
    private Double annualRate;//年利率
    @TableField("deadline")
    private String deadline;//期限
    @TableField("repayment_type")
    private String repaymentType;//还款方式
    @TableField("project_name")
    private String projectName;//项目名称
    @TableField("borrow_explain")
    private String borrowExplain;//借款说明
    @TableField("total")
    private Double total;//本息合计
    @TableField("interest")
    private Double interest;//利息金额
    @TableField("status")
    private String status;//审核状态
    @TableField("rate_schedule")
    private Double rateSchedule;//满标进度
    @TableField("one_limit")
    private String oneLimit;//单人限额百分比
    @TableField("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;//发售时间
    @TableField("sign_give_status")
    private String signGiveStatus;//借钱状态  借款中，待放款，还款中，已完成，流标
    @TableField("borr_days")
    private Integer borrDays;//筹款天数
    @TableField("ahead_post_money")
    private Double aheadPostMoney;//提前还款违约金
    @TableField("load_post_money")
    private Double loadPostMoney;//逾期还款违约金
    @TableField("service_charge")
    private Double serviceCharge;//借款存续期手续费
    @TableField("suggest")
    private String suggest;//风控建议
    @TableField("contract")
    private String contract;//合同
    @TableField("join_the")
    private Integer joinThe;//加入人次
    @TableField("at_most")
    private BigDecimal atMost;//最多可投
    @TableField("is_sign")
    private Integer isSign;//是否签约
    @TableField("loan_time")
    private Date loanTime;//loan_time
    @TableField("fundraising_progress")
    private String  fundraisingProgress; //筹款君度

    @TableField("review_time")
    private String  reviewTime; //审批时间


    public String getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getFundraisingProgress() {
        return fundraisingProgress;
    }

    public void setFundraisingProgress(String fundraisingProgress) {
        this.fundraisingProgress = fundraisingProgress;
    }

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

    public String getIsShowMark() {
        return isShowMark;
    }

    public void setIsShowMark(String isShowMark) {
        this.isShowMark = isShowMark;
    }

    public String getMarkType() {
        return markType;
    }

    public void setMarkType(String markType) {
        this.markType = markType;
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

    public Double getAheadPostMoney() {
        return aheadPostMoney;
    }

    public void setAheadPostMoney(Double aheadPostMoney) {
        this.aheadPostMoney = aheadPostMoney;
    }

    public Double getLoadPostMoney() {
        return loadPostMoney;
    }

    public void setLoadPostMoney(Double loadPostMoney) {
        this.loadPostMoney = loadPostMoney;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Integer getJoinThe() {
        return joinThe;
    }

    public void setJoinThe(Integer joinThe) {
        this.joinThe = joinThe;
    }

    public BigDecimal getAtMost() {
        return atMost;
    }

    public void setAtMost(BigDecimal atMost) {
        this.atMost = atMost;
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
