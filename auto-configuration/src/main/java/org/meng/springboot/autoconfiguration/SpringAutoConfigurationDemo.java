package org.meng.springboot.autoconfiguration;


import org.meng.springboot.autoconfiguration.beans.BeanA;
import org.meng.springboot.autoconfiguration.beans.BeanB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringAutoConfigurationDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplication(SpringAutoConfigurationDemo.class).run(args);
        System.out.println("beanA ========>" + context.getBean(BeanA.class));
        System.out.println("beanB ========>" + context.getBean(BeanB.class)); // NoSuchBeanDefinitionException
    }
}
