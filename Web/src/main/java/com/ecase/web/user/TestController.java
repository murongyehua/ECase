package com.ecase.web.user;

import com.ecase.base.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author murongyehua
 * @version 1.0 2020/12/18
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/doTest.pub")
    public String test() {
        return testService.test();
    }

}
