package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 退款状态 0 待审核 1 审核拒绝 2 待退货 3 待收货 4 退款中 5 已退款 6 已关闭
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum RefundStatusEnum {

    /**
     * 待审核
     */
    WAIT_AUDIT(0, "待审核"),
    /**
     * 审核拒绝
     */
    AUDIT_REJECTED(1, "审核拒绝"),
    /**
     * 待退货
     */
    WAIT_RETURN(2, "待退货"),
    /**
     * 待收货
     */
    WAIT_RECEIVE(3, "待收货"),
    /**
     * 退款中
     */
    REFUNDING(4, "退款中"),
    /**
     * 已退款
     */
    REFUNDED(5, "已退款"),
    /**
     * 已关闭
     */
    CLOSED(6, "已关闭");

    private final int code;
    private final String description;

    RefundStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static RefundStatusEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (RefundStatusEnum value : values()) {
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

