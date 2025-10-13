package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 是否需要退货 0 不需要 1 需要
 *
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum ReturnGoodsFlagEnum {

    /**
     * 不需要退货
     */
    NOT_REQUIRED(0, "不需要退货"),
    /**
     * 需要退货
     */
    REQUIRED(1, "需要退货");

    private final int code;
    private final String description;

    ReturnGoodsFlagEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ReturnGoodsFlagEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (ReturnGoodsFlagEnum value : values()) {
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

