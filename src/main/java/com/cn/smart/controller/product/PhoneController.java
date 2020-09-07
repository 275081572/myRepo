package com.cn.smart.controller.product;

import com.cn.smart.common.JsonResult;
import com.cn.smart.common.PageBean;
import com.cn.smart.dto.product.ReqPhoneQueryDto;
import com.cn.smart.model.product.Phone;
import com.cn.smart.service.product.IPhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author DELL
 */
@RestController
@RequestMapping("/api/1.0/phone")
@Api("手机管理相关api")
@CrossOrigin
public class PhoneController {

    @Resource
    private IPhoneService phoneService;

    @ApiOperation(value="查询")
    @PostMapping("/query")
    @ResponseBody
    public JsonResult query(@RequestBody ReqPhoneQueryDto phoneQueryDto, HttpServletRequest request) {
        try {
            String userAgent = request.getHeader("user-agent");
            System.out.println(userAgent);
            PageBean pageBean = phoneService.query(phoneQueryDto);
            return JsonResult.ok(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error();
        }
    }

    @GetMapping("/findById")
    @ResponseBody
    public JsonResult findById(String id, HttpServletRequest request) {
        try {
            String userAgent = request.getHeader("user-agent");
            System.out.println(userAgent);
            Phone phone = phoneService.findById(id);
            return JsonResult.ok(phone);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error();
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestBody Phone phone) {
        try {
            phoneService.update(phone);
            return JsonResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error();
        }
    }

}
