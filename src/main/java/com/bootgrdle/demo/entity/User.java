package com.bootgrdle.demo.entity;

import lombok.Data;

/**
 * @Author: zhangqx
 * @Date: 2021/2/19 16:03
 * @Description:
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
