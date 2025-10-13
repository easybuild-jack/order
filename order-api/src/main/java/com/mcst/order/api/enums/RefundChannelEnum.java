package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 退款渠道 0 原路退回 1 退至余额 2 线下打款
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum RefundChannelEnum {

    /**
     * 原路退回
     */
    ORIGINAL_ROUTE(0, "原路退回"),
    /**
     * 退至余额
     */
    BALANCE(1, "退至余额"),
    /**
     * 线下打款
     */
    OFFLINE(2, "线下打款");

    private final int code;
    private final String description;

    RefundChannelEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static RefundChannelEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (RefundChannelEnum value : values()) {
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

