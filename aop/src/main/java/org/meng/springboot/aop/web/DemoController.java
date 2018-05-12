package org.meng.springboot.aop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/aop/demo")
public class DemoController {

    @RequestMapping
    public String showAopGretting() {
        return "This is a demo for aop";
    }

}
