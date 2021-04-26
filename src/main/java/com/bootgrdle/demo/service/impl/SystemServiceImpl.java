package com.bootgrdle.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bootgrdle.demo.entity.User;
import com.bootgrdle.demo.mapper.UserMapper;
import com.bootgrdle.demo.service.SystemService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhangqx
 * @Date: 2021/2/19 15:19
 * @Description:
 */
@Service
public class SystemServiceImpl implements SystemService {
    private final UserMapper userMapper;

    public SystemServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String index() {
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        JSONArray jsonArray = JSON.parseArray(JSONObject.toJSONString(userList));
        return jsonArray.toJSONString();
    }
}
