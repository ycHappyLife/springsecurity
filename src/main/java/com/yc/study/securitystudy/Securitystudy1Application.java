package com.yc.study.securitystudy;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@MapperScan("com.yc.study.securitystudy.mapper")
public class Securitystudy1Application {

    public static void main(String[] args) {
        SpringApplication.run(Securitystudy1Application.class, args);
    }

}
