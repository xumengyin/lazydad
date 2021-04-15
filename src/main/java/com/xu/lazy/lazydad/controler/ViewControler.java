package com.xu.lazy.lazydad.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewControler {

    @RequestMapping("/")
    public String index() {
        return "main/index";
    }
}
