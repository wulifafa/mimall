package com.lf.mimallnacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/9/4
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@RestController
public class HelloController {

    @Value("${user.name}")
    private String name;


    @GetMapping("/user")
    public String helloUser() {
        return name;
    }
}
