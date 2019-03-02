/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.springbootstudy.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kangjian.springbootstudy.demo.Response;
import com.kangjian.springbootstudy.demo.bean;

@RestController
public class TestController {

    @GetMapping("/dddtest")
    public Response bean() {
        return Response.ok(new bean("siadfasdfasddfa", 11));
    }
}
