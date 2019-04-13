package org.meng.springboot.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleWebController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        log.info("greeting from client");
        return "Hello World!";
    }

}