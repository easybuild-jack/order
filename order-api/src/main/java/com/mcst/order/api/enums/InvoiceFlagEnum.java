package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 是否要发票 0未开 1已开
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum InvoiceFlagEnum {

    /**
     * 未开发票
     */
    NOT_INVOICED(0, "未开发票"),
    /**
     * 已开票
     */
    INVOICED(1, "已开票");

    private final int code;
    private final String description;

    InvoiceFlagEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static InvoiceFlagEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (InvoiceFlagEnum value : values()) {
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

