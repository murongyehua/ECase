package com.ecase.user.service.impl;

import com.ecase.user.dao.entity.UserInfo;
import com.ecase.user.dao.mapper.UserInfoMapper;
import com.ecase.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author murongyehua
 * @version 1.0 2020/12/18
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public String test() {
        return userInfoMapper.selectById(1).getNickname();
    }

}
