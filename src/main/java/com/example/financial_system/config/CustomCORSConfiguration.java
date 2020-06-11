package com.example.financial_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域访问配置
 * @Author: linqx
 * @Date: 2020/6/11 14:52
 */
@Configuration
public class CustomCORSConfiguration {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addExposedHeader("Content-Type");
        corsConfiguration.addExposedHeader( "X-Requested-With");
        corsConfiguration.addExposedHeader("accept");
        corsConfiguration.addExposedHeader("Origin");
        corsConfiguration.addExposedHeader( "Access-Control-Request-Method");
        corsConfiguration.addExposedHeader("Access-Control-Request-Headers");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
