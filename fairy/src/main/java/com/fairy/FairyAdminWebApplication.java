package com.fairy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author deyong_tong
 */
@SpringBootApplication
@MapperScan(basePackages = "com.fairy.*.dao")
public class FairyAdminWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FairyAdminWebApplication.class, args);
    }

}
