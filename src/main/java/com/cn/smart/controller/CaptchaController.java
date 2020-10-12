package com.cn.smart.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author DELL
 */
@RestController
@RequestMapping("/api/1.0/captcha")
@Api("手机管理相关api")
@CrossOrigin
public class CaptchaController {

    @GetMapping("/captcha")
    @ResponseBody
    public void captcha(HttpServletResponse response) throws IOException {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100, 4, 5);
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            lineCaptcha.write(outputStream);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != outputStream) {
                outputStream.close();
            }
        }
    }
}
