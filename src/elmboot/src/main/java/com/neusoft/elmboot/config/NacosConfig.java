package com.neusoft.elmboot.config;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@RefreshScope
@Configuration
@Component
public class NacosConfig {
    @Value("${price.achieve}")
    private int achieve;
    @Value("${price.give}")
    private int give;
    @Value("${price.percent}")
    private float percent;

}