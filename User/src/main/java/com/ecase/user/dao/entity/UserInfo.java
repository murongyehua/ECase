package com.ecase.user.dao.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author murongyehua
 * @version 1.0 2020/12/18
 */
@Getter
@Setter
@ToString
@TableName(value = "ecase_user_info")
public class UserInfo {

    @TableId
    private String id;

    private String username;

    private String password;

    private String nickname;

    private Integer version;

    private String remark;

    @TableField(value = "create_user")
    private String createUser;

    @TableField(value = "create_time")
    private String createTime;

    @TableField(value = "last_modify_user")
    private String lastModifyUser;

    @TableField(value = "last_modify_time")
    private String lastModifyTime;

    @TableField(value = "history_flag")
    private String historyFlag;
}
