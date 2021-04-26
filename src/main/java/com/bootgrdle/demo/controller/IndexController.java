package com.bootgrdle.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bootgrdle.demo.entity.User;
import com.bootgrdle.demo.mapper.UserMapper;
import com.bootgrdle.demo.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zhangqx
 * @Date: 2021/2/3 10:06
 * @Description:
 */
@RestController
@RequestMapping("index")
@Slf4j
public class IndexController {
    private final SystemService systemService;
    public IndexController(SystemService systemService) {
        this.systemService = systemService;
    }


    @RequestMapping("info")
    @CrossOrigin("*")
    public String index(){

        return systemService.index();
    }
}
