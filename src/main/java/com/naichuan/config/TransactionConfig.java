package com.naichuan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Naichuan Zhang
 */
@Configuration
@EnableTransactionManagement
@ImportResource("classpath:spring-tx.xml")
public class TransactionConfig {
}
