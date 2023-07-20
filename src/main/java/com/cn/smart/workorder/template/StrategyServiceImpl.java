package com.cn.smart.workorder.template;

import java.util.Map;

import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Service;

import com.cn.smart.util.ApplicationContextHolder;
import com.cn.smart.workorder.chain.WorkorderContext;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */
@Service
@Slf4j
public class StrategyServiceImpl implements StrategyService<WorkorderContext> {

    @Override
    public AbstractTemplate<WorkorderContext, String> getTemplate(Integer type) {
        Map<String, AbstractTemplate> processTemplate = ApplicationContextHolder.getBeansOfType(AbstractTemplate.class);
        try {
            //通过获取注解
            for (Map.Entry<String, AbstractTemplate> entry : processTemplate.entrySet()) {
                Class<?> targetClass = AopUtils.getTargetClass(entry.getValue());
                StrategyAnnotation annotation = targetClass.getAnnotation(StrategyAnnotation.class);
                if (annotation != null && annotation.chooseType().getType().equals(type)) {
                    return entry.getValue();
                }
            }
        } catch (Exception e) {
            log.error("执行目标代理对象失败:type = {}， error = {}", type, e.getMessage(), e);
        }
        return null;
    }

}
