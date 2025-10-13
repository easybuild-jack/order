package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 退款来源 0 用户申请 1 商家发起 2 系统发起
 *
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum RefundSourceEnum {

    /**
     * 用户申请
     */
    USER_APPLY(0, "用户申请"),
    /**
     * 商家发起
     */
    MERCHANT_INITIATED(1, "商家发起"),
    /**
     * 系统发起
     */
    SYSTEM_INITIATED(2, "系统发起");

    private final int code;
    private final String description;

    RefundSourceEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static RefundSourceEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (RefundSourceEnum value : values()) {
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

