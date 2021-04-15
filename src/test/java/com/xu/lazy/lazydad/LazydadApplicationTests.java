package com.xu.lazy.lazydad;

import com.xu.lazy.lazydad.pojo.NameConfig;
import com.xu.lazy.lazydad.pojo.XuConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class LazydadApplicationTests {


    @Autowired
    private Environment environments;
    @Autowired
    @Qualifier("config")
    private NameConfig config;

    @Value("${environment}")
    private String environment;
    @Autowired
    private XuConfig xu;
    @Test
    void contextLoads() {
        //从配置文件导入
        System.out.println("--"+config.toString());
        NameConfig config1=new NameConfig();
        System.out.println("--"+config1.toString());
        System.out.println("--"+xu.toString());
        System.out.println("--environment:"+environment);
        System.out.println("--environments---:"+environments);
    }

}
