package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 退款类型 0 仅退款 1 退货退款
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum RefundTypeEnum {

    /**
     * 仅退款
     */
    ONLY_REFUND(0, "仅退款"),
    /**
     * 退货退款
     */
    RETURN_AND_REFUND(1, "退货退款");

    private final int code;
    private final String description;

    RefundTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static RefundTypeEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (RefundTypeEnum value : values()) {
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

