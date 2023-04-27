package com.jingdianjichi.user.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private String name;
    private Integer age;
    //本次查询第几页
    private Integer pageIndex;
    //本次查询出来的数量
    private Integer pageSize;
}
