package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 订单渠道
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum OrderChannelEnum {

    /**
     * 微信小程序
     */
    WECHAT_MINI_PROGRAM(0, "微信小程序"),
    /**
     * 微信公众号
     */
    WECHAT_OFFICIAL_ACCOUNT(1, "微信公众号"),
    /**
     * APP
     */
    APP(2, "APP"),
    /**
     * PC
     */
    PC(3, "PC"),
    /**
     * 其他
     */
    OTHER(99, "其他");

    private final int code;
    private final String description;

    OrderChannelEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static OrderChannelEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (OrderChannelEnum value : values()) {
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

