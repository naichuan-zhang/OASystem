package com.naichuan.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.Md5CredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.config.ShiroAnnotationProcessorConfiguration;
import org.apache.shiro.spring.config.ShiroBeanConfiguration;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.ShiroWebConfiguration;
import org.apache.shiro.spring.web.config.ShiroWebFilterConfiguration;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @author Naichuan Zhang
 */
@Configuration
@Import({
        ShiroBeanConfiguration.class,
        ShiroAnnotationProcessorConfiguration.class,
        ShiroWebConfiguration.class,
        ShiroWebFilterConfiguration.class,
})
public class ShiroConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public Realm realm() {
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(dataSource);
        realm.setPermissionsLookupEnabled(true);
        realm.setCredentialsMatcher(credentialsMatcher());
        realm.setCacheManager(cacheManager());
        realm.setAuthenticationQuery("select password from sys_login where username = ?");
        realm.setUserRolesQuery("select role_name from sys_login_role slr " +
                "left join sys_role sr on slr.role_id = sr.role_id" +
                " left join sys_login sl on slr.login_id = sl.login_id" +
                " where slr.username = ?");
        realm.setPermissionsQuery("select permission_name from sys_role_permission srp " +
                "left join sys_permission sp on sp.permission_id = srp.permission_id" +
                " left join sys_role sr on srp.role_id = sr.role_id" +
                " where srp.role_name = ?");
        return realm;
    }

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setLoginUrl("/");
        factoryBean.setSuccessUrl("/home");
        factoryBean.setUnauthorizedUrl("/");
        factoryBean.setSecurityManager(securityManager());
        return factoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        securityManager.setCacheManager(cacheManager());
        return securityManager;
    }

    @PostConstruct
    private void initStaticSecurityManager() {
        SecurityUtils.setSecurityManager(securityManager());
    }

    @Bean
    public CredentialsMatcher credentialsMatcher() {
        return new Md5CredentialsMatcher();
    }

    @Bean
    public CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }
}
