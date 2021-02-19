package com.bootgrdle.demo.controller;

import com.bootgrdle.demo.service.SystemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangqx
 * @Date: 2021/2/3 10:06
 * @Description:
 */
@RestController
@RequestMapping("index")
public class IndexController {
    private final SystemService systemService;

    public IndexController(SystemService systemService) {
        this.systemService = systemService;
    }


    @RequestMapping("info")
    public String index(){
        return systemService.index();
    }
}
