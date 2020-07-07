package com.ziyue.springboot.std.service;

import com.ziyue.springboot.std.common.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class StartServer {

    public StartServer(@Qualifier(Commons.PRINT_IMPLEMENT_TPYE) PrintService printService) {
        printService.print("test");
    }
}
