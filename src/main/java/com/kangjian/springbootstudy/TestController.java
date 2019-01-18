package com.kangjian.springbootstudy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/dddtest")
    public Response bean() {
        return Response.ok(new bean("siadfasdfasddfa", 11));
    }
}
