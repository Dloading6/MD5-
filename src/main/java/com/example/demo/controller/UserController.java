package com.example.demo.controller;

import com.example.demo.result.ResultVo;
import com.example.demo.ro.LoginRo;
import com.example.demo.ro.UserRo;
import com.example.demo.servive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 物联网工程系 ITAEM 唐奕泽
 * @Description
 * @date 2022/5/23 22:37
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResultVo add(@RequestBody UserRo userRo){
       return userService.add(userRo);
    }

    @PostMapping("/login")
    public ResultVo login(@RequestBody LoginRo loginRo){
        return userService.login(loginRo);
    }
}
