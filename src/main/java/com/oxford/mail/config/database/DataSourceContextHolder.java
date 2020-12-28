package com.oxford.mail.config.database;

import org.springframework.util.Assert;

/**
 * 读写分离主从数据源类型设置类
 *
 * @author Chova
 * @date 2020-11-02
 */
public class DataSourceContextHolder {

    /**
     * 数据源枚举类型
     */
    public enum DataSourceType {
        /**
         * 主数据源 - 写操作
         */
        MASTER,


        /**
         * 从数据源 - 读操作
         */
        SLAVE
    }

    /**
     * 线程局部变量 - 数据类型
     * 保证线程操作安全
     */
    private static final ThreadLocal<DataSourceType> DATA_SOURCE_TYPE = new ThreadLocal<>();

    /**
     * 初始化数据源类型容器
     * 线程局部变量需要初始化后再赋值
     */
    public static void init() {
        DATA_SOURCE_TYPE.remove();
    }

    /**
     * 设置数据源类型
     *
     * @param dataSourceType 数据源类型
     */
    public static void setDataSourceType(DataSourceType dataSourceType) {
        Assert.notNull(dataSourceType, "数据类型值不能为空");
        DATA_SOURCE_TYPE.set(dataSourceType);
    }

    /**
     * 获取数据源类型
     *
     * @return DataSourceType 数据源类型
     */
    public static DataSourceType getDataSourceType() {
        return DATA_SOURCE_TYPE.get() == null ? DataSourceType.SLAVE : DataSourceType.MASTER;
    }

}
