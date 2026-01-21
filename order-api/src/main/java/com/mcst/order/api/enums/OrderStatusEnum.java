package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 订单状态（0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款）
 *
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum OrderStatusEnum {

    /**
     * 待支付
     */
    PENDING_PAYMENT(0, "待支付"),
    /**
     * 已取消
     */
    CANCELED(1, "已取消"),
    /**
     * 待发货
     */
    WAITING_DELIVER(2, "待发货"),
    /**
     * 待收货
     */
    WAITING_RECEIVE(3, "待收货"),
    /**
     * 已收货
     */
    RECEIVED(4, "已收货"),
    /**
     * 退货中
     */
    RETURNING(5, "退货中"),
    /**
     * 退款中
     */
    REFUNDING(6, "退款中"),
    /**
     * 已退款
     */
    REFUNDED(7, "已退款");

    private final int value;
    private final String description;

    OrderStatusEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static OrderStatusEnum fromCode(Integer value) {
        if (value == null) {
            return null;
        }
        for (OrderStatusEnum statusEnum : values()) {
            if (statusEnum.value == value) {
                return statusEnum;
            }
        }
        return null;
    }

    public static boolean isValid(Integer value) {
        return fromCode(value) != null;
    }
}

