package com.oxford.mail.config.database;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 使用AOP配置注解功能 - 切换数据源为主数据源用于写操作
 *
 * @author Chova
 * @date 2020/12/28
 */
@Component
@Aspect
public class WriteDataAdvice {

    /**
     * AOP环绕增强 - 切换数据源为主数据源用于写操作
     * 数据源初始化后默认为从数据源，进行只读操作
     *
     * @param joinPoint 切入点
     * @param writeData 切换写数据源的注解
     * @return Object 操作结果
     * @throws Throwable
     * @see MyBatisConfiguration#routingDataSource()
     */
    @Around("@annotation(writeData)")
    public Object proceed(ProceedingJoinPoint joinPoint, WriteData writeData) throws Throwable {
        try {
            DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DataSourceType.SLAVE);
            Object result = joinPoint.proceed();
            return result;
        } finally {
            DataSourceContextHolder.init();
        }
    }
}
