package com.ecase.user.service;

import com.ecase.common.bean.ResultContext;
import com.ecase.user.dao.entity.UserInfo;

/**
 * @author murongyehua
 * @version 1.0 2020/12/18
 */
public interface UserInfoService {

    String test();

    ResultContext<UserInfo> userLogin(UserInfo userInfo);

    ResultContext addUser(UserInfo userInfo);

}
