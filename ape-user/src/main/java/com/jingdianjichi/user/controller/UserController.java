package com.jingdianjichi.user.controller;


import com.jingdianjichi.user.service.UserService;
import entity.dto.UserDto;
import entity.req.UserReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public Integer test(@RequestBody UserReq userReq)
    {

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq,userDto);
        int count = userService.addUser(userDto);
        return count;
    }
}
