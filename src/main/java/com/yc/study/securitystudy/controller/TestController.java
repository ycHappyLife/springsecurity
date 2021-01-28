package com.yc.study.securitystudy.controller;

import com.yc.study.securitystudy.entity.TUsers;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/index")
    public String index() {
        return "test_index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/secured")
    @Secured({"ROLE_sales"})
    public String secured() {
        System.out.println("secured!!");
        return "secured";
    }

    @GetMapping("/preAuthor")
    @PreAuthorize("hasAnyAuthority('admin')")
    public String preAuthorize() {
        System.out.println("come in preAuthorize!!");
        return "PreAuthorize";
    }

    @GetMapping("/postAuthor")
    @PostAuthorize("hasAnyAuthority('admins')")
    @PostFilter("filterObject.username == 'peter'")
    public List<TUsers> postAuthor() {
        List<TUsers> usersList = new ArrayList<>();
        usersList.add(new TUsers(123, "peter", "123"));
        usersList.add(new TUsers(123, "peter1", "123"));
        return usersList;
    }
}
