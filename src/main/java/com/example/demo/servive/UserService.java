package com.example.demo.servive;

import com.example.demo.result.ResultVo;
import com.example.demo.ro.LoginRo;
import com.example.demo.ro.UserRo;

/**
 * @author 物联网工程系 ITAEM 唐奕泽
 * @Description
 * @date 2022/5/23 22:18
 */
public interface UserService {
    public ResultVo add(UserRo userRo);

    public ResultVo login(LoginRo loginRo);
}
