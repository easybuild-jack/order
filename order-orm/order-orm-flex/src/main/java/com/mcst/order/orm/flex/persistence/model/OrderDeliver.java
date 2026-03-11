package com.mcst.order.orm.flex.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.flex.persistence.BaseFlexEntity;
import com.mcst.order.api.dto.OrderDeliverDto;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单发货
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table("order_deliver")
@AutoMapper(target = OrderDeliverDto.class)
public class OrderDeliver extends BaseFlexEntity<OrderDeliver> {

    /**
     * 订单发货ID
     */
    @PrimaryKey
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String orderDeliverId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 快递单号
     */
    private String expressNo;

    /**
     * 快递公司编码
     */
    private String expressCompanyCode;

    /**
     * 快递公司
     */
    private String expressCompany;

    /**
     * 发货商户ID
     */
    private String merchantId;

    /**
     * 发货商户名称
     */
    private String merchantName;

    /**
     * 发货人ID
     */
    private String empId;

    /**
     * 发货人名称
     */
    private String empName;

    /**
     * 发货日期
     */
    private LocalDate deliveredDate;

    /**
     * 发货时间
     */
    private LocalDateTime deliveredTime;

    /**
     * 收货人名称
     */
    private String recipientsName;

    /**
     * 收货人手机号
     */
    private String recipientsPhone;

    /**
     * 收货地址的ID
     */
    private String recipientsAddressId;

    /**
     * 具体收货地址
     */
    private String address;

    /**
     * 地区
     */
    private String area;

    /**
     * 城市
     */
    private String city;

    /**
     * 省份
     */
    private String province;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态 0:待签收 1已签收
     */
    private Integer status;

    /**
     * 收货时间
     */
    private LocalDateTime receiveTime;

    /**
     * 快递费用
     */
    private BigDecimal postageAmount;

    /**
     * 快递费用模板ID
     */
    private String postageTemplateId;

    /**
     * 快递费用模板名称
     */
    private String postageTemplateName;

    /**
     * 订阅状态 0 未订阅 1已订阅
     */
    private Integer subscriptStatus;

    /**
     * 备注
     */
    private String remark;

}
