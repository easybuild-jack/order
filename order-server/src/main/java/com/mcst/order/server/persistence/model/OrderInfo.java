package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author: liu yijun
 * @date: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_info")
@Table(name = "order_info", comment = "订单信息")
public class OrderInfo extends BaseMyBatisPlusEntity<OrderInfo> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderInfoId", isKey = true, length = 50)
    private String orderInfoId;

    /**
     * 订单编号
     */
    @Column(comment = "订单编号", length = 50)
    private String orderNo;

    /**
     * 用户ID
     */
    @Column(comment = "用户ID", length = 50)
    private String userId;

    /**
     * 用户第三方账号，如微信openid
     */
    @Column(comment = "用户第三方账号，如微信openid", length = 50)
    private String userThirdAccount;

    /**
     * 用户电话
     */
    @Column(comment = "用户电话", length = 50)
    private String userPhone;

    /**
     * 商品名称
     */
    @Column(comment = "商品名称", length = 50)
    private String goodsName;

    /**
     * 商品SKU 名称
     */
    @Column(comment = "商品SKU 名称", length = 150)
    private String goodsSkuName;

    /**
     * 商品图片
     */
    @Column(comment = "商品图片", length = 200)
    private String goodsPic;

    /**
     * 商品总数量
     */
    @Column(comment = "商品总数量", length = 10)
    private Integer goodsCount;

    /**
     * 总金额
     */
    @Column(comment = "订单总金额", length = 10, decimalLength = 2)
    private BigDecimal totalAmount;

    /**
     * 实际金额 ，实际需要支付的金额
     */
    @Column(comment = "实际金额，实际需要支付的金额", length = 10, decimalLength = 2)
    private BigDecimal actualAmount;

    /**
     * 订单类型，0：线上，1：线下
     */
    @Column(comment = "订单类型 0：线上，1：线下", length = 5, defaultValue = "0")
    private Integer orderType;

    /**
     * 配送方式：0 自提 1 快递 2 虚拟商品
     */
    @Column(comment = "配送方式 0 自提 1 快递 2 虚拟商品", length = 2, defaultValue = "0")
    private Integer dispatchType;

    /**
     * 是否要发票 0未开发票，1已开票
     */
    @Column(comment = "是否要发票 0未开发票，1已开票", length = 2, defaultValue = "0")
    private Integer invoiceFlag;

    /**
     * 售后状态（0：未申请，1：已申请）
     */
    @Column(comment = "售后状态 0：未申请，1：已申请", length = 2, defaultValue = "0")
    private Integer refundFlag;

    /**
     * 退款状态（0：未退款，1：全部退款，2：部分退款）
     */
    @Column(comment = "退款状态 0：未退款，1：全部退款，2：部分退款", length = 2, defaultValue = "0")
    private Integer refundStatus;

    /**
     * 退款金额
     */
    @Column(comment = "退款金额", length = 10, decimalLength = 2)
    private BigDecimal refundAmount;

    /**
     * 买家备注
     */
    @Column(comment = "买家备注", length = 200)
    private String userRemark;

    /**
     * 订单来源 0 线上商城 1 线下 2 淘宝 3 京东 4 拼多多 5 抖店
     */
    @Column(comment = "订单来源 0 线上商城 1 线下 2 淘宝 3 京东 4 拼多多 5 抖店", length = 2, defaultValue = "0")
    private Integer orderSource;

    /**
     * 标记备注
     */
    @Column(comment = "标记备注", length = 200)
    private String tagRemark;

    /**
     * 订单状态（0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款）
     */
    @Column(comment = "订单状态 0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款", length = 2, defaultValue = "0")
    private Integer orderStatus;

    /**
     * 订单渠道
     */
    @Column(comment = "订单渠道", length = 50)
    private Integer orderChannel;

    /**
     * 客户端类型 0 小程序 1 APP 2 PC
     */
    @Column(comment = "客户端类型 0 小程序 1 APP 2 PC", length = 2, defaultValue = "0")
    private Integer clientType;

    /**
     * 订单推送状态（0：未推送，1：已推送）
     */
    @Column(comment = "订单推送状态 0：未推送，1：已推送", length = 2, defaultValue = "0")
    private Integer pushFlag;

    /**
     * 订单备注
     */
    @Column(comment = "订单备注", length = 200)
    private String orderRemark;

    /**
     * 统计状态 0未处理 1已处理
     */
    @Column(comment = "统计状态 0未处理 1已处理", length = 2, defaultValue = "0")
    private Integer statisticsFlag;

    /**
     * 商家ID
     */
    @Column(comment = "商家ID", length = 50)
    private String merchantId;

    /**
     * 商家名称
     */
    @Column(comment = "商家名称", length = 50)
    private String merchantName;

    /**
     * 商家备注
     */
    @Column(comment = "商家备注", length = 200)
    private String merchantRemark;

    /**
     * 订单日期
     */
    @Column(comment = "订单日期", type = MySqlTypeConstant.DATE)
    private LocalDate orderDate;

    /**
     * 订单时间
     */
    @Column(comment = "订单时间", type = MySqlTypeConstant.TIMESTAMP)
    private LocalDateTime orderTime;

}