package com.fh.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OpenAnAccountVo {

    @TableId(type = IdType.INPUT)
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


   // @TableField("user_id")
   // private Integer userId; //用户id
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
    private Date latelyLoginTime; //最近登录时间
    @TableField("login_count")
    private Integer loginCount; //最近登录时间
    @TableField("account_opening_status")
    private  Integer accountOpeningStatus;//开户状态
    @TableField("lockout_state")
    private  Integer lockoutStatus;//锁定状态

    @TableField("fundraising_progress")
    private String  fundraisingProgress;


}
