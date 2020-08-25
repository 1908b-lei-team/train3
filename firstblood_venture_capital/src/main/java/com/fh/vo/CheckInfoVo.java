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
public class CheckInfoVo {

    @TableId(type = IdType.INPUT)
    private Integer controlId;
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
    private String  fundraisingProgress;



    private int userid;

    private String useridentity;//用户身份

    private String username; //用户名

    private String userphone;//手机号

    private String userpwd;//密码

    private String usersex;//性别

    private String userage;//年龄

    private String usereducation;//学历

    private String usermarriage;//婚姻

    private Date foundtime;//`` datetime DEFAULT NULL COMMENT '注册时间',

    private Date logintime;//   login_time` datetime DEFAULT NULL COMMENT '最后登录时间',

    private String userworktime;//``工作时间 varchar(255) DEFAULT NULL COMMENT '工作时间',

    private String userhouse;//` 房产varchar(255) DEFAULT NULL COMMENT '房产',

    private String userincome;//年收入` varchar(255) DEFAULT NULL COMMENT  '年收入',

    private String userproperty;//总资产 varchar(255) DEFAULT NULL COMMENT  '总资产',

    private String uservehicle;//` 车产 varchar(255) DEFAULT NULL COMMENT  '车产',

    private int logincount;//` int(11) DEFAULT NULL COMMENT '登录次数',

    private String loginstatus;//` varchar(255) DEFAULT NULL COMMENT '是否锁定',

}
