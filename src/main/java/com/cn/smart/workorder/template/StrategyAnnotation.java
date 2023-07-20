package com.cn.smart.workorder.template;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategyAnnotation {

    /**
     * 策略选择器
     *
     * @return
     */
    StrategyEnum chooseType();

}
