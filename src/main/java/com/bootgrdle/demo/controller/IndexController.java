package com.bootgrdle.demo.controller;

import com.bootgrdle.demo.entity.User;
import com.bootgrdle.demo.mapper.UserMapper;
import com.bootgrdle.demo.service.SystemService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IndexController {
    private final UserMapper userMapper;
    private final SystemService systemService;
    public IndexController(SystemService systemService, UserMapper userMapper) {
        this.systemService = systemService;
        this.userMapper = userMapper;
    }


    @RequestMapping("info")
    public String index(){
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
        return systemService.index();
    }
}
