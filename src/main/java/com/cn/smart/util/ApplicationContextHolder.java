package com.cn.smart.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/20
 */
@Component
public class ApplicationContextHolder implements BeanDefinitionRegistryPostProcessor, PriorityOrdered, ApplicationContextAware {
    public static ApplicationContext applicationContext;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextHolder.applicationContext = applicationContext;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

    }

    public static String getPropetiy(String key) throws BeansException {
        return applicationContext.getEnvironment().getProperty(key);
    }

    public static Object getBean(String name, Object... args) throws BeansException {
        return applicationContext.getBean(name, args);
    }

    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }

    public static <T> T getBean(Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(requiredType);
    }

    public static  <T> Map<String, T> getBeansOfType(Class<T> requiredType) throws BeansException {
        return applicationContext.getBeansOfType(requiredType);
    }

}
