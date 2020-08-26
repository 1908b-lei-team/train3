package com.fh.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import java.math.BigDecimal;
import java.util.Date;

@TableName("t_pay")
public class Pay {
    @TableId(type = IdType.INPUT)
    private Integer id;   //项目id
    @TableField("number")
    private String number;    //编号
    @TableField("user_id")
    private Integer userId;//用户id


/*    @TableField("sign_id")
    private Integer signid;   //标id*/

    @TableField("project_name")
    private String projectName;//项目名称

    @TableField("user_name")
    private String name;   //借款人

    @TableField("credit_card_numbers")
    private String banknumber; //银行卡号

    @TableField("bank_phone")
    private String phone; //手机号

    @TableField("pay_money")
    private BigDecimal paymoney;//充值金额

    @TableField("user_balance")
    private BigDecimal balance;//当前可用余额

    @TableField("general_assets")
    private BigDecimal generalassets;//账户余额

    @TableField("deal_password")
    private  String  dealpassword;//交易密码

    @TableField("borrow_money")
    private BigDecimal borrowMoney;   //借款金额

    @TableField("loan_amount")
    private BigDecimal loanamount;  //出借金额

    @TableField(exist = false)
    private  Double rateschedule;//满标进度

    @TableField("annual_rate")
    private Double annualRate;//年利率

    @TableField("deadline")
    private String deadline;//期限

    @TableField("start_Time")
    private Date startTime;//放款时间

    @TableField("sign_give_status")
    private String signGiveStatus;//借钱状态  借款中，待放款，还款中，已完成，流标

    @TableField("loan_time")
    private Date loanTime;//loan_time 发起时间

    @TableField("join_the")
    private Integer joinThe;//加入人次


/*    public Integer getSignid() {
        return signid;
    }

    public void setSignid(Integer signid) {
        this.signid = signid;
    }*/

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(BigDecimal borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public BigDecimal getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(BigDecimal loanamount) {
        this.loanamount = loanamount;
    }

    public BigDecimal getGeneralassets() {
        return generalassets;
    }

    public void setGeneralassets(BigDecimal generalassets) {
        this.generalassets = generalassets;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(BigDecimal paymoney) {
        this.paymoney = paymoney;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDealpassword() {
        return dealpassword;
    }

    public void setDealpassword(String dealpassword) {
        this.dealpassword = dealpassword;
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

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public Integer getJoinThe() {
        return joinThe;
    }

    public void setJoinThe(Integer joinThe) {
        this.joinThe = joinThe;
    }

    public Double getRateschedule() {
        return rateschedule;
    }

    public void setRateschedule(Double rateschedule) {
        this.rateschedule = rateschedule;
    }
}
