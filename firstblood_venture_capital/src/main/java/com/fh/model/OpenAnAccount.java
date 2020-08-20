package com.fh.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("t_open_an_account")
public class OpenAnAccount {

    private Integer id;
    private Integer userId; //用户id
    private String userName; //用户姓名
    private String idNumber; //身份证
    private String creditCardNumbers; //银行卡号
    private String accountType; //账户类型
    private String bankPhone; //银行预留手机号
    private String confirmPassword; //确认密码
    private String bank; //银行类型
    private String virtualBankId; //虚拟卡号
    private String newTime; //开户时间
    private Double userBalance; //可用余额
    private Double generalAssets; //总金额
    private Double userFrozenCapital; //冻结金额
    private Double theCollectingAmount; //代收金额
    private Double generationAlsoAmount; //代还金额
    private Double totalRevenue; //总收益
    private Date latelyLoginTime; //最近登录时间
    private Integer loginCount; //最近登录时间


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
