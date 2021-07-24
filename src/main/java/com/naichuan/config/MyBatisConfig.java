package com.naichuan.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Naichuan Zhang
 */
@Configuration
public class MyBatisConfig implements ApplicationContextAware {

    private ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext = applicationContext;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        DataSource dataSource = appContext.getBean(DataSource.class);
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(resolveMapperLocations("classpath*:mapper/*.xml"));
        factoryBean.setTypeAliasesPackage("com.naichuan.entity");
        return factoryBean.getObject();
    }

    private Resource[] resolveMapperLocations(String... locations) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        List<String> mapperLocations = new ArrayList<>(Arrays.asList(locations));
        List<Resource> resources = new ArrayList<>();
        if (mapperLocations.size() > 0) {
            for (String mapperLocation : mapperLocations) {
                try {
                    Resource[] mappers = resolver.getResources(mapperLocation);
                    resources.addAll(Arrays.asList(mappers));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resources.toArray(new Resource[0]);
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        configurer.setBasePackage("com.naichuan.mapper");
        return configurer;
    }
}
