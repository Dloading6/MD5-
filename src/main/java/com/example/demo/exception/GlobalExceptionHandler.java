package com.example.demo.exception;

import com.example.demo.result.CodeMsg;
import com.example.demo.result.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 物联网工程系 ITAEM 唐奕泽
 * @Description
 * @date 2022/5/23 22:00
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultVo<String> exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();

        if(e instanceof GlobalException){
            GlobalException globalException= (GlobalException) e;
            return ResultVo.error(globalException.getCodeMsg());
        }else{
            return ResultVo.error(CodeMsg.SERVICE_ERROR);
        }

    }
}
