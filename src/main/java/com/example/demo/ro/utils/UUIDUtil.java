package com.example.demo.ro.utils;

import java.util.UUID;

/**
 * @author 物联网工程系 ITAEM 唐奕泽
 * @Description
 * @date 2022/5/23 22:08
 */
public class UUIDUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
