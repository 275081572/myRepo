package com.cn.smart.controller.user;

import com.cn.smart.common.JsonResult;
import com.cn.smart.dto.FileBean;
import com.cn.smart.jpa.entity.user.User;
import com.cn.smart.service.user.IUserService;
import com.cn.smart.util.ZipUtils;
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

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipOutputStream;

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
    public JsonResult ececptionTest(){
        //throw new BizException(ResultConstanst.FAIL, ResultConstanst.MSG.PARAM_ERROR);
        //throw new NullPointerException();
        userService.ececptionTest();
        return JsonResult.ok();
    }

    /**
     * 打包压缩下载文件
     */
    @RequestMapping(value = "/downLoadZipFile")
    public void downLoadZipFile(HttpServletResponse response) throws IOException {
        String zipName = "myfile.zip";
        //构建测试数据
        List<FileBean> fileList = new ArrayList<>(2);
        FileBean fileBeanA = new FileBean();
        fileBeanA.setFilePath("E:/个人文档/");
        fileBeanA.setFileName("王维维-JAVA-五年.docx");

        FileBean fileBeanB = new FileBean();
        fileBeanB.setFilePath("E:/个人文档/");
        fileBeanB.setFileName("测试.txt");

        fileList.add(fileBeanA);
        fileList.add(fileBeanB);

        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename="+zipName);
        //跨域支持
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");
        ZipOutputStream out = new ZipOutputStream(response.getOutputStream());

        try {
            for(Iterator<FileBean> it = fileList.iterator(); it.hasNext();){
                FileBean file = it.next();
                //修改文件名
                File f = new File(file.getFilePath()+file.getFileName());
                File newFile = new File(file.getFilePath() + System.currentTimeMillis() +
                        file.getFileName().substring(file.getFileName().lastIndexOf(".")));
                f.renameTo(newFile);

                ZipUtils.doCompress(newFile, out);
                response.flushBuffer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            out.close();
        }
    }


}
