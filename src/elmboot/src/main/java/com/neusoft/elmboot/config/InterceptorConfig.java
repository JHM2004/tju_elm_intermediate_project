package com.neusoft.elmboot.config;

import com.neusoft.elmboot.intercept.WalletIsFrozenInterceptor;
import com.neusoft.elmboot.intercept.WalletNotFoundInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private WalletIsFrozenInterceptor walletIsFrozenInterceptor;
    @Autowired
    private WalletNotFoundInterceptor walletNotFoundInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(walletIsFrozenInterceptor)
                .addPathPatterns("/plus/**")
                .excludePathPatterns("/plus/VirtualWalletController/unFreeze")
                .excludePathPatterns("/plus/VirtualWalletController/getFreeze")
                .excludePathPatterns("/plus/VirtualWalletController/addWalletById");
        registry.addInterceptor(walletNotFoundInterceptor)
                .addPathPatterns("/plus/**")
                .excludePathPatterns("/plus/VirtualWalletController/addWalletById");
    }
}
