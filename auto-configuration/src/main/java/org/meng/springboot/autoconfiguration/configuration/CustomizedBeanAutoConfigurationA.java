package org.meng.springboot.autoconfiguration.configuration;

import org.meng.springboot.autoconfiguration.ClazzForBeanA;
import org.meng.springboot.autoconfiguration.beans.BeanA;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ClazzForBeanA.class)
@ConditionalOnProperty(prefix = "spring", name = "autoconfiguration.enableAutoConfigurationA", havingValue = "true")
public class CustomizedBeanAutoConfigurationA {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }
}
