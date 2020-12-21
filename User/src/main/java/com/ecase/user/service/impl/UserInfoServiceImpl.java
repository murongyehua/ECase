package com.ecase.user.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecase.common.bean.ResultContext;
import com.ecase.common.enums.ENHistoryFlag;
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

    @Override
    public ResultContext<UserInfo> userLogin(UserInfo userInfo) {
        userInfo.setPassword(DigestUtil.md5Hex(userInfo.getPassword()));
        UserInfo queryResult = userInfoMapper.selectOne(
                new QueryWrapper<UserInfo>()
                        .eq("username", userInfo.getUsername())
                        .eq("password", userInfo.getPassword()));
        ResultContext<UserInfo> resultContext = ResultContext.success("success");
        resultContext.setData(queryResult);
        return resultContext;
    }

    @Override
    public ResultContext addUser(UserInfo userInfo) {
        UserInfo queryResult = userInfoMapper.selectOne(
                new QueryWrapper<UserInfo>()
                        .eq("username", userInfo.getUsername())
                        .eq("historyFlag", ENHistoryFlag.NEW.getValue()));
        if (queryResult == null) {
            userInfoMapper.insert(userInfo);
            return ResultContext.success("添加成功");
        }
        return ResultContext.businessFail("用户已存在");
    }

}
