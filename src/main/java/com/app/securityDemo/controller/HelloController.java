package com.app.securityDemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@PreAuthorize("denyAll()")
public class HelloController {

    @GetMapping("/hello")
    @PreAuthorize("permitAll()")
    public String hello(){
        return "Hello world not secured";
    }

    @GetMapping("/hello-secured")
    @PreAuthorize("hasAuthority('READ')")
    public String HelloSecured(){
        return "Hello world secured";
    }

    @GetMapping("hello-authorize")
    @PreAuthorize("hasAuthority('CREATE')")
    public String helloAuthorize(){
        return "Hello world authorized";
    }
}
