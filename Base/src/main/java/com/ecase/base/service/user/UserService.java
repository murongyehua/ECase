package com.ecase.base.service.user;

import com.ecase.base.dto.req.UserAddReq;
import com.ecase.base.dto.req.UserLoginReq;
import com.ecase.base.dto.resp.UserLoginResp;
import com.ecase.common.bean.ResultContext;

/**
 * @author liul
 * @version 1.0 2020/12/21
 */
public interface UserService {

    ResultContext<UserLoginResp> userLogin(UserLoginReq req);

    ResultContext addUser(UserAddReq req);

}
