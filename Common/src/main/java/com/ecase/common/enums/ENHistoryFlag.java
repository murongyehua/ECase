package com.ecase.common.enums;

import lombok.Getter;

/**
 * @author liul
 * @version 1.0 2020/12/21
 */
@Getter
public enum ENHistoryFlag {
    //
    NEW("0","非历史版本"),
    HISTORY("1","历史版本");

    private String value;

    private String label;

    ENHistoryFlag(String value, String label) {
        this.value = value;
        this.label = label;
    }

}
