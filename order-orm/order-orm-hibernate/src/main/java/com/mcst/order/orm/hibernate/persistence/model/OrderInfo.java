package com.mcst.order.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.order.api.dto.OrderInfoDto;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

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
@Entity
@Table(name = "order_info")
@AutoMapper(target = OrderInfoDto.class)
public class OrderInfo extends BaseHibernateEntity {

    /**
     * 订单ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "order_id")
    private String orderId;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户第三方账号，如微信openid
     */
    @Column(name = "user_third_account")
    private String userThirdAccount;

    /**
     * 用户电话
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品SKU 名称
     */
    @Column(name = "goods_sku_name")
    private String goodsSkuName;

    /**
     * 商品图片
     */
    @Column(name = "goods_pic")
    private String goodsPic;

    /**
     * 商品总数量
     */
    @Column(name = "goods_count")
    private Integer goodsCount;

    /**
     * 总金额
     */
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 实际支付金额，实际需要支付的金额
     */
    @Column(name = "actual_pay_amount")
    private BigDecimal actualPayAmount;

    /**
     * 配送方式：0 自提 1 快递 2 虚拟商品 3 送货上门 99 送到货柜
     */
    @Column(name = "dispatch_type")
    private Integer dispatchType;

    /**
     * 是否要发票 0未开发票，1已开票
     */
    @Column(name = "invoice_flag")
    private Integer invoiceFlag;

    /**
     * 退款状态（0：未退款，1：全部退款，2：部分退款）
     */
    @Column(name = "refund_status")
    private Integer refundStatus;

    /**
     * 退款金额
     */
    @Column(name = "refund_amount")
    private BigDecimal refundAmount;

    /**
     * 买家备注
     */
    @Column(name = "user_remark")
    private String userRemark;

    /**
     * 订单状态（0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款）
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 订单渠道
     */
    @Column(name = "order_channel")
    private String orderChannel = "mall";

    /**
     * 客户端类型
     */
    @Column(name = "client_type")
    private String clientType;

    /**
     * 订单推送状态（0：未推送，1：已推送）
     */
    @Column(name = "push_flag")
    private Integer pushFlag;

    /**
     * 订单备注
     */
    @Column(name = "order_remark")
    private String orderRemark;

    /**
     * 统计状态 0未处理 1已处理
     */
    @Column(name = "statistics_flag")
    private Integer statisticsFlag;

    /**
     * 商家ID
     */
    @Column(name = "merchant_id")
    private String merchantId;

    /**
     * 商家名称
     */
    @Column(name = "merchant_name")
    private String merchantName;

    /**
     * 商家备注
     */
    @Column(name = "merchant_remark")
    private String merchantRemark;

    /**
     * 订单日期
     */
    @Column(name = "order_date")
    private LocalDate orderDate;

    /**
     * 订单时间
     */
    @Column(name = "order_time")
    private LocalDateTime orderTime;

    /**
     * 代理商ID
     */
    @Column(name = "agent_id")
    private String agentId;

    /**
     * 代理商名称
     */
    @Column(name = "agent_name")
    private String agentName;

    /**
     * 取消原因备注
     */
    @Column(name = "cancel_remark")
    private String cancelRemark;

    /**
     * 取消时间
     */
    @Column(name = "cancel_time")
    private LocalDateTime cancelTime;

    /**
     * 提货点ID
     */
    @Column(name = "pickup_location_id")
    private String pickupLocationId;

    /**
     * 提货点名称
     */
    @Column(name = "pickup_location_name")
    private String pickupLocationName;

    /**
     * 货柜ID
     */
    @Column(name = "container_id")
    private String containerId;

    /**
     * 货柜名称
     */
    @Column(name = "container_name")
    private String containerName;


}
