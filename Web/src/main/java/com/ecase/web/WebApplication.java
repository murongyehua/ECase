package com.ecase.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author murongyehua
 */
@SpringBootApplication(scanBasePackages = {"com.ecase.web", "com.ecase.base", "com.ecase.user", "com.ecase.project", "com.ecase.case"})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
