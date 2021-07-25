package com.naichuan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;

/**
 * @author Naichuan Zhang
 */
@Configuration
@ComponentScan(basePackages = "com.naichuan", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class),
})
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    /**
     * This bean is registered to make sure that ${...} placeholders
     * within @Value annotations can be resolved.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }
}
