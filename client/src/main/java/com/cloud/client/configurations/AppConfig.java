package com.cloud.client.configurations;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * As the Hystrix capabilities are transparently injected as AOP advice, we have to adjust the order in which the advice is stacked,
 * in case if we have other advice like Spring’s transactional advice. Here we have adjusted the Spring’s transaction AOP advice to
 * have lower precedence than Hystrix AOP advice:
 */


@Configuration
@EnableFeignClients
//@EnableCircuitBreaker // <- more generic
@EnableHystrix
@EnableHystrixDashboard
//@EnableTransactionManagement
public class AppConfig {

//    @Bean
//    @Primary
//    @Order(value= Ordered.HIGHEST_PRECEDENCE)
//    public HystrixCommandAspect hystrixAspect() {
//        return new HystrixCommandAspect();
//    }
}
