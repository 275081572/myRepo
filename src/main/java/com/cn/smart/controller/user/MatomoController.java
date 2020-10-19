package com.cn.smart.controller.user;

import com.cn.smart.common.JsonResult;
import com.cn.smart.model.user.Matomo;
import io.swagger.annotations.Api;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author DELL
 */
@RestController
@RequestMapping("/api/1.0/matomo")
@Api("Matomo测试")
@CrossOrigin
public class MatomoController {

    @PostMapping("/search")
    @ResponseBody
    public JsonResult search(@RequestBody Matomo matomo) {
        try {
            OkHttpClient client =  new  OkHttpClient();
            Request request =  new  Request.Builder()
                    .url( matomo.getUrl() )
                    .build();
            Response response = client.newCall(request).execute();
            if  (!response.isSuccessful()) {
                throw  new IOException( "服务器端错误: "  + response);
            }
            Headers responseHeaders = response.headers();
            for  ( int  i =  0 ; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) +  ": "  + responseHeaders.value(i));
            }
            System.out.println(response.body().string());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return JsonResult.ok();
    }

    /**
     *  UsersManager.getAvailableRoles
     *  http://193.112.79.59/matomo/index.php?module=API
     *  &method=UsersManager.getAvailableRoles&format=JSON&token_auth=f9546d3a61d3bb385af1d6c382739064
     */
}
