package com.mcst.order.orm.plus.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.repository.persistence.annotation.EntityColumn;
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
 * <p>
 * 订单信息
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_info")
@AutoMapper(target = OrderInfoDto.class)
public class OrderInfo extends BaseMyBatisPlusEntity<OrderInfo> {

    /**
     * 订单ID
     */
    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @EntityColumn(comment = "订单ID")
    private String orderId;

    /**
     * 订单编号
     */
    @EntityColumn(comment = "订单编号")
    private String orderNo;

    /**
     * 用户ID
     */
    @EntityColumn(comment = "用户ID")
    private String userId;

    /**
     * 用户第三方账号，如微信openid
     */
    @EntityColumn(comment = "用户第三方账号，如微信openid")
    private String userThirdAccount;

    /**
     * 用户电话
     */
    @EntityColumn(comment = "用户电话")
    private String userPhone;

    /**
     * 用户名称
     */
    @EntityColumn(comment = "用户名称")
    private String userName;

    /**
     * 商品名称
     */
    @EntityColumn(comment = "商品名称")
    private String goodsName;

    /**
     * 商品SKU 名称
     */
    @EntityColumn(comment = "商品SKU 名称")
    private String goodsSkuName;

    /**
     * 商品图片
     */
    @EntityColumn(comment = "商品图片")
    private String goodsPic;

    /**
     * 商品总数量
     */
    @EntityColumn(comment = "商品总数量")
    private Integer goodsCount;

    /**
     * 总金额
     */
    @EntityColumn(comment = "总金额")
    private BigDecimal totalAmount;

    /**
     * 实际支付金额，实际需要支付的金额
     */
    @EntityColumn(comment = "实际支付金额，实际需要支付的金额")
    private BigDecimal actualPayAmount;

    /**
     * 配送方式：0 自提 1 快递 2 虚拟商品 3 送货上门 99 送到货柜
     */
    @EntityColumn(comment = "配送方式：0 自提 1 快递 2 虚拟商品 3 送货上门 99 送到货柜")
    private Integer dispatchType;

    /**
     * 是否要发票 0未开发票，1已开票
     */
    @EntityColumn(comment = "是否要发票 0未开发票，1已开票")
    private Integer invoiceFlag;

    /**
     * 退款状态（0：未退款，1：全部退款，2：部分退款）
     */
    @EntityColumn(comment = "退款状态（0：未退款，1：全部退款，2：部分退款）")
    private Integer refundStatus;

    /**
     * 退款金额
     */
    @EntityColumn(comment = "退款金额")
    private BigDecimal refundAmount;

    /**
     * 买家备注
     */
    @EntityColumn(comment = "买家备注")
    private String userRemark;

    /**
     * 订单状态（0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款）
     */
    @EntityColumn(comment = "订单状态（0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款）")
    private Integer orderStatus;

    /**
     * 订单渠道
     */
    @EntityColumn(comment = "订单渠道")
    private String orderChannel = "mall";

    /**
     * 客户端类型
     */
    @EntityColumn(comment = "客户端类型")
    private String clientType;

    /**
     * 订单推送状态（0：未推送，1：已推送）
     */
    @EntityColumn(comment = "订单推送状态（0：未推送，1：已推送）")
    private Integer pushFlag;

    /**
     * 订单备注
     */
    @EntityColumn(comment = "订单备注")
    private String orderRemark;

    /**
     * 统计状态 0未处理 1已处理
     */
    @EntityColumn(comment = "统计状态 0未处理 1已处理")
    private Integer statisticsFlag;

    /**
     * 商家ID
     */
    @EntityColumn(comment = "商家ID")
    private String merchantId;

    /**
     * 商家名称
     */
    @EntityColumn(comment = "商家名称")
    private String merchantName;

    /**
     * 商家备注
     */
    @EntityColumn(comment = "商家备注")
    private String merchantRemark;

    /**
     * 订单日期
     */
    @EntityColumn(comment = "订单日期")
    private LocalDate orderDate;

    /**
     * 订单时间
     */
    @EntityColumn(comment = "订单时间")
    private LocalDateTime orderTime;

    /**
     * 代理商ID
     */
    @EntityColumn(comment = "代理商ID")
    private String agentId;

    /**
     * 代理商名称
     */
    @EntityColumn(comment = "代理商名称")
    private String agentName;

    /**
     * 取消原因备注
     */
    @EntityColumn(comment = "取消原因备注")
    private String cancelRemark;

    /**
     * 取消时间
     */
    @EntityColumn(comment = "取消时间")
    private LocalDateTime cancelTime;

    /**
     * 提货点ID
     */
    @EntityColumn(comment = "提货点ID")
    private String pickupLocationId;

    /**
     * 提货点名称
     */
    @EntityColumn(comment = "提货点名称")
    private String pickupLocationName;

    /**
     * 货柜ID
     */
    @EntityColumn(comment = "货柜ID")
    private String containerId;

    /**
     * 货柜名称
     */
    @EntityColumn(comment = "货柜名称")
    private String containerName;


}
