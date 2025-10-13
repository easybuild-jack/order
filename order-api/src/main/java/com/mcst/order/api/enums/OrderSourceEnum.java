package com.mcst.order.api.enums;

import lombok.Getter;

/**
 * 订单来源 0 线上商城 1 线下 2 淘宝 3 京东 4 拼多多 5 抖店
 * @author liuyijun
 * @date 2025-10-13
 */
@Getter
public enum OrderSourceEnum {

    /**
     * 线上商城
     */
    ONLINE_STORE(0, "线上商城"),
    /**
     * 线下
     */
    OFFLINE(1, "线下"),
    /**
     * 淘宝
     */
    TAOBAO(2, "淘宝"),
    /**
     * 京东
     */
    JD(3, "京东"),
    /**
     * 拼多多
     */
    PINDUODUO(4, "拼多多"),
    /**
     * 抖店
     */
    DOUYIN_STORE(5, "抖店");

    private final int code;
    private final String description;

    OrderSourceEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static OrderSourceEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (OrderSourceEnum value : values()) {
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

