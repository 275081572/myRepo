package com.cn.smart.controller.user;

import com.cn.smart.common.BizException;
import com.cn.smart.common.JsonResult;
import com.cn.smart.common.ResultConstanst;
import com.cn.smart.jpa.entity.user.User;
import com.cn.smart.service.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/1.0/user")
@Api("用户管理相关api")
@CrossOrigin
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @ApiOperation(value="获取某个用户详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="uId",dataType="Long",required=true,value="用户Id")
    })
    @GetMapping("/findById")
    public JsonResult findById(@RequestParam(value = "uId") Long uId) {

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");

        try {
            User user = userService.findById(uId);
            return JsonResult.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error();
        }
    }

    @ApiOperation(value="增加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "phone", dataType = "String", required = true, value = "手机号"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "登陆密码"),
            @ApiImplicitParam(paramType = "query", name = "name", dataType = "String", required = false, value = "用户姓名"),
            @ApiImplicitParam(paramType = "query", name = "email", dataType = "String", required = false, value = "用户邮箱"),
            @ApiImplicitParam(paramType = "query", name = "remark", dataType = "String", required = false, value = "备注")
    })
    @PostMapping("/addUser")
    public JsonResult addUser(User user) {
        try {
            userService.addUser(user);
            return JsonResult.ok();
        } catch (Exception e) {
           e.printStackTrace();
           return JsonResult.error();
        }
    }

    @ApiOperation(value="异常测试")
    @GetMapping("/ececptionTest")
    public JsonResult ececptionTest() throws Exception{
        //throw new BizException(ResultConstanst.FAIL, ResultConstanst.MSG.PARAM_ERROR);
        throw new IllegalAccessException();
        //return JsonResult.ok();
    }

}
