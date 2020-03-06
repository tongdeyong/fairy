package com.fairy.system.config;

import com.fairy.system.handler.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @author deyong_tong
 */
@Configuration
@Slf4j
public class WebAppInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Value("${static-resource.path}")
    String staticResourcePath;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/logout", "/file/**");

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = System.getProperties().getProperty("user.home") + staticResourcePath;
        File file = new File(path);
        if (file.exists()) {
            if (!file.mkdirs()) {
                log.error("文件夹创建失败-{}", path);
            }
        }
        registry.addResourceHandler("/static/**").addResourceLocations("file:" + path);
    }
}
