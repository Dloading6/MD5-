package com.example.demo.exception;

import com.example.demo.result.CodeMsg;
import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 物联网工程系 ITAEM 唐奕泽
 * @Description
 * @date 2022/5/23 21:56
 */
@Data
public class GlobalException extends RuntimeException{
      private CodeMsg codeMsg;

      public GlobalException(CodeMsg codeMsg){
          super(codeMsg.toString());
          this.codeMsg=codeMsg;
      }
}
