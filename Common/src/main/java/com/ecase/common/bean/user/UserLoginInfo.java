package com.ecase.common.bean.user;

import lombok.*;

import java.io.Serializable;

/**
 * @author liul
 * @version 1.0 2020/12/21
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginInfo implements Serializable {

    private static final long serialVersionUID = 4953613226285918884L;

    private String username;
    private String nickname;
    private String userId;
    private String userType;
    private String projectId;

}
