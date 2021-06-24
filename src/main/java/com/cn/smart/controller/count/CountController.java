package com.cn.smart.controller.count;

import com.cn.smart.common.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0/count")
@Api("统计管理相关api")
@CrossOrigin
public class CountController {

    private Logger log = LoggerFactory.getLogger(CountController.class);

    @ApiOperation(value="测试")
    @GetMapping("/test")
    public JsonResult test() {
        try {
            log.info("请求到我了");
            log.info("111");
            return JsonResult.ok("Hello World");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error();
        }
    }

    /**
     * 嘉联异步回调
     */
    @RequestMapping(value="jlNotify/{channel}/{appId}")
    public String doJlNotify(@PathVariable("channel") String channel, @PathVariable("appId") String appId, @RequestBody String request) {
        String retCode = "success";
        try {
            if (StringUtils.isEmpty(request)) {
                throw new Exception("参数异常");
            }
            log.info("channel:" + channel);
            log.info("appId:" + appId);
            log.info("request:" + request);
            log.info(String.format("接收到的回调参数:[%s]", request));

        } catch (Exception e) {
            log.error("嘉联异步回调出现异常： " + e.getMessage());
            retCode = "fail";
        }
        return retCode;
    }

}
