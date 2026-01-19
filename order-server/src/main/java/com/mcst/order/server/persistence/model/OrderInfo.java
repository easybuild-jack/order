package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.OrderInfoDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 作者 liu yijun
 * 日期 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_info")
@AutoMapper(target = OrderInfoDto.class)
public class OrderInfo extends BaseMyBatisPlusEntity<OrderInfo> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    private String orderInfoId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户第三方账号，如微信openid
     */
    private String userThirdAccount;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品SKU 名称
     */
    private String goodsSkuName;

    /**
     * 商品图片
     */
    private String goodsPic;

    /**
     * 商品总数量
     */
    private Integer goodsCount;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 实际金额 ，实际需要支付的金额
     */
    private BigDecimal actualAmount;

    /**
     * 订单类型，0：线上，1：线下
     */
    private Integer orderType;

    /**
     * 配送方式：0 自提 1 快递 2 虚拟商品
     */
    private Integer dispatchType;

    /**
     * 是否要发票 0未开发票，1已开票
     */
    private Integer invoiceFlag;

    /**
     * 售后状态（0：未申请，1：已申请）
     */
    private Integer refundFlag;

    /**
     * 退款状态（0：未退款，1：全部退款，2：部分退款）
     */
    private Integer refundStatus;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 买家备注
     */
    private String userRemark;

    /**
     * 订单来源 0 线上商城 1 线下 2 淘宝 3 京东 4 拼多多 5 抖店
     */
    private Integer orderSource;

    /**
     * 标记备注
     */
    private String tagRemark;

    /**
     * 订单状态（0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款）
     */
    private Integer orderStatus;

    /**
     * 订单渠道
     */
    private Integer orderChannel;

    /**
     * 客户端类型 0 小程序 1 APP 2 PC
     */
    private Integer clientType;

    /**
     * 订单推送状态（0：未推送，1：已推送）
     */
    private Integer pushFlag;

    /**
     * 订单备注
     */
    private String orderRemark;

    /**
     * 统计状态 0未处理 1已处理
     */
    private Integer statisticsFlag;

    /**
     * 商家ID
     */
    private String merchantId;

    /**
     * 商家名称
     */
    private String merchantName;

    /**
     * 商家备注
     */
    private String merchantRemark;

    /**
     * 订单日期
     */
    private LocalDate orderDate;

    /**
     * 订单时间
     */
    private LocalDateTime orderTime;

    /**
     * 代理商ID
     */
    private String agentId;

    /**
     * 供应商名称
     */
    private String agentName;

}