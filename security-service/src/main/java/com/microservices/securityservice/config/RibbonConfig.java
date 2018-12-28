package com.microservices.securityservice.config;

import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RetryRule;

public class RibbonConfig {
 
    @Bean
    public IPing ribbonPing(final IClientConfig config) {
        return new PingUrl(false,"/ping");
    }
 
    @Bean
    public IRule ribbonRule(final IClientConfig config) {
        return new RetryRule(new AvailabilityFilteringRule());
    }
 
}
