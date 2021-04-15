package com.xu.lazy.lazydad.controler;

import com.xu.lazy.lazydad.pojo.Person;
import com.xu.lazy.lazydad.pojo.Response;
import com.xu.lazy.lazydad.util.Utils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@RestController
public class StartControler {

    @RequestMapping("/do")
    public String index() {
        return "apd";
    }

    //resful 风格
    @RequestMapping("/api/{name}/{age}")
    public Response<Person> api(@PathVariable("name") String name, @PathVariable String age) {

        Person person = new Person(name, age);

        return Response.success(person);
    }
    @RequestMapping("/login")
    public Response<Person> login(HttpServletResponse response) {

        Person person = new Person("--", "19");
        response.addCookie(Utils.createCookie("userName","111"));
        return Response.success(person);
    }
}
