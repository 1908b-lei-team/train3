package com.fh.systemConst;

public interface Const {

    public static final String IMPORT_TEMPLATE_PATH = "/template";

    public static final String IMPORT_EXCEL_PATH = "excel-template.xml";

    public static final String IMPORT_WORD_PATH = "word-template.xml";

    public static final String IMPORT_PDF_PATH = "pdf-template.html";

    //用户登录存的session
    public static final String LOGIN_SESSION_USER = "user";

    //用户登录成功存放到cookie中
    public static final String LOGIN_COOKIE_USER = "login_cookie_user";

    //登录时cookie的有效时间
    public static final Integer LOGIN_COOKIE_TIME = 7 * 24 * 60 * 60;

    //在redis中set进去key为唯一标识，需要把唯一标识放到cookie中，
    public static final String LOGIN_COOKIE_KEY = "cookie_key";

    //发送手机验证码
    public static final String LOGIN_PHONE_CODE = "phone_code";


    //商品信息存在redis中，key = 该常量+memberId
    public static final String REDIS_CART_PRODUCT = "cart:";
    //商品数量存在redis中，key = 该常量+memberId
    public static final String REDIS_PRODUCT_NUM = "product_num:";

    /**
     * 过期时间15分钟
     * 可根据需求设置
     */
    public static final int EXPIRE_TIME = 30 * 60 * 1000;

    public static final String LOGIN_TOKEN_KEY = "token:";


    //订单未支付
    public static final int ORDER_STATUS_PAY_NOT = 0;
    //订单已支付
    public static final int ORDER_STATUS_PAY_OK = 1;

    //redis中存订单号所对应的订单信息，在cookie中关联的name
    public static final String REDIS_ORDER_INFO = "orderinfo:";

    public static final String REDIS_CATEGORY_LIST = "category_list:";


}
