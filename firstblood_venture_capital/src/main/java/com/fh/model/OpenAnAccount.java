package com.fh.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 开户信息
 */
@TableName("t_open_an_account")
public class OpenAnAccount {

    @TableId(type = IdType.INPUT)
    private Integer id;
    @TableField("user_id")
    private Integer userId; //用户id
    @TableField("user_name")
    private String userName; //用户姓名
    @TableField("id_number")
    private String idNumber; //身份证
    @TableField("credit_card_numbers")
    private String creditCardNumbers; //银行卡号
    @TableField("account_type")
    private String accountType; //账户类型
    @TableField("bank_phone")
    private String bankPhone; //银行预留手机号
    @TableField("confirm_password")
    private String confirmPassword; //确认密码
    @TableField("bank")
    private String bank; //银行类型
    @TableField("virtual_bank_id")
    private String virtualBankId; //虚拟卡号
    @TableField("new_time")
    private String newTime; //开户时间
    @TableField("user_balance")
    private Double userBalance; //可用余额
    @TableField("general_assets")
    private Double generalAssets; //总金额
    @TableField("user_frozen_capital")
    private Double userFrozenCapital; //冻结金额
    @TableField("the_collecting_amount")
    private Double theCollectingAmount; //代收金额
    @TableField("generation_also_amount")
    private Double generationAlsoAmount; //代还金额
    @TableField("total_revenue")
    private Double totalRevenue; //总收益
    @TableField("lately_login_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date latelyLoginTime; //最近登录时间
    @TableField("login_count")
    private Integer loginCount; //登录次数
    @TableField("account_opening_status")
    private  Integer accountOpeningStatus;//开户状态
    @TableField("lockout_state")
    private  Integer lockoutStatus;//锁定状态


    public Integer getAccountOpeningStatus() {
        return accountOpeningStatus;
    }

    public void setAccountOpeningStatus(Integer accountOpeningStatus) {
        this.accountOpeningStatus = accountOpeningStatus;
    }

    public Integer getLockoutStatus() {
        return lockoutStatus;
    }

    public void setLockoutStatus(Integer lockoutStatus) {
        this.lockoutStatus = lockoutStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCreditCardNumbers() {
        return creditCardNumbers;
    }

    public void setCreditCardNumbers(String creditCardNumbers) {
        this.creditCardNumbers = creditCardNumbers;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getVirtualBankId() {
        return virtualBankId;
    }

    public void setVirtualBankId(String virtualBankId) {
        this.virtualBankId = virtualBankId;
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }

    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    public Double getGeneralAssets() {
        return generalAssets;
    }

    public void setGeneralAssets(Double generalAssets) {
        this.generalAssets = generalAssets;
    }

    public Double getUserFrozenCapital() {
        return userFrozenCapital;
    }

    public void setUserFrozenCapital(Double userFrozenCapital) {
        this.userFrozenCapital = userFrozenCapital;
    }

    public Double getTheCollectingAmount() {
        return theCollectingAmount;
    }

    public void setTheCollectingAmount(Double theCollectingAmount) {
        this.theCollectingAmount = theCollectingAmount;
    }

    public Double getGenerationAlsoAmount() {
        return generationAlsoAmount;
    }

    public void setGenerationAlsoAmount(Double generationAlsoAmount) {
        this.generationAlsoAmount = generationAlsoAmount;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Date getLatelyLoginTime() {
        return latelyLoginTime;
    }

    public void setLatelyLoginTime(Date latelyLoginTime) {
        this.latelyLoginTime = latelyLoginTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Override
    public String toString() {
        return "OpenAnAccount{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", creditCardNumbers='" + creditCardNumbers + '\'' +
                ", accountType='" + accountType + '\'' +
                ", bankPhone='" + bankPhone + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", bank='" + bank + '\'' +
                ", virtualBankId='" + virtualBankId + '\'' +
                ", newTime='" + newTime + '\'' +
                ", userBalance=" + userBalance +
                ", generalAssets=" + generalAssets +
                ", userFrozenCapital=" + userFrozenCapital +
                ", theCollectingAmount=" + theCollectingAmount +
                ", generationAlsoAmount=" + generationAlsoAmount +
                ", totalRevenue=" + totalRevenue +
                ", latelyLoginTime=" + latelyLoginTime +
                ", loginCount=" + loginCount +
                '}';
    }
}
