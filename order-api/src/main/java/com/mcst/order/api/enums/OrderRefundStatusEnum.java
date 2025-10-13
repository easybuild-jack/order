package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 订单退款状态 0：未退款，1：全部退款，2：部分退款
 *
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum OrderRefundStatusEnum {

    /**
     * 未退款
     */
    NOT_REFUNDED(0, "未退款"),
    /**
     * 全部退款
     */
    FULL_REFUNDED(1, "全部退款"),
    /**
     * 部分退款
     */
    PARTIAL_REFUNDED(2, "部分退款");

    private final int code;
    private final String description;

    OrderRefundStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static OrderRefundStatusEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (OrderRefundStatusEnum value : values()) {
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

