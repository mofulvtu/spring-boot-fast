package com.liuzg.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <pre>
 *  Desc: Druid注入的配置参数
 * </pre>
 *
 * @author liuzg
 * @date  2019/10/15 12:52
 **/
@Data
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidProperties {

    private String url;

    private String driverClassName;

    private String username;

    private String password;

    private String publicKey;

    private Integer initialSize;

    private Integer minIdle;

    private Integer maxActive;

    private Long maxWait;

    private Long timeBetweenEvictionRunsMillis;

    private Long minEvictableIdleTimeMillis;

    private Boolean poolPreparedStatements;

    private Integer maxPoolPreparedStatementPerConnectionSize;

    private String validationQuery;

    private String filters;

}
