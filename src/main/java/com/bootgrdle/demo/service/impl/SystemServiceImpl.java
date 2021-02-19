package com.bootgrdle.demo.service.impl;

import com.bootgrdle.demo.service.SystemService;
import org.springframework.stereotype.Service;

/**
 * @Author: zhangqx
 * @Date: 2021/2/19 15:19
 * @Description:
 */
@Service
public class SystemServiceImpl implements SystemService {
    @Override
    public String index() {
        return "index";
    }
}
