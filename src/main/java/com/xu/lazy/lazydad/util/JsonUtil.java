package com.xu.lazy.lazydad.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
    public static String classToJson(Object obj) {
        return JSONObject.toJSONString(obj);
    }
}
