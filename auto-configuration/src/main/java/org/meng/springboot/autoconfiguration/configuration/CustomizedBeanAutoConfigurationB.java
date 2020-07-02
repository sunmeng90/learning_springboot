package org.meng.springboot.autoconfiguration.configuration;

import org.meng.springboot.autoconfiguration.beans.BeanB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "spring", name = "autoconfiguration.enableAutoConfigurationB", havingValue = "true")
public class CustomizedBeanAutoConfigurationB {
    @Bean
    public BeanB beanB() {
        return new BeanB();
    }
}
