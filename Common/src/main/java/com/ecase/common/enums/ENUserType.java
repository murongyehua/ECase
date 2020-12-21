package com.ecase.common.enums;

import lombok.Getter;

/**
 * @author liul
 * @version 1.0 2020/12/21
 */
@Getter
public enum ENUserType {
    //
    NORMAL("0", "普通用户"),
    SMG("1", "系统管理员")
    ;
    private String value;

    private String label;

    ENUserType(String value, String label) {
        this.value = value;
        this.label = label;
    }

}
