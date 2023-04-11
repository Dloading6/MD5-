package com.example.demo.servive.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.exception.GlobalException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.result.CodeMsg;
import com.example.demo.result.ResultVo;
import com.example.demo.ro.LoginRo;
import com.example.demo.ro.UserRo;
import com.example.demo.servive.UserService;
import com.example.demo.ro.utils.MD5Util;
import com.example.demo.ro.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author 物联网工程系 ITAEM 唐奕泽
 * @Description
 * @date 2022/5/23 22:19
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ResultVo add(UserRo userRo) {
        if (Objects.isNull(userRo)){
            throw new GlobalException(CodeMsg.BIND);
        }

        log.info(userRo.toString());
        User newUser = new User();
        newUser.setId("user-"+UUIDUtil.uuid());
        String password=userRo.getPassword();
        String salt=UUIDUtil.uuid().substring(0,8);
        log.info(salt);
        newUser.setSalt(salt);
        newUser.setPassword(MD5Util.inputPassToDbPass(password,salt));
        newUser.setNickName(userRo.getNickName());
        newUser.setUsername(userRo.getUsername());

        userMapper.insert(newUser);
        return ResultVo.success(null);
    }

    @Override
    public ResultVo login(LoginRo loginRo) {
        if (Objects.isNull(loginRo)){
            throw new GlobalException(CodeMsg.BIND);
        }

        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",loginRo.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(user)){
            throw new GlobalException(CodeMsg.ID_PASSWORD_ERROR);
        }

        String getPass = MD5Util.inputPassToDbPass(loginRo.getPassword(),user.getSalt());
        if (!getPass.equals(user.getPassword())){
            throw new GlobalException(CodeMsg.ID_PASSWORD_ERROR);
        }

        StpUtil.login(user.getId());

        return ResultVo.success(user);
    }
}
