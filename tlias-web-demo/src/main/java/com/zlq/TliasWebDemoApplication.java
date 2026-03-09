package com.zlq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


//开启对Servlet组件的支持
@ServletComponentScan
@SpringBootApplication
public class TliasWebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebDemoApplication.class, args);
    }

}
