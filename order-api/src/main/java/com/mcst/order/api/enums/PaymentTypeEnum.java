package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * @author author
 * @date 2025-01-21
 * @description 支付类型
 */
@Getter
public enum PaymentTypeEnum {

    WECHAT("wechat", "微信支付"),
    ALIPAY("alipay", "支付宝支付"),
    CREDIT("credit", "积分支付"),
    BALANCE("balance", "余额支付"),
    UNION("union", "银联支付");

    private final String code;
    private final String description;

    PaymentTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static PaymentTypeEnum fromCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (PaymentTypeEnum value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return null;
    }

    public static boolean isValid(String code) {
        return fromCode(code) != null;
    }
}
