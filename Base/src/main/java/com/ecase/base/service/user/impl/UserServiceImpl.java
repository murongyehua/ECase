package com.ecase.base.service.user.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.ecase.base.dto.req.UserAddReq;
import com.ecase.base.dto.req.UserLoginReq;
import com.ecase.base.dto.resp.UserLoginResp;
import com.ecase.base.service.user.UserService;
import com.ecase.common.bean.ResultContext;
import com.ecase.common.bean.user.UserContext;
import com.ecase.common.bean.user.UserLoginInfo;
import com.ecase.common.enums.ENHistoryFlag;
import com.ecase.common.enums.ENMsgCode;
import com.ecase.common.enums.ENUserType;
import com.ecase.user.dao.entity.UserInfo;
import com.ecase.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author liul
 * @version 1.0 2020/12/21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public ResultContext<UserLoginResp> userLogin(UserLoginReq req) {
        UserInfo userInfo = new UserInfo();
        BeanUtil.copyProperties(req, userInfo);
        ResultContext<UserInfo> loginResultContext = userInfoService.userLogin(userInfo);
        if (loginResultContext.getData() == null) {
            return ResultContext.businessFail("用户名或密码错误");
        }
        UserInfo successUserInfo = loginResultContext.getData();
        UserLoginResp resp = new UserLoginResp();
        BeanUtil.copyProperties(successUserInfo, resp);
        UserLoginInfo userLoginInfo = new UserLoginInfo(successUserInfo.getUsername(),
                successUserInfo.getNickname(), successUserInfo.getId(), successUserInfo.getType(), StrUtil.EMPTY);
        UserContext.setUserInfo(userLoginInfo);
        return new ResultContext<>(ENMsgCode.SUCCESS.getValue(), "登录成功!", true, resp);
    }

    @Override
    public ResultContext addUser(UserAddReq req) {
        UserInfo userInfo = new UserInfo();
        BeanUtil.copyProperties(req, userInfo);
        userInfo.setId(IdUtil.simpleUUID());
        userInfo.setHistoryFlag(ENHistoryFlag.NEW.getValue());
        userInfo.setPassword(DigestUtil.md5Hex(req.getPassword()));
        userInfo.setCreateUser(UserContext.getUserId());
        userInfo.setLastModifyUser(UserContext.getUserId());
        userInfo.setType(ENUserType.NORMAL.getValue());
        String dateStr = DateUtil.format(new Date(), DatePattern.NORM_DATETIME_PATTERN);
        userInfo.setCreateTime(dateStr);
        userInfo.setLastModifyTime(dateStr);
        userInfo.setVersion(1);
        return userInfoService.addUser(userInfo);
    }

}
