package com.xu.lazy.lazydad.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 配置前缀，读取属性资源文件
 */
@Component()
@ConfigurationProperties(prefix = "xu")
public class XuConfig {

    public String name;

    public String sex;
    public String id1;
    public String id2;
    public String id3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getId3() {
        return id3;
    }

    public void setId3(String id3) {
        this.id3 = id3;
    }

    @Override
    public String toString() {
        return "XuConfig{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", id1='" + id1 + '\'' +
                ", id2='" + id2 + '\'' +
                ", id3='" + id3 + '\'' +
                '}';
    }

    public XuConfig() {
    }
}
