package com.ecase.base.service.impl;

import com.ecase.base.service.TestService;
import com.ecase.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liul
 * @version 1.0 2020/12/18
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public String test() {
        return userInfoService.test();
    }
}
