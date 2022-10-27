package com.company.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringSupport implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
