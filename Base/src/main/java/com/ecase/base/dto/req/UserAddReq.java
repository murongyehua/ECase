package com.ecase.base.dto.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liul
 * @version 1.0 2020/12/21
 */
@Getter
@Setter
public class UserAddReq {

    private String username;

    private String password;

    private String nickname;

}
