package com.xu.lazy.lazydad.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("config")
public class NameConfig {

    @Value("${xu.name}")
    public String name;

    public int index=-1;
    @Override
    public String toString() {
        return "NameConfig{" +
                "name='" + name + '\'' +
                '}';
    }

    public NameConfig() {
    }
}
