package com.cn.smart.common;

import cn.hutool.http.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
            e.printStackTrace();
            return JsonResult.error();
        }
    }

}
