package com.example.demo.result;

import lombok.Data;

/**
 * @author 物联网工程系 ITAEM 唐奕泽
 * @Description
 * @date 2022/5/23 21:47
 */
@Data
public class ResultVo<T> {

    private Integer code;
    private String msg;
    private T data;

    public ResultVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVo(CodeMsg codeMsg){
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

    public static <T> ResultVo<T> success(T data){
        return new ResultVo<>(CodeMsg.SUCCESS.getCode(),CodeMsg.SUCCESS.getMsg(),data);
    }

    public static <T> ResultVo<T> error(CodeMsg codeMsg){
        return new ResultVo<>(codeMsg);
    }
}
