package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 客户端类型 0 小程序 1 APP 2 PC
 *
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum PayStatusEnum {

    /**
     * 待支付
     */
    WAITING(0, "待支付"),
    /**
     * 支付中
     */
    PAYING(1, "支付中"),
    /**
     * PC
     */
    PAID(2, "已支付"),
    /**
     * 已取消
     */
    CANCELLED(3, "已取消"),
    /**
     * 支付失败
     */
    FAILED(4, "支付失败");

    private final int value;
    private final String description;

    PayStatusEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static PayStatusEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (PayStatusEnum statusEnum : values()) {
            if (statusEnum.value == code) {
                return statusEnum;
            }
        }
        return null;
    }

    public static boolean isValid(Integer code) {
        return fromCode(code) != null;
    }
}

