package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * @author liuyijun
 * @date 2025-10-13
 * @description 配送方式 0 自提 1 快递 2 自动发货
 */
@Getter
public enum DispatchTypeEnum {

    /**
     * 自提
     */
    SELF_PICKUP(0, "自提"),
    /**
     * 快递
     */
    EXPRESS(1, "快递"),
    /**
     * 自动发货
     */
    AUTO_DELIVERY(2, "自动发货"),
    /**
     * 送货上门
     */
    DELIVERY(3, "送货上门"),
    /**
     * 货柜配送
     */
    CONTAINER(99, "货柜配送");

    private final int code;
    private final String description;

    DispatchTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DispatchTypeEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (DispatchTypeEnum value : values()) {
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