package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * @author author
 * @date 2025-01-21
 * @description 取消订单原因类型
 */
@Getter
public enum CancelReasonEnum {

    USER_REQUEST(1, "用户主动取消"),
    PAYMENT_TIMEOUT(2, "支付超时"),
    INSUFFICIENT_STOCK(3, "库存不足"),
    PRICE_CHANGED(4, "价格变动"),
    SYSTEM_CANCEL(5, "系统取消"),
    MERCHANT_CANCEL(6, "商家取消"),
    OTHER(99, "其他原因");

    private final int code;
    private final String description;

    CancelReasonEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CancelReasonEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (CancelReasonEnum value : values()) {
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
