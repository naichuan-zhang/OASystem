package com.naichuan.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * @author Naichuan Zhang
 */
@Configuration
@PropertySource("classpath:/jdbc.properties")
public class DataSourceConfig {

    @Value("${jdbc.driver}")
    private String driverClass;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.initialSize}")
    private int initialSize;

    @Value("${jdbc.maxActive}")
    private int maxActive;

    @Value("${jdbc.maxIdle}")
    private int maxIdle;

    @Value("${jdbc.minIdle}")
    private int minIdle;

    @Value("${jdbc.maxWait}")
    private int maxWait;

    @Bean
    @Scope("singleton")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        return dataSource;
    }
}
