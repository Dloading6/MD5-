package com.example.demo.result;

import afu.org.checkerframework.checker.units.qual.C;
import lombok.Data;

/**
 * @author 物联网工程系 ITAEM 唐奕泽
 * @Description
 * @date 2022/5/23 21:41
 */
@Data
public class CodeMsg {
    private Integer code;
    private String msg;

    public static CodeMsg BIND=new CodeMsg(500,"参数错误");
    public static CodeMsg SUCCESS=new CodeMsg(200,"Successful");

    public static CodeMsg SERVICE_ERROR=new CodeMsg(50000,"服务器错误");

    public static CodeMsg ID_PASSWORD_ERROR=new CodeMsg(51101,"账号或密码错误");

    public CodeMsg() {
    }

    public CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "[" +
                "错误代码：" + code +
                ", 错误信息：" + msg +
                ']';
    }
}
