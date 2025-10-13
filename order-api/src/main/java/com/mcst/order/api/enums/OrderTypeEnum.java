package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 订单类型 0：线上，1：线下
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum OrderTypeEnum {

    /**
     * 线上
     */
    ONLINE(0, "线上"),
    /**
     * 线下
     */
    OFFLINE(1, "线下");

    private final int code;
    private final String description;

    OrderTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static OrderTypeEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (OrderTypeEnum value : values()) {
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

