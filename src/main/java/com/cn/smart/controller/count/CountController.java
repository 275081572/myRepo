package com.cn.smart.controller.count;

import com.cn.smart.common.JsonResult;
import com.cn.smart.jpa.entity.user.User;
import com.cn.smart.service.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0/count")
@Api("统计管理相关api")
@CrossOrigin
public class CountController {

    @ApiOperation(value="测试")
    @GetMapping("/test")
    public JsonResult test() {
        try {
            return JsonResult.ok("Hello World");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error();
        }
    }

}
