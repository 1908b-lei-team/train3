package com.fh.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName(value = "t_open_an_account")
public class Account {
    @TableId(type = IdType.INPUT)
    private Integer  id;                //主键
    @TableField("user_id")
    private Integer userId;             //用户id
    @TableField("user_name")
    private String userName;            //用户姓名
    @TableField("id_number")
    private String idNumber;            //身份证号
    @TableField("credit_card_numbers")
    private String creditCardNumbers;   //银行卡号
    @TableField("account_type")
    private String accountType;         //账户类型
    @TableField("bank_phone")
    private String bankPhone;           //手机
    @TableField("confirm_password")
    private String confirmPassword;     //交易密码
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("new_time")
    private Date newTime;
    @TableField("virtual_bank_id")
    private String virtualBankId;
    @TableField("user_balance")
    private Double userBalance;

    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    public String getVirtualBankId() {
        return virtualBankId;
    }

    public void setVirtualBankId(String virtualBankId) {
        this.virtualBankId = virtualBankId;
    }

    public Date getNewTime() {
        return newTime;
    }

    public void setNewTime(Date newTime) {
        this.newTime = newTime;
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
}
