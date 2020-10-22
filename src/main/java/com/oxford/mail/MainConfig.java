package com.oxford.mail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * MainConfig主配置类
 *
 * @author Chova
 * @date 2020/08/10
 */
// 启用SpringMVC
@EnableWebMvc
/**
 * 类似xml配置类功能，SpringBoot启动时会识别当前配置类
 *
 * @author Chova
 * @date 2020/08/10
 */
@Configuration
@ComponentScan("com.oxford.mail.*")
@MapperScan(basePackages = "com.oxford.mail.mapper")
public class MainConfig {
}
