package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 客户端类型 0 小程序 1 APP 2 PC
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum ClientTypeEnum {

    /**
     * 小程序
     */
    MINI_PROGRAM(0, "小程序"),
    /**
     * APP
     */
    APP(1, "APP"),
    /**
     * PC
     */
    PC(2, "PC");

    private final int code;
    private final String description;

    ClientTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ClientTypeEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (ClientTypeEnum value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

    public static boolean isValid(Integer code) {
        return fromCode(code) != null;
    }
}

