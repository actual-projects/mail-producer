package com.oxford.mail.constant;

/**
 * @ClassName : Const
 * @Description : 配置通用的静态常量
 * @Author : Chova
 * @Date : Created 2020-02-26
 */
public class Const {

    public Const() {
    }

    /**
     * 环境
     */
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";

    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    public static final String SPRING_PROFILE_LOCATION = "local";

    /**
     * 无关联记录
     */
    public static final String NO_FOREIGN_REF = "0";

    /**
     * 判断：是 1
     */
    public static final String TRUE = "1";

    /**
     * 判断：否 0
     */
    public static final String FALSE = "0";

    /**
     * 通用字符集编码 UTF-8
     */
    public static final String CHARSET_UTF8 = "UTF-8";

    /**
     * 中文字符集编码 GBK
     */
    public static final String CHARSET_CHINESE = "GBK";

    /**
     * 英文字符集编码：ISO-8859-1
     */
    public static final String CHASRSET_LATIN = "ISO-8859-1";

    /**
     * 根节点ID：root
     */
    public static final String ROOT_ID = "root";

    /**
     * NULL字符串
     */
    public static final String NULL = "null";

    /**
     * 本机地址名：localhost
     */
    public static final String LOCALHOST = "localhost";

    /**
     * 日期格式：yyyy-MM-dd
     */
    public static final String FORMAT_DATE = "yyyy-MM-dd";

    /**
     * 日期格式-短格式：yyyyMMdd
     */
    public static final String FORMAT_DATE_SHORT = "yyyyMMdd";

    /**
     * 日期时间格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期时间格式-短格式：yyyyMMddHHmmss
     */
    public static final String FORMAT_DATETIME_SHORT = "yyyyMMddHHmmss";

    /**
     * 时间戳格式：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 时间戳格式-短格式：yyyyMMddHHmmssSSS
     */
    public static final String FORMAT_TIMESTAMP_SHORT = "yyyyMMddHHmmssSSS";

    /**
     * 成功
     */
    public static final String SUCCESS = "success";

    /**
     * 失败
     */
    public static final String FAILURE = "failure";

    /**
     * 下划线分割
     */
    public static final String UNDERLINE_SPLIT = "_";

    /**
     * 逗号分割
     */
    public static final String COMMA_SPLIT = ",";

    /**
     * 运行时系统操作人
     */
    public static final String SYS_RUNTIME = "SYS_RUNTIME";

    /**
     * 初始化时系统操作人
     */
    public static final String SYS_INIT = "SYS_INIT";
}
