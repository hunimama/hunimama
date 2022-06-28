package com.hkt.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 794073612@qq.com
 * @time 14:03 2022/6/11
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/add")
    public String add() {
        return "hello security";
    }

    @GetMapping("/index")
    public String index() {
        return "hello 胡尼玛";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello hello";
    }

    //    @Secured({"ROLE_sale","ROLE_manager"})
    @PreAuthorize("hasAnyAuthority('admins')")
    @GetMapping("/update")
    public String update() {
        return "hello update";
    }
}
