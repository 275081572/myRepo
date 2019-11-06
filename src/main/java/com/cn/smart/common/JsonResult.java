package com.cn.smart.common;

import lombok.Data;

@Data
public class JsonResult {

    private Object data;
    private int status;
    private String message;

    public static JsonResult ok(){
        JsonResult result = new JsonResult();
        result.setStatus(ResultConstanst.SUCCESS);
        return result;
    }

    public static JsonResult ok(Object data){
        JsonResult result = new JsonResult();
        result.setStatus(ResultConstanst.SUCCESS);
        result.setData(data);
        return result;
    }

    public static JsonResult error(){
        JsonResult result = new JsonResult();
        result.setStatus(ResultConstanst.FAIL);
        return result;
    }
}
