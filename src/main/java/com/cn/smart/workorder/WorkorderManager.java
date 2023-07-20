package com.cn.smart.workorder;

import com.cn.smart.common.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */

@RestController
public class WorkorderManager {

    @Autowired
    private CheckStatusHandler checkStatusHandler;

    @Autowired
    private CheckParamHandler checkParamHandler;

    @GetMapping("/chain/test")
    public void test() {
        WorkorderContext context = new WorkorderContext();
        context.setValue("xxx");
        context.setStatus(3);

        Chain<WorkorderContext> workorderContextChain = new Chain<>(checkParamHandler, checkStatusHandler);
        workorderContextChain.handle(context);
    }



}
