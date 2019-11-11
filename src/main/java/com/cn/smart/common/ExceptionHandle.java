package com.cn.smart.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult errorHandle(HttpServletRequest request, Exception e){
        try {
            //自定义异常
            BizException bizException = (BizException) e;
            return JsonResult.error(bizException.getCode(), bizException.getMsg());
        }catch (Exception exception){
            return JsonResult.error();
        }
    }

}
