package com.cn.smart.controller.user;

import com.cn.smart.common.JsonResult;
import com.cn.smart.model.user.User;
import com.cn.smart.service.user.ICacheService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试caffeine
 * @Author: xuwei
 * @Date: 2020/7/16 16:03
 */
@RestController
@RequestMapping("/api/1.0/cache")
@Api("缓存测试相关api")
@CrossOrigin
public class CacheController {

    @Autowired
    private ICacheService cacheService;

    @GetMapping("/findById")
    public JsonResult findById(@RequestParam(value = "uId") Long uId) {
        try {
            User user = cacheService.findById(uId);
            return JsonResult.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error();
        }
    }
}
