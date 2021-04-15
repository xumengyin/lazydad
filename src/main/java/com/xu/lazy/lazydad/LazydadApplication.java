package com.xu.lazy.lazydad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.xu.lazy.filter") //配置扫描webfilter注解才有效
public class LazydadApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazydadApplication.class, args);
    }

}
