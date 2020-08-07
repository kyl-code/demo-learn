package org.example.spring;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BeanLifeCycleDemo {
    public static void main(String[] args) {
/*        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.refresh();
        applicationContext.register(BeanLifeCycleDemo.class);
        applicationContext.register(User.class);
        User bean = applicationContext.getBean(User.class);
        applicationContext.close();
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();*/
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name","huihui");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("user", beanDefinition);
        User bean = beanFactory.getBean(User.class);
        System.err.println(bean);
    }

}
